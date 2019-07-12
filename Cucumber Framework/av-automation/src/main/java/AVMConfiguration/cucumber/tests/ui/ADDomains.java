package AVMConfiguration.cucumber.tests.ui;


import common.actions.BaseClass;
import common.actions.common;
import common.actions.constants;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ADDomains extends BaseClass{
    public static final Logger log = Logger.getLogger(ADDomains.class);
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("^In ADDomains Tab - Check ADDomains Tab loaded")
    public void CheckADDomainsTabLoaded() {
        log.info("Wait till ADDomains page is loaded");
        common.WaitForObjectEnabled("ad_domain_i");
//        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("ad_domain_i")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("ADDomains page is loaded");
    }

    @Then("^In ADDomains Tab - Enter Domain name")
    public void SetADDomain(){
        log.info("Enter Domain name");
        WebElement DomainName = FFDriver.findElement(By.id("ad_domain_i"));
        DomainName.sendKeys(constants.ADName + "." + constants.ADExtn);
    }

    @Then("^In ADDomains Tab - Enter Domain UserName")
    public void EnterDomainUserName(){
        log.info("Enter Domain user name");
        WebElement ADUserName = FFDriver.findElement(By.id("ad_username_i"));
        ADUserName.clear();
        ADUserName.sendKeys(constants.ADUserName);
    }

    @Then("^In ADDomains Tab - Enter Domain Password")
    public void EnterDomainPassword(){
        log.info("Enter Domain password");
        WebElement ADPassword = FFDriver.findElement(By.id("ad_password_i"));
        ADPassword.clear();
        ADPassword.sendKeys(constants.ADPassword);
    }

    @Then("^In ADDomains Tab - Enter Domain Controller Hosts details")
    public void EnterDomainControllerHostsList(){
        log.info("Enter Domain controller hosts list");
        WebElement DomainControllerHostList = FFDriver.findElement(By.id("ad_controller_hosts_i"));
        DomainControllerHostList.clear();
        DomainControllerHostList.sendKeys(constants.DomainControllerHostsList);
    }

    @Then("^In ADDomains Tab - Clear Domain Controller Hosts list")
    public void ClearDomainControllerHostsList(){
        log.info("Enter Domain controller hosts list");
        WebElement DomainName = FFDriver.findElement(By.id("ad_controller_hosts_i"));
        DomainName.clear();
    }

    @Then("^In ADDomains Tab - Set Security type as LDAP")
    public void SetSecutityTypeAs_LDAP(){
        log.info("Select Security type as LDAP");
        Select ADType = new Select(FFDriver.findElement(By.id("ad_security_s")));
        ADType.selectByValue("ldap");
    }

    @Then("^In ADDomains Tab - Set Security type as LDAPS")
    public void SetSecutityTypeAs_LDAPS(){
        log.info("Select Security type as LDAPS");
        Select ADType = new Select(FFDriver.findElement(By.id("ad_security_s")));
        ADType.selectByValue("ldaps");
    }

    @Then("^In ADDomains Tab - Set Security type as LDAP over TLS")
    public void SetSecutityTypeAs_LDAPOverTLS(){
        log.info("Select Security type as LDAP over TLS");
        Select ADType = new Select(FFDriver.findElement(By.id("ad_security_s")));
        ADType.selectByValue("ldap_tls");
    }

    @Then("^In ADDomains Tab - Check Disable certificate validation")
    public void DisableCertificateValidation(){
        log.info("Disabling certificate validation by selecting the checkbox \"Disable Certificate Validation\"");
        WebElement CertValidationCheckBox = FFDriver.findElement(By.id("ad_skip_cert_i"));
        CertValidationCheckBox.click();
    }

    @Then("^In ADDomains Tab - Click Register button in ADDomain Tab")
    public void ClickRegisterButton(){
        log.info("Clicking Register button");
        WebElement ADRegister = FFDriver.findElement(By.id("ad_save_or_update_button"));
        ADRegister.click();
    }

    @Then("^In ADDomains Tab - Check Domain bind is successful")
    public void CheckDomainBindIsSuccessful(){
        log.info("Wait till domain bind is successful");
        common.WaitForObjectEnabled("ad_next_button", constants.WAITONEMINUTE * 2);
//        WebDriverWait wait = new WebDriverWait(FFDriver, 120);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("ad_next_button")));// instead of id u can use cssSelector or xpath of ur element.
    }

    @Then("^In ADDomains Tab - Click Next button in ADDomain Tab")
    public void ClickNextBtnInADDomain(){
        log.info("Clicking Next button in ADDomains tab");
        WebElement NextBtn = FFDriver.findElement(By.id("ad_next_button"));
        NextBtn.click();
    }
    @Then("^In ADDomains Tab - Expand Domain details")
    public void ExpandRegisteredDomainDetails(){
        log.info("Expand registered domain details");
        WebElement AdTable = FFDriver.findElement(By.id("ad_datatable"));
        WebElement DomainPlusSymbol = AdTable.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr/td[1]/span"));
        DomainPlusSymbol.click();
    }
    @Then("^In ADDomains Tab - Click Edit button")
    public void ClickDomainEditButton() throws InterruptedException {
        Thread.sleep(5 * 1000);
        log.info("Click Edit button");
        WebElement AdTable = FFDriver.findElement(By.id("ad_datatable"));
        WebElement EditButton = AdTable.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr[2]/td/div/ul[1]/li[1]/button"));
        EditButton.click();
    }

    @Then("^In ADDomains Tab - Click Update button")
    public void ClickUpdateButton(){
        log.info("Click Update button");
        WebElement UpdateButton = FFDriver.findElement(By.id("ad_save_or_update_button"));
        UpdateButton.click();

    }
    @Then("^In ADDomains Tab - Check only provided DomainControllers are connected")
    public void GetNumberOfDomainControllersConnected() throws Exception {
        Thread.sleep(3*1000);
        log.info("Expand registered domain details");
        WebElement AdTable = FFDriver.findElement(By.id("ad_datatable"));
        WebElement DomainPlusSymbol = AdTable.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr/td[1]/span"));
        DomainPlusSymbol.click();
        log.info("Click ShowDCs button");
        WebElement ShowDCsButton = FFDriver.findElement(By.id("view_dcs_button"));
        ShowDCsButton.click();
        Thread.sleep(3*1000);
        WebElement TogetRows = FFDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr[2]/td/div/div[2]/div/div/table/tbody"));
        ///html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr[2]/td/div/div[2]/div/div/table/tbody
        List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        log.info("Total number of Rows in the table are : "+ TotalRowsList.size());
        if(TotalRowsList.size() != constants.NumberOfDomainControllersInManualMode) {
            log.error("Number of Domain Controllers doesn't match");
            throw new Exception("Number of Domain Controllers doesn't match");
        }
    }

    @Then("^In ADDomains Tab - Check all the DomainControllers are connected")
    public void GetNumberOfDomainControllersConnected1() throws Exception {
//        Thread.sleep(3*1000);
//        log.info("Expand registered domain details");
//        WebElement AdTable = FFDriver.findElement(By.id("ad_datatable"));
//        WebElement DomainPlusSymbol = AdTable.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr/td[1]/span"));
//        DomainPlusSymbol.click();
//        log.info("Click ShowDCs button");
//        WebElement ShowDCsButton = FFDriver.findElement(By.id("view_dcs_button"));
//        ShowDCsButton.click();
//        Thread.sleep(3*1000);
//        WebElement TogetRows = FFDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr[2]/td/div/div[2]/div/div/table/tbody"));
//        ///html/body/div[1]/div/div/div[2]/div/section/div[2]/div[3]/div/table/tbody/tr[2]/td/div/div[2]/div/div/table/tbody
//        List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));
//        log.info("Total number of Rows in the table are : "+ TotalRowsList.size());
//        if(TotalRowsList.size() != constants.NumberOfDomainControllersInManualMode) {
//            log.error("Number of Domain Controllers doesn't match");
//            throw new Exception("Number of Domain Controllers doesn't match");
//        }
    }
}
