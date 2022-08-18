package application.clientPlatform.tests;


import utilities.*;
import application.clientPlatform.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;


public class baseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    private googleAuth GoogleAuth;
    private signinPage SignInPage;
    private basePage BasePage;
    public String clientPaltformUrl = "https://qa-portal-staging.alphasights.com/sign-in";
    private String userEmail = "desmond.russell@alphasights.com";
    private String password = "@!ph4$1ghts_705";
    private String clientPlatUsername = "drussell0502+standardclient@gmail.com";
    private String clientPlatPassword = "@OnyxVIII2011";


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(clientPaltformUrl);
        GoogleAuth = new googleAuth(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.internalEmailInput));
        GoogleAuth.internalEmailInput.click();
        GoogleAuth.internalEmailInput.sendKeys(userEmail);
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.nextButton));
        GoogleAuth.nextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.passwordInput));
        GoogleAuth.passwordInput.click();
        GoogleAuth.passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(googleAuth.nextButton));
        GoogleAuth.nextButton.click();
        wait.until(ExpectedConditions.visibilityOf(GoogleAuth.twoStepScreenTitle));
    }

    @Test
    public void clientPlatformSignIn() throws InterruptedException {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(clientPaltformUrl));
        SignInPage = new signinPage(this.driver);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.acceptButton));
        SignInPage.acceptButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.clientPlatEmailInput));
        SignInPage.clientPlatEmailInput.click();
        SignInPage.clientPlatEmailInput.sendKeys(clientPlatUsername);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.nextButton));
        SignInPage.nextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.clientPlatPasswordInput));
        SignInPage.clientPlatPasswordInput.click();
        SignInPage.clientPlatPasswordInput.sendKeys(clientPlatPassword);
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.signInButton));
        SignInPage.signInButton.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
