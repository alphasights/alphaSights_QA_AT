package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



// page_url = https://accounts.google.com/o/oauth2/v2/auth/identifier?client_id=545637650224-n3gdg249lc2p88bg9t1sg33rhbmekk2f.apps.googleusercontent.com&redirect_uri=https%3A%2F%2Fqa-portal-staging.alphasights.com%2Foauth2%2Fidpresponse&response_type=code&scope=email%20profile%20openid&state=S7GCr68Kf0UWU8AecwM%2FWI2Fl7sF8fmDW8rTMOus28F1Q7aPOPQ7eyws%2FuG5yYTiZZ21GIhSWB%2BUTTGoJIOK77mhNETeQAuBXzfGMqnXnJgxJbivB3Gh7h7SNt9EE0ApNHpEV9ZWAKjElO9W0ZC19yBF3%2F3QK9bdv29VfeI96OtX88ThcBRZ9CjDHwvQHSikoXU3muDljYsBKJghFQ%3D%3D&hd=alphasights.com&flowName=GeneralOAuthFlow
public class googleAuth{
    private static WebDriver driver;

    //region Locators
    public googleAuth googleAuth;

    //Google Authentication screen elements
    @FindBy(id = "identifierId")
    public static WebElement internalEmailInput;

    @FindBy(xpath = "//span[text()='Next']")
    public static WebElement nextButton;

    @FindBy(name = "password")
    public static WebElement passwordInput;

    @FindBy(xpath = "//span[text()='2-Step Verification']")
    public static WebElement twoStepScreenTitle;
    //endregion

    //region Methods
    /*
    public googleAuth clickEmailInput()
    {
        googleAuth.internalEmailInput.click();
        return this;
    }

    public googleAuth enterEmail(String email)
    {
        googleAuth.internalEmailInput.sendKeys(email);
        return this;
    }

    public googleAuth clickNext()
    {
        googleAuth.nextButton.click();
        return this;
    }
    */
    //endregion


    public googleAuth(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}