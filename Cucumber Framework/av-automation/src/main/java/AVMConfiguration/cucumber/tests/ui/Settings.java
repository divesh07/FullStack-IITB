package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    WebDriver FFDriver = BaseClass.GetFFDriver();
    @Then("^In Settings Tab - Click Save button in Settings Tab")
    public void SetSettings(){
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("settings_save_button")));// instead of id u can use cssSelector or xpath of ur element.
        WebElement SettingsSaveBtn = FFDriver.findElement(By.id("settings_save_button"));
        SettingsSaveBtn.click();

    }
}
