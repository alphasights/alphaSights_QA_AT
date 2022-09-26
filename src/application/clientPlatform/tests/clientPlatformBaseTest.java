package application.clientPlatform.tests;

import utilities.*;
import application.clientPlatform.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeGroups;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.json.simple.*;
import org.json.simple.parser.*;


public class clientPlatformBaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    private googleAuth GoogleAuth;
    private signinPage SignInPage;
    private basePage BasePage;
    public String clientPaltformUrl = "https://qa-portal-staging.alphasights.com/sign-in";
    private String userDetails = "/Users/user/Documents/GitHub/alphaSights_QA_AT/resources/userDetails.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(userDetails));
    JSONObject jsonObject = (JSONObject)obj;
    //Setup google userDetails
    String googleUserName = (String)jsonObject.get("googleUser");
    String googlePassword = (String)jsonObject.get("googlePass");

    //Setup clientPlatform userDetails
    String clientPlatformUsername = (String)jsonObject.get("clientPlatformUsername");
    String clientPlatformPassword = (String)jsonObject.get("clientPlatformPassword");

    public clientPlatformBaseTest() throws IOException, ParseException {
    }


    @BeforeSuite
    public void setUp() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(clientPaltformUrl);
        GoogleAuth = new googleAuth(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.internalEmailInput));
        GoogleAuth.internalEmailInput.click();
        GoogleAuth.internalEmailInput.sendKeys(googleUserName);
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.nextButton));
        GoogleAuth.nextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.passwordInput));
        GoogleAuth.passwordInput.click();
        GoogleAuth.passwordInput.sendKeys(googlePassword);
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.nextButton));
        GoogleAuth.nextButton.click();
        wait.until(ExpectedConditions.visibilityOf(GoogleAuth.twoStepScreenTitle));
    }

    @BeforeGroups("standardLogin")
    public void clientPlatformSignIn() throws InterruptedException {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(clientPaltformUrl));
        SignInPage = new signinPage(this.driver);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.acceptButton));
        SignInPage.acceptButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.clientPlatEmailInput));
        SignInPage.clientPlatEmailInput.click();
        SignInPage.clientPlatEmailInput.sendKeys(clientPlatformUsername);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.nextButton));
        SignInPage.nextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.clientPlatPasswordInput));
        SignInPage.clientPlatPasswordInput.click();
        SignInPage.clientPlatPasswordInput.sendKeys(clientPlatformPassword);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.signInButton));
        SignInPage.signInButton.click();
    }

    @AfterSuite
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
