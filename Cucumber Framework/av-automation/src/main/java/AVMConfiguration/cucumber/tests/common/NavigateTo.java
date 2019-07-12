package AVMConfiguration.cucumber.tests.common;

import AVMConfiguration.cucumber.tests.ui.ADDomains;
import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateTo extends BaseClass{
    public static final Logger log = Logger.getLogger(ADDomains.class);
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("^Navigate to ADDomains Tab")
    public void NavigateToADDomainsTab() throws InterruptedException {
        Thread.sleep(10 * 1000);
        log.info("Clicking on Configuration tab");
        WebElement ConfigurationTab = FFDriver.findElement(By.id("configuration_btn"));
        ConfigurationTab.click();
        Thread.sleep(5 * 1000);
        log.info("Clicking on AD Domains tab");
        WebElement ADDomainsTab = FFDriver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        ADDomainsTab.click();
        Thread.sleep(5 * 1000);
    }

    @Then("^Navigate to License Tab")
    public void NavigateToLicenseTab() throws InterruptedException {

    }

    @Then("^Navigate to AdminRoles Tab")
    public void NavigateToAdminRolesTab() throws InterruptedException {

    }

    @Then("^Navigate to MachineManagers Tab")
    public void NavigateToMachineManagersTab() throws InterruptedException {
    }

    @Then("^Navigate to Storage Tab")
    public void NavigateToStorageTab() throws InterruptedException {
    }

    @Then("^Navigate to Settings Tab")
    public void NavigateToSettingsTab() throws InterruptedException {
    }

    @Then("^Navigate to Volumes Tab")
    public void NavigateToVolumesTab() throws InterruptedException {
    }

    @Then("^Navigate to Appstacks Tab")
    public void NavigateToAppstacksTab() throws InterruptedException {
    }

    @Then("^Navigate to Writables Tab")
    public void NavigateToWritablesTab() throws InterruptedException {
    }

    @Then("^Navigate to Directory Tab")
    public void NavigateToDirectoryTab() throws InterruptedException {
    }

    @Then("^Navigate to Infrastructure Tab")
    public void NavigateInfrastructureTab() throws InterruptedException {
    }

    @Then("^Navigate to Activity Tab")
    public void NavigateToActivityTab() throws InterruptedException {
    }
}
