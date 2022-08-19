package application.clientPlatform.tests.regressionFlows;

//import application.pistachio.pages.*;
import application.clientPlatform.tests.baseTest;
import application.delivery.pages.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.*;

import java.io.IOException;
import java.time.Duration;

public class newClientFlows extends baseTest
{
    public WebDriver driver;
    public WebDriverWait wait;
    private googleAuth GoogleAuth;

    public newClientFlows() throws IOException, ParseException {
    }


    @Test(groups = "regressionFlows")
    public void createNewClientPTO()
    {

    }

    @Test(groups = "regressionFlows")
    public void sendPortalInvitation()
    {

    }


}

