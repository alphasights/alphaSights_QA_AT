package application.delivery.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://qa-delivery.alphasights.com/dashboard
public class deliveryDashboardPage {
    //region Locators
    //region deliveryTopNav
    @FindBy(css ="ul.top-nav__items > li")
    public static List<WebElement> topNavElement;

    public static WebElement dashboard = topNavElement.get(0);
    public static WebElement whiteboardAndProjects = topNavElement.get(1);
    public static WebElement quickLinks = topNavElement.get(2);
    public static WebElement performance = topNavElement.get(3);
    public static WebElement resourceHub = topNavElement.get(4);
    public static WebElement commercialHub = topNavElement.get(5);
    public static WebElement deliverySearch = topNavElement.get(6);
    public static WebElement alphaSightsApps = topNavElement.get(7);
    public static WebElement userDropdown = topNavElement.get(8);
    //endregion

    //region teamsAndWhiteboardDropdown
    @FindBy(css = "div.select > select")
    public static WebElement teamsWhiteboadSelector;

    @FindBy()
    //endregion

    //region importantProjects
    //endregion


    //endregion

    public deliveryDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}