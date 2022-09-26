package application.delivery.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://qa-delivery.alphasights.com/dashboard
public class deliveryDashboardPage {
    //region Locators
    //region teamsAndWhiteboardDropdown
    @FindBy(css = "div.select > select")
    public static WebElement teamsWhiteboadSelector;


    //endregion

    //region importantProjects
    //endregion


    //endregion

    public deliveryDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}