package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.constants;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class License extends BaseClass {
    public static final Logger log = Logger.getLogger(License.class);
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("In License Tab - Check License Tab Loaded")
    public void CheckLicenseTabLoaded(){
        log.info("Checking if License tab is loaded");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("license_next_btn")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("License tab is loaded");
    }
    @Then("^In License Tab - Click Next button in License Tab")
    public void ClickNextInLicensetab(){
        log.info("Click Next button");
        WebElement NextBtn = FFDriver.findElement(By.id("license_next_btn"));
        NextBtn.click();
    }

    @Then("^in License Tab - Click Edit button")
    public void ClickEditButton(){
        log.info("Click Edit button");
        WebElement EditBtn = FFDriver.findElement(By.id("edit_license_btn"));
        EditBtn.click();
    }

    @Then("^in License Tab - Enter license file path")
    public void EnterLicenseFilePath(){
        log.info("Enter License file path");
        WebElement LicensePath = FFDriver.findElement(By.id("upload_license_key"));
        LicensePath.sendKeys(constants.LicenseFilePath);
    }

    @Then("^in License Tab - Click Upload button")
    public void ClickUploadButton(){
        log.info("Click upload button");
        WebElement UploadBtn = FFDriver.findElement(By.id("license_upload_btn"));
        UploadBtn.click();
    }

}
