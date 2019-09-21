package common.actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyElements {

    private final WebDriver driver;

    private static final Logger LOG = LoggerFactory.getLogger(VerifyElements.class);

    public VerifyElements(WebDriver driver) {
        this.driver = driver;
    }

    @Then("^verify page title is \"([^\"]*)\"$")
    public void verifyPageTitleSteps(String pageTitle) throws Throwable {
        UIActions.verifyPageTitle(driver, pageTitle);
        LOG.info("Verified page title is {}", pageTitle);
    }

    @And("^wait for (button|element|text|pop-up) \"([^\"]*)\" to exist$")
    public void waitForElementToExist(String pattern, String element) throws Throwable {
        waitForNumberOfElementsToExist(1, pattern, element);
    }

    @And("^wait for ([0-9]+) of (button|element|text|pop-up) \"([^\"]*)\" to exist$")
    public void waitForNumberOfElementsToExist(int number, String pattern, String element) throws Throwable {
        // text is a special case
        if (pattern.equals("text")) {
            LOG.info("Waiting for {} of {} {} to exist", number, pattern, element);
            element = "//*[contains(text(),\"" + element + "\")]";
            UIActions.waitForElementsExist(driver, element, number, (int)Constants.UI_IMPLICIT_WAIT);
            LOG.info("Waited for {} of {} {} to exist", number, pattern, element);
        } else if (WebElementMappingConstants.uiToTest.containsKey(element)) {
            LOG.info("Waiting for {} of {} {} to exist", number, pattern, element);
            UIActions.waitForElementsExist(driver, WebElementMappingConstants.uiToTest.get(element), number,
                    (int)Constants.UI_IMPLICIT_WAIT);
            LOG.info("Waited for {} of {} {} to exist", number, pattern, element);
        } else {
            throw new Exception("Element: " + element + " is not mapped to anything");
        }
    }

    @When("^click on (?:button|link|element): \"([^\"]*)\"$")
    public void clickOnElement(String element) throws Throwable {
        if (WebElementMappingConstants.uiToTest.containsKey(element)) {
            UIActions.scrollAndClick(driver, WebElementMappingConstants.uiToTest.get(element));
            LOG.info("Clicked on element {}", element);
        } else
            throw new Exception("Element: " + element + " is not mapped to anything");
    }
}
