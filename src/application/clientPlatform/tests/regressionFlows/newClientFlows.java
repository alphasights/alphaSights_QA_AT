package application.clientPlatform.tests.regressionFlows;

//import application.pistachio.pages.*;
import application.clientPlatform.tests.clientPlatformBaseTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.*;

import java.io.IOException;

public class newClientFlows extends clientPlatformBaseTest
{
    public WebDriver driver;
    public WebDriverWait wait;
    private googleAuth GoogleAuth;

    public newClientFlows() throws IOException, ParseException {
    }


    @Test(groups = "regressionFlows, flowA", description = "Create a New Client in PTO")
    public void createNewClientPTOAndSendPortalInvite1()
    {


    }

    @Test(groups = "regressionFlows, flowA", description = "Sendf initial portal invitation")
    public void createNewClientPTOAndSendPortalInvite2()
    {

    }


}

