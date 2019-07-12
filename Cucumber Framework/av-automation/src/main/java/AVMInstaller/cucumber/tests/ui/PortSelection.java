package AVMInstaller.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class PortSelection {
    WiniumDriver AVInstaller = BaseClass.GetWiniumDriver();

    @Then("^Change HttpsPort to 3443")
    public void AllowHttp(){
        WebElement AllowHttp = AVInstaller.findElement(By.name("Allow connections over HTTP (insecure)"));
        AllowHttp.click();
    }

    @Then("^Select Allow connections over HTTP checkbox")
    public void SetHttpsPort(){
        WebElement HttpsPort = AVInstaller.findElement(By.id("41043"));
        HttpsPort.sendKeys("3443");
    }

    @Then("^Click Next button in Network port dialog")
    public void ClickNextInNetworkPort() throws InterruptedException {
        WebElement MngrMSI_NtwrkPortNextBtn = AVInstaller.findElement(By.name("Next >"));
        MngrMSI_NtwrkPortNextBtn.click();
        Thread.sleep(15 * 1000);
    }
}
