package common.actions;

import common.actions.BaseClass;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchInstaller extends BaseClass{

    public static void  LaunchAVMInstaller() throws MalformedURLException {
        BaseClass.LaunchAVInstaller();
        //WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();
    }

}
