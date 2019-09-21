package common.actions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class UIActions {
    private static final String SCRIPT_PATH = "src/main/resources/JavaScripts/waitForAngular.js";

    private static final Logger LOG = LoggerFactory.getLogger(UIActions.class);

    public static void loginPage(WebDriver driver, String url) throws Throwable {
        driver.get(url);
    }

    /*
     * This method waits for the title of the page loaded in driver to contain pageTitle. If the correct pageTitle is loaded
     * before the time out, the verification succeeds, if not, it will time out and fail.
     */
    public static void verifyPageTitle(WebDriver driver, String pageTitle) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.UI_IMPLICIT_WAIT);
            wait.until(ExpectedConditions.titleContains(pageTitle));
        } catch (TimeoutException handled) {
            throw new Exception("Verification failed - Expected Page title:" + pageTitle + " Actual Page title:"
                    + driver.getTitle() + " ", handled);
        }
    }

    public static void waitForPageLoaded(WebDriver driver, int timeout) throws Exception {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(expectation);
    }

    public static void verifyElementState(WebDriver driver, String element, boolean expectedState) throws Exception {
        boolean elementState = findElement(driver, element).isEnabled();
        if (elementState != expectedState) {
            throw new Exception(element + " Verification failed - Expected State:" + expectedState + " Actual State:"
                    + elementState);
        }
    }

    /**
     * Returns the first WebElement in the list of web elements that can be identified by the given element string. Throws a
     * customized Exception if no such element exists.
     * <p>
     * NOTE: assuming that we use unique identifiers for each web element on a page, we can safely use this to find unique
     * elements.
     *
     * @param driver
     * @param element
     * @return WebElement
     * @throws Exception
     */
    public static WebElement findElement(WebDriver driver, String element) throws Exception {
        return findElement(driver, element, (int) Constants.UI_IMPLICIT_WAIT);
    }

    /**
     * Find an element within the given timeout. Throws Exception when no element can be found in the given time.
     *
     * @param driver
     * @param element
     * @param timeoutInSec
     * @return
     * @throws Exception
     */
    public static WebElement findElement(WebDriver driver, String element, int timeoutInSec) throws Exception {
        ExpectedCondition<WebElement> expectedCondition = new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {
                List<WebElement> elements;
                try {
                    elements = findElements(driver, element);
                } catch (Exception e) {
                    return null;
                }
                if (elements != null && elements.size() > 0) {
                    return elements.get(0);
                }
                return null;
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
        return wait.until(expectedCondition);
    }

    /**
     * Returns all WebElements in the list of web elements that can be identified by the given element string. Throws a customized
     * Exception if no such elements exist.
     *
     * @param driver
     * @param element
     * @return WebElement
     * @throws Exception
     */
    public static List<WebElement> findElements(WebDriver driver, String element) throws Exception {
        List<WebElement> elements = findElementsNoExceptionIfNull(driver, element);
        if (elements != null) {
            return elements;
        } else {
            throw new Exception("Element/s identified by expression " + element + " not found");
        }
    }

    /**
     * Returns all WebElements in the list of web elements that can be identified by the given element string. Returns null if no
     * such elements exist. .
     *
     * @param driver
     * @param element
     * @return List<WebElement>
     */
    public static List<WebElement> findElementsNoExceptionIfNull(WebDriver driver, String element) throws Exception {
        int attempts = 0;
        while (attempts < Constants.MAX_FIND_ELEMENT_ATTEMPTS) {
            try {
                return findElementsOnce(driver, element);
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new StaleElementReferenceException("Caused by element " + element);
    }

    /**
     * Returns a list of WebElements that can be identified by the given element string. Returns null if no elements can be found
     * using the expression passed.
     * <p>
     * NOTE#1: this is highly unlikely but it is possible for the wrong elements to be identified by mistake (for example, if an
     * element's id has the form of another element's xpath identifier)
     * <p>
     * NOTE#2: we strongly encourage finding elements by xpath for best performance of this method
     *
     * @param driver
     * @param element
     * @return List<WebElement>
     */
    public static List<WebElement> findElementsOnce(WebDriver driver, String element) throws Exception {
        int timeout;
        int elementSearchTimeout;

        elementSearchTimeout = Constants.AUTO_REFRESH_UI_IMPLICIT_WAIT_SECONDS;
        driver.manage().timeouts().implicitlyWait(elementSearchTimeout, TimeUnit.SECONDS);
        ArrayList<By> selectors = new ArrayList<By>();
        selectors.add(By.xpath(element));
        selectors.add(By.id(element));
        selectors.add(By.cssSelector(element));
        selectors.add(By.linkText(element));
        for (By selector : selectors) {
            try {
                List<WebElement> elements = driver.findElements(selector);
                if (elements.size() > 0) {
                    driver.manage().timeouts().implicitlyWait(Constants.UI_IMPLICIT_WAIT, TimeUnit.SECONDS);
                    return elements;
                }
            } catch (InvalidSelectorException ignored) {
            }
        }
        driver.manage().timeouts().implicitlyWait(Constants.UI_IMPLICIT_WAIT, TimeUnit.SECONDS);
        return null;
    }

    public static void verifyElementStateById(WebDriver driver, String element, boolean expectedState) throws Exception {
        boolean elementState = driver.findElement(By.id(element)).isEnabled();
        if (elementState != expectedState) {
            throw new Exception(element + " Verification failed - Expected State:" + expectedState + " Actual State:"
                    + elementState);
        }
    }

    public static void verifyElementStateByCSSSelector(WebDriver driver, String element, boolean expectedState) throws Exception {
        boolean elementState = driver.findElement(By.cssSelector(element)).isEnabled();
        if (elementState != expectedState) {
            throw new Exception(element + " Verification failed - Expected State:" + expectedState + " Actual State:"
                    + elementState);
        }
    }

    public static void verifyElementStateByXpath(WebDriver driver, String element, boolean expectedState) throws Exception {

        boolean elementState = driver.findElement(By.xpath(element)).isEnabled();
        if (elementState != expectedState) {
            throw new Exception(element + " Verification failed - Expected State:" + expectedState + " Actual State:"
                    + elementState);
        }
    }

    public static void enterText(WebDriver driver, String text, String textBox) throws Exception {
        WebElement webElement = findElement(driver, textBox);
        scrollToViewByElement(driver, webElement);
        enterTextInWebElement(driver, text, webElement);
    }

    public static void scrollToViewByElement(WebDriver driver, WebElement scrollElement) throws Exception {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }

    public static void enterTextInWebElement(WebDriver driver, String text, WebElement element) throws Exception {
        clickWebElement(driver, element);
        if (element.getAttribute("class").toLowerCase().contains("form")) {
            element.clear();
        }
        element.sendKeys(text);
    }
    public static void clickWebElement(WebDriver driver, WebElement element) throws Exception {
        waitForElementToBeClickable(driver, element, (int)Constants.UI_IMPLICIT_WAIT);
        element.click();
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement webElement, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void clickElement(WebDriver driver, String element) throws Exception {
        WebElement webElement = findElement(driver, element);
        clickWebElement(driver, webElement);
    }

    /**
     * Wait for timeout seconds for the element. Otherwise throw an Exception
     *
     * @param driver
     * @param element
     * @param numberElementsExpected
     * @param timeoutInSec
     *            in seconds
     * @throws Exception
     */
    public static void waitForElementsExist(WebDriver driver, String element, int numberElementsExpected, int timeoutInSec)
            throws Exception {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    int numberElementsFound = 0;
                    if (UIActions.findElementsNoExceptionIfNull(driver, element) != null) {
                        numberElementsFound = UIActions.findElementsNoExceptionIfNull(driver, element).size();
                        LOG.info("Number of elements found {}", numberElementsFound);
                    }
                    return numberElementsFound == numberElementsExpected;
                } catch (Exception ignored) {
                    LOG.info("Exception caught waiting for elements ..Ignored");
                }
                return false;
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
        wait.until(expectation);
    }

    public static void scrollAndClick(WebDriver driver, String element) throws Exception {
        scrollToView(driver, element);
        clickElement(driver, element);
    }

    public static void scrollToView(WebDriver driver, String element) throws Exception {
        WebElement scrollElement = findElement(driver, element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    }

}
