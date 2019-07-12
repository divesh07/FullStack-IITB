package AVMConfiguration.cucumber.tests.ui;

import common.actions.BaseClass;
//import cucumber.annotation.en.Then;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminRoles extends BaseClass{
    public static final Logger log = Logger.getLogger(AdminRoles.class);
    WebDriver FFDriver = BaseClass.GetFFDriver();

    @Then("^In AdminRoles Tab - Check Admin Roles Tab loaded")
    public void CheckADminRolesTabLoaded() {
        log.info("Wait till Admin Roles page is loaded");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("role_assignment_search_field")));// instead of id u can use cssSelector or xpath of ur element.
    }
    @Then("^In AdminRoles Tab - Search for Admin Group")
    public void SearchAdminGroup() {
        log.info("Enter admin group name to search");
        WebElement AdminGroupSearch = FFDriver.findElement(By.id("role_assignment_search_field"));
        AdminGroupSearch.sendKeys("Domain Admins");
    }

    @Then("^In AdminRoles Tab - Click Search button")
    public void ClickSearchButton(){
        log.info("Click search button");
        WebElement AdminSearchBtn = FFDriver.findElement(By.id("role_assignment_search_button"));
        AdminSearchBtn.click();
        log.info("Wait till search is complete");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ra_save_or_update_button")));// instead of id u can use cssSelector or xpath of ur element.
    }

    @Then("^In AdminRoles Tab - Click Assign button")
    public void ClickAssignButton(){
        log.info("Click Assign button");
        WebElement AdminRoleAssignBtn = FFDriver.findElement(By.id("ra_save_or_update_button"));
        AdminRoleAssignBtn.click();
        log.info("Wait till the Assigning the admin group is complete");
        WebDriverWait wait = new WebDriverWait(FFDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("roles_next_button")));// instead of id u can use cssSelector or xpath of ur element.
    }

    @Then("^In AdminRoles Tab - Click Next button in AdminRole")
    public void ClickNextButtonInAdminRole(){
        log.info("Click Next button in AdminRoles tab");
        WebElement AdminRoleNextbtn = FFDriver.findElement(By.id("roles_next_button"));
        AdminRoleNextbtn.click();
    }


}
