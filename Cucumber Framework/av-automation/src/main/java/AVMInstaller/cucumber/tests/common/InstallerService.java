package AVMInstaller.cucumber.tests.common;

import common.actions.BaseClass;
import common.actions.constants;
import common.actions.LaunchInstaller;
import common.actions.LaunchInstaller;
//import cucumber.annotation.en.And;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;


public class InstallerService extends BaseClass{
    public static final Logger log = Logger.getLogger(InstallerService.class);

    @Given("^Manager Installer")
    public void CheckForInstaller() throws Exception {
        File file = new File("C:\\343-master_3x\\setup.exe");
        if(!file.exists()){
            log.info("Installer not found");
            throw new Exception("Installer not found");
        }
        log.info("installer Found");
    }
    @And("^Installation Type is Default")
    public void InstallationTypeIsDefault(){
        //TO DO Read test type from jason file
    }

    @Then("Install Manager using Localdb")
    public void InstallManagerWithLocaldb() throws MalformedURLException {
        LaunchInstaller.LaunchAVMInstaller();
    }

    @And("^Installation Type is Remotedb")
    public void InstallationTypeIsRemotedb(){
        //TO DO Read test type from jason file
    }

    @Then("Install Manager using Remotedb")
    public void InstallManagerWithRemotedb() throws MalformedURLException {
        LaunchInstaller.LaunchAVMInstaller();
    }

    @And ("^Installation Type is Silent")
    public void InstallationTypeSilent(){

    }

    @Then("^Install Manager using SilentInstallCommand$")
    public void installManagerUsingSilentInstallCommand() {
    }

    @Then("^Start Manager installer")
    public void StartManagerInstallation() throws MalformedURLException, InterruptedException {
        Thread.sleep(10 * 1000);
        LaunchInstaller.LaunchAVMInstaller();
        WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();
    }


}
