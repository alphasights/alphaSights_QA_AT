package application.clientPlatform.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class basePage {
    //driver creation
    private static WebDriver driver;
    //region topNav
    //region Locators
    @FindBy(css = "div.lg:aui-px-16.aui-px-8.aui-flex.aui-flex-col.aui-flex-grow")
    public static WebElement topNavDiv;

    @FindBy(linkText = "Content")
    public static WebElement contentLink;

    @FindBy(linkText = "Projects")
    public static WebElement projectLink;

    @FindBy(linkText = "Schedule")
    public static WebElement scheduleLink;

    @FindBy(linkText = "Service")
    public static WebElement serviceLink;

    @FindBy(css = "div.sc-cxNHIi.dmQhjz > svg > path")
    public static WebElement infoIcon;

    @FindBy(css = "div.sc-cxNHIi.eyxvFj > span > p")
    public static WebElement userDropdown;

    @FindBy(css = "div > a.aui-block.aui-no-underline.aui-text-grey-5")
    public static List<WebElement> projectSubLinks;
    //endregion
    //endregion

    public basePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}