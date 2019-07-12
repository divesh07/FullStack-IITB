package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.constants;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Storage extends BaseClass{
    public static final Logger log = Logger.getLogger(Storage.class);
    WebDriver FFDriver = GetFFDriver();

    @Then("^In Storage Tab - Check Storage Tab loaded")
    public void CheckStorageTabLoaded() {
        log.info("Wait till Storage Tab is loaded");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_datastores_sel_chosen")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("Storage tab is loaded");
    }

    @Then("^In Storage Tab - Select default storage for Appstacks")
    public void SelectDefaultStorageForAppstacks() {
        log.info("Select deafult storage for Appstacks");
        WebElement AppStackStorageLocation = FFDriver.findElement(By.id("ap_datastores_sel_chosen"));
        WebElement AppStackStorageResults = AppStackStorageLocation.findElement(By.className("chosen-search-input"));
        AppStackStorageResults.sendKeys(constants.Datastore + Keys.TAB);
    }

    @Then("^In Storage Tab - Select default storage for Writables")
    public void SelectDefaultStorageForWritables(){
        log.info("Select default storage for Writables");
        WebElement WVStorageLocation = FFDriver.findElement(By.id("wv_datastores_sel_chosen"));
        WebElement WVStorageResults = WVStorageLocation.findElement(By.className("chosen-search-input"));
        WVStorageResults.sendKeys(constants.Datastore + Keys.TAB);
    }

    @Then("^In Storage Tab - Click Next button in Storage Tab")
    public void ClickNextbtnInStorageTab(){
        log.info("Click Next button in Storage tab");
        WebElement StorageNextBtn = FFDriver.findElement(By.id("storage_config_save_button"));
        StorageNextBtn.click();
    }

    @Then("^In Storage Tab - Click Set Defaults button on Confirm storage settings dialog")
    public void ClickSetDefaultsbtn(){
        log.info("Wait till \"SetDefaults dialog is Opened\"");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog_set_datastore")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("Click SetDefaults button");
        WebElement SetDefaultsBtn = FFDriver.findElement(By.id("dialog_set_datastore"));
        SetDefaultsBtn.click();
    }

    @Then("^In Storage Tab - Select ESX Host to upload volumes")
    public void SelectESXHost(){
        log.info("wait till Templates page is opened");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("apptemplate_hosts")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("Select ESX host");
        Select HostIP = new Select(FFDriver.findElement(By.id("apptemplate_hosts")));
        HostIP.selectByValue(constants.ESXName);
    }

    @Then("^In Storage Tab - Enter ESX Username")
    public void EnterESXUsername(){
        log.info("Enter ESX Username");
        WebElement ESXUserName = FFDriver.findElement(By.id("apptemplate_username"));
        ESXUserName.sendKeys(constants.ESXUserName);
    }

    @Then("^In Storage Tab - Enter ESX Password")
    public void EnterESXPassword(){
        log.info("Enter ESX password");
        WebElement ESXPassword = FFDriver.findElement(By.id("apptemplate_password"));
        ESXPassword.sendKeys(constants.ESXPassword);
    }

    @Then("^In Storage Tab - Select all template check boxes to upload")
    public void SelectAllTemplatesToUpload(){
        log.info("Select all templates to upload");
        WebElement TemplatesSelection = FFDriver.findElement(By.id("apptemplate_list"));
        List<WebElement> CheckBoxList = FFDriver.findElements(By.name("upload_volumes"));
        for (WebElement Checkbox: CheckBoxList) {
            Checkbox.click();
        }
    }

    @Then("^In Storage Tab - Click Upload button in UploadPrepackageVolumes Tab")
    public void ClickUploadBtn(){
        log.info("Wait till upload button is enabled");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save_imp_apptemplate_btn")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("Click Upload button on UploadPrepackagedvolumes tab");
        WebElement UploadBtn = FFDriver.findElement(By.id("save_imp_apptemplate_btn"));
        UploadBtn.click();
    }

    @Then("^In Storage Tab - Click Upload button in Confirm Upload Prepackaged Volumes")
    public void ClickUploadBtnInConfirmUploadPrepackagedVolumes(){
        log.info("Wait till Confirm Upload dialog is opened");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog_prepackaged_volumes")));// instead of id u can use cssSelector or xpath of ur element.
        log.info("Click Upload button on confirm UploadPrepackaged Volumes dialog");
        WebElement Uploadbtn = FFDriver.findElement((By.id("dialog_prepackaged_volumes")));
        Uploadbtn.click();
    }
}

