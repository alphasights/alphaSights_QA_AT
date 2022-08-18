package application.clientPlatform.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://qa-portal-staging.alphasights.com/sign-in
public class signinPage{

    //region Locators
    //region cookieNotice
    @FindBy(css = "div.iubenda-cs-container")
    public static WebElement cookieNotice;
    @FindBy(xpath = "//button[text()='x']")
    public static WebElement closeButton;

    @FindBy(xpath = "//button[text()='Accept']")
    public static WebElement acceptButton;

    @FindBy(xpath = "//button[text()='Reject']")
    public static WebElement rejectButton;

    @FindBy(xpath = "//button[text()='Learn more and customize']")
    public static WebElement learnMoreButton;
    //endregion

    //region signIn Modal
    @FindBy(name = "email")
    public static WebElement clientPlatEmailInput;

    @FindBy(xpath = "//button[text()='Next']")
    public static WebElement nextButton;

    @FindBy(linkText = "Contact technical support.")
    public static WebElement contactSupportLink;

    @FindBy(name = "password")
    public static WebElement clientPlatPasswordInput;

    @FindBy(css = "button.aui-border.aui-bg-grey-5")
    public static WebElement signInButton;

    //Other SignIn modal elements

    //endregion




    //endregion

    public signinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}