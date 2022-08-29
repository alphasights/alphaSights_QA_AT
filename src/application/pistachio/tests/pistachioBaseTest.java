package application.pistachio.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.*;
import application.delivery.pages.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class pistachioBaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    private googleAuth GoogleAuth;
    public String pistachioUrl = "https://qa-pistachio.alphasights.com/";
    public String deliveryDashUrl = "https://qa-delivery.alphasights.com/dashboard";
    private String userDetails = "/Users/user/Documents/GitHub/alphaSights_QA_AT/resources/userDetails.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(userDetails));
    JSONObject jsonObject = (JSONObject)obj;
    //Setup google userDetails
    String googleUserName = (String)jsonObject.get("googleUser");
    String googlePassword = (String)jsonObject.get("googlePass");
    //pistachio relies on Google auth for SSO
    private deliveryDashboardPage DeliveryDashboardPage;


    public pistachioBaseTest() throws IOException, ParseException {
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(pistachioUrl);
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

    @Test
    //@BeforeGroups("")
    public void navigateToPistachio(){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(deliveryDashUrl));
        DeliveryDashboardPage = new deliveryDashboardPage(this.driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(getTopNavElements()));
        wait.until(ExpectedConditions.elementToBeClickable(getTopNavElements().userDropdown));
        DeliveryDashboardPage.userDropdown.click();
    }

    public List<WebElement> getTopNavElements(){
        //region deliveryTopNav
        List<WebElement> topNavElement = ;
        topNavElement = null;

        WebElement dashboard = topNavElement.get(0);
        WebElement whiteboardAndProjects = topNavElement.get(1);
        WebElement quickLinks = topNavElement.get(2);
        WebElement performance = topNavElement.get(3);
        WebElement resourceHub = topNavElement.get(4);
        WebElement commercialHub = topNavElement.get(5);
        WebElement deliverySearch = topNavElement.get(6);
        WebElement alphaSightsApps = topNavElement.get(7);
        WebElement userDropdown = topNavElement.get(8);
        //endregion
        return topNavElement;
    }

    @AfterSuite
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
