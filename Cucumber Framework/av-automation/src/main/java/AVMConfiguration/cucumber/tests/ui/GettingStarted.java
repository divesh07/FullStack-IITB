package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
import common.actions.constants;
import common.actions.LaunchBrowser;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.And;
//import cucumber.annotation.en.When;
//import cucumber.annotation.en.Then;

import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GettingStarted extends BaseClass{
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("^In GetStarted - Click GetStarted button")
    public void GetStarted(){
        WebElement GetStartedBtn = FFDriver.findElement(By.id("ft_getstarted"));
        GetStartedBtn.click();

    }
}
