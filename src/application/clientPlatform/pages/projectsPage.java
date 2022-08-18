package application.clientPlatform.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://qa-portal-staging.alphasights.com/my-projects
public class projectsPage {
    // No page elements added
    //driver creation
    private static WebDriver driver;

    //region Locators
    //region activeProjects
    @FindBy(css = "div.aui-flex.aui-flex-col.aui-space-y-2 > div > a.aui-cursor-pointer.aui-no-underline.hover\\:aui-text-primary-2.aui-text-dark-1")
    public static List<WebElement> projectTitleLinks;

    @FindBy(xpath = "//p[text()='Scheduled']")
    public static List<WebElement> projectScheduled;

    @FindBy(xpath = "//p[text()='Completed']")
    public static List<WebElement> projectCompleted;

    @FindBy(xpath = "//p[text()='Highly Recommended']")
    public static List<WebElement> highlyRecommendedProject;

    @FindBy(xpath = "//p[text()='Starred by You' ]")
    public static List<WebElement> projectStarredByYou;

    @FindBy(xpath = "//span[text()='View All Experts']")
    public static List<WebElement> projectViewAllExperts;

    @FindBy(xpath = "//span[text()='Excel']")
    public static List<WebElement> downloadProjExcel;

    @FindBy(xpath = "//span[text()='Usage']")
    public static List<WebElement> projectUsage;

    //@FindBy(xpath = "//")


    //endregion

    //region pastProjects

    //endregion

    //endregion

    public projectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}