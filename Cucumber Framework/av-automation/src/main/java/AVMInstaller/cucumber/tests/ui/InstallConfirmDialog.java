package AVMInstaller.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class InstallConfirmDialog {
    WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();
    @Then("^Click Install button")
    public void ClickInstallButton(){
        WebElement InstallBtn = AVInstaller.findElement(By.name("Install"));
        InstallBtn.click();
    }
}
