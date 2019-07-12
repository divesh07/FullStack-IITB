package common.actions;

import com.vmware.vim25.mo.ServiceInstance;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.awt.image.VolatileImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.PublicKey;

public class BaseClass {

    private static WebDriver FFDriver;
    private static WiniumDriver AVInstallerDriver;
    private static ServiceInstance ESXInstance;
    public static final Logger log = Logger.getLogger(BaseClass.class);

    public static void LaunchFirefox(){
        log.info("Launching Firefox");
        System.setProperty("webdriver.gecko.driver", constants.PathToGeckoDriver);
        FFDriver = new FirefoxDriver();
    }

    public static void LaunchAVInstaller() throws MalformedURLException {
        DesktopOptions option = new DesktopOptions();
        option.setDebugConnectToRunningApp(true);
        option.setApplicationPath(constants.AVMInstallerPath);
        option.setLaunchDelay(5);
        AVInstallerDriver = new WiniumDriver( new URL("http://localhost:9999"), option);
    }

    public static void ConnectToESX() throws MalformedURLException, RemoteException {
        //ESXInstance = new ServiceInstance(new URL("https://10.112.19.9/sdk"), "root", "vmw", true);
        common.ConnectToVC();
    }


    public static WebDriver GetFFDriver(){log.info("Returning driver"); return FFDriver;}
    public static WiniumDriver GetWiniumDriver(){log.info("Returning Winium driver"); return AVInstallerDriver;}
    public static ServiceInstance GetESXHost(){log.info("Returning ESX host instance"); return ESXInstance;}
    public static final Logger GetLogger(){return log;}
}
