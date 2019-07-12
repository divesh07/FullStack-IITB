package AVMConfiguration.cucumber.tests.common;

import common.actions.BaseClass;
import common.actions.constants;
import common.actions.common;
import common.actions.LaunchBrowser;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.*;


public class BrowserlaunchService extends BaseClass{
    public static final Logger log = Logger.getLogger(BrowserlaunchService.class);
    //WebDriver FFDriver = BaseClass.GetFFDriver();

    //public static final Logger log = Logger.getLogger(LaunchBrowser.class);
    @Given("^Manager Service is running")
    public boolean CheckManagerServiceRunning() throws IOException {
        log.info("Searching for AppVolumes service");
        Process process = Runtime.getRuntime().exec("sc query \"Airwatch Service\"");
        Scanner reader = new Scanner(process.getInputStream(), "UTF-8");
        while(reader.hasNextLine())
            if(reader.nextLine().contains("Airwatch Service")) {
                log.info("Found AppVolumes service");
                return true;
            }
        return false;
    }

    @Given("^Firefox Browser")
    public void LaunchFirefoxSession() throws MalformedURLException, RemoteException {
        //ConnectToESX();
        LaunchBrowser.LaunchBrowserSession();
    }

    @And("^Manager listening at IP$")
    public void ManagerListeningAtIP() {
        LaunchBrowser.LaunchBrowserSession();
        WebDriver FFDriver = GetFFDriver();
        FFDriver.get(constants.Manager_IP);
        FFDriver.manage().window().maximize();
        String ManagerUITitle = FFDriver.getTitle();
    }


}

