package application.clientPlatform.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://qa-portal-staging.alphasights.com/content
public class contentPage{
    //driver creation
    private static WebDriver driver;
    //
    //
    //region Locators
    //region AlphaNow
    //Transcript search
    @FindBy(css = "div.css-1wa3eu0-placeholder")
    public static WebElement transcriptSearch;

    //Filters
    @FindBy(xpath = "//div[text() = 'Date']")
    public static WebElement dateFilter;

    @FindBy(xpath = "//div[text() = 'Group']")
    public static WebElement groupFilter;

    @FindBy(xpath = "//div[text() = 'Purchased']")
    public static WebElement purchasedFilter;

    @FindBy(xpath = "//div[@data-test-id= 'bookmark-filter-button']")
    public static WebElement bookmarkFilter;

    @FindBy(xpath = "//div[@data-test-id= 'content-card']")
    public static List<WebElement> contentCard;

    //endregion
    //endregion



    public contentPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
}