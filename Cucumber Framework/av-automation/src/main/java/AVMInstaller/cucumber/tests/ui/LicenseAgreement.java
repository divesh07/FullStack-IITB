package AVMInstaller.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.LaunchInstaller;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class LicenseAgreement {
    //public static final org.apache.log4j.Logger log = Logger.getLogger(LaunchInstaller.class);
    WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();

    @Then("^Check if Manager installer dialog opened")
    public void CheckIfAVinstallerStarted(){
        WebElement Nextbtn = AVInstaller.findElement(By.name("Next >"));
    }

    @Then("^Click Next in Start Manager Installation dialog")
    public void ManagerInstallationWizard() throws InterruptedException {
        WebElement Nextbutton = AVInstaller.findElement(By.name("Next >"));
        Nextbutton.click();
        Thread.sleep(10 * 1000);
    }

    @Then("^Accept License agreement")
    public void LicenseAgreement(){
        WebElement AcceptLicenseRadioBtn = AVInstaller.findElement(By.name("I accept the terms in the license agreement"));
        AcceptLicenseRadioBtn.click();
    }

    @Then("^Click Next in License dialog")
    public void ClickNextBtn() throws InterruptedException {
        WebElement LicensePage_NextBtn = AVInstaller.findElement(By.name("Next >"));
        LicensePage_NextBtn.click();
        Thread.sleep(10 * 1000);
    }
}
