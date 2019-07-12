package AVMInstaller.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class InstallationLocation {
    WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();

    @Then("^Click Next button Installation Destination selection dialog")
    public void ClickNextInstallDestinationSelection() throws InterruptedException {
        WebElement MngrMSI_DestinationNextBtn = AVInstaller.findElement(By.name("Next >"));
        MngrMSI_DestinationNextBtn.click();
        Thread.sleep(15 * 1000);

    }
}
