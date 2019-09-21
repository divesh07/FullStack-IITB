package common.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedDriver extends EventFiringWebDriver {

    private static final Logger LOG = LoggerFactory.getLogger(SharedDriver.class);

    public static WebDriver driver;

    //public static final String WEBDRIVER_DOWNLOAD_PATH = Constants.DOWNLOAD_LOCATION;

    private static final String WEBDRIVER_DOWNLOAD_PATH = "src/main/resources/Driver/geckodriver.exe";

    public SharedDriver() throws Throwable {
        super(getBrowserDriver());
    }

    public static WebDriver getBrowserDriver() throws Throwable {
        /*FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir", WEBDRIVER_DOWNLOAD_PATH);
        profile.setPreference("extensions.netmonitor.har.enableAutomation", true);
        profile.setPreference("startup.homepage_welcome_url", "about:blank");
        profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        profile.setPreference("browser.startup.homepage", "about:blank");
        profile.setAcceptUntrustedCertificates(true);
        */
        System.setProperty("webdriver.gecko.driver", WEBDRIVER_DOWNLOAD_PATH);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
