package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.constants;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MachineManager {
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("^In MachineManager Tab - Check MachineManagers Tab loaded")
    public void CheckMachineManagerTabLoaded() {
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hyp_hostname_i")));// instead of id u can use cssSelector or xpath of ur element.
    }

    @Then("^In MachineManager Tab - Select Machine Manager Type as VCenter")
    public void SelectMachineManagerType(){
        Select MMType = new Select(FFDriver.findElement(By.id("hyp_type_i")));
        MMType.selectByValue("vcenter");
    }

    @Then("^In MachineManager Tab - Enter VCenter Hostname")
    public void EnterVCHostName(){
        WebElement VCHostName = FFDriver.findElement(By.id("hyp_hostname_i"));
        VCHostName.sendKeys(constants.VCName);
    }

    @Then("^In MachineManager Tab - Enter VCenter Username")
    public void EnterVCUserName(){
        WebElement VCUserName = FFDriver.findElement(By.id("hyp_username_i"));
        VCUserName.sendKeys(constants.VCUserName);
    }

    @Then("^In MachineManager Tab - Enter VCenter Password")
    public void EnterVCPassword(){
        WebElement VCPassword = FFDriver.findElement(By.id("hyp_password_i"));
        VCPassword.sendKeys(constants.VCPassword);
    }

    @Then("^In MachineManager Tab - Click Save button in Machine Managers Tab")
    public void ClickSaveButtoninMachineManager(){
        WebElement VCSaveBtn = FFDriver.findElement(By.id("hyp_config_save_button"));
        VCSaveBtn.click();
    }

    @Then("^In MachineManager Tab - Click Accept button on VCenter certificate dialog")
    public void AcceptVCCertificate(){
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog_confirm_hypervisor_change")));// instead of id u can use cssSelector or xpath of ur element.
        WebElement VCCertAcceptBtn = FFDriver.findElement(By.id("dialog_confirm_hypervisor_change"));
        VCCertAcceptBtn.click();
    }

    @Then("^In MachineManager Tab - Click Next button in Machine Managers Tab")
    public void ClickNextbtnInMachineManager(){
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ft_next_btn")));// instead of id u can use cssSelector or xpath of ur element.
        WebElement VCNextBtn = FFDriver.findElement(By.id("ft_next_btn"));
        VCNextBtn.click();
    }

}
