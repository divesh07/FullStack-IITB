package AVMInstaller.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class DBSelection {
    WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();

    @Then("^Enter RemoteDb server name")
    public void EnterRemoteDBServerName(){
        WebElement DBServerDropDown = AVInstaller.findElement(By.id("39782"));
        DBServerDropDown.clear();
        DBServerDropDown.sendKeys("WIN-AM2K83FI30O\\SQLEXPRESS");
    }

    @Then("^Select Windows Authentication Type")
    public void SelectWindowsAuthentication(){
        WebElement WindowsAuthenticationRadiobtn = AVInstaller.findElement(By.name("Windows Integrated Authentication (automatically use this server's SYSTEM account)"));
        WindowsAuthenticationRadiobtn.click();
    }

    @Then(("^Select Server Authentication Type"))
    public void SelectServerAuthentication(){
        WebElement ServerAuthenticationRadiobtn = AVInstaller.findElement(By.name("Server authentication using the Login ID and password below"));
        ServerAuthenticationRadiobtn.click();
    }

    @Then("^Enter RemoteDb Server UserName")
    public void EnterRemoteDBUserName(){
        WebElement RemoteDBUserName = AVInstaller.findElement(By.id("39787"));
        RemoteDBUserName.sendKeys("sa");
    }

    @Then("^Enter RemoteDb Server Password")
    public void EnterRemoteDBPassword(){
        WebElement MngrMSI_RemoteDBPwd = AVInstaller.findElement(By.id("39785"));
        MngrMSI_RemoteDBPwd.sendKeys("ca$hc0w");
    }

    @Then("^Enter Database name")
    public void EnterDBName(){
        WebElement DBname = AVInstaller.findElement(By.id("39783"));
        DBname.sendKeys("CustomName");
    }

    @Then("^Select Overwrite existing db")
    public void OverWriteDB(){
        WebElement OverwriteDBCheckBox = AVInstaller.findElement(By.name("Overwrite existing database (if any)"));
        OverwriteDBCheckBox.click();
    }

    @Then("^Click Next in DB selection dialog")
    public void ClickNextInDBSelectionDialog() throws InterruptedException {
        WebElement MngrMSI_DBSrvrNextBtn = AVInstaller.findElement(By.name("Next >"));
        MngrMSI_DBSrvrNextBtn.click();
        Thread.sleep(30 * 1000);

    }


}
