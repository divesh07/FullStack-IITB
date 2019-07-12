package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.LaunchBrowser;
import common.actions.common;
import common.actions.constants;
//import cucumber.annotation.en.And;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseClass{
    public static final Logger log = Logger.getLogger(ADDomains.class);
    WebDriver FFDriver = GetFFDriver();

    @And("^In Login Page - Open AppVolumes Login Page")
    public void OpenAppVolumesLogin() throws InterruptedException {
        FFDriver.get(constants.Manager_IP);
        FFDriver.manage().window().maximize();
        log.info("Wait till Login page is loaded");
        common.WaitForObjectEnabled("user_account_name");
        //Thread.sleep(10 * 1000);
        log.info("ADDomains page is loaded");
    }

    @Then("^In Login Page - Enter Login and Password")
    public void EnterUsernamePassword(){
        log.info("Enter UserName");
        WebElement LoginName = FFDriver.findElement(By.id("user_account_name"));
        LoginName.sendKeys(constants.AVloginName);
        log.info("Enter Password");
        WebElement LoginPwd = FFDriver.findElement(By.id("user_password"));
        LoginPwd.sendKeys(constants.AVLoginPwd);
        log.info("ADDomains page is loaded");
    }

    @Then("^In Login Page - Select the Login Domain")
    public void SelectDomainName(){
        log.info("Selecting Domain");
        Select DomainName = new Select(FFDriver.findElement(By.id("user_domain_name")));
        DomainName.selectByValue("BLRAUTO");
    }

    @Then("^In Login Page - Click Login")
    public void ClickLogin(){
        log.info("Clicking Login button");
        WebElement LoginBtn = FFDriver.findElement(By.id("login_btn"));
        LoginBtn.click();
    }



}
