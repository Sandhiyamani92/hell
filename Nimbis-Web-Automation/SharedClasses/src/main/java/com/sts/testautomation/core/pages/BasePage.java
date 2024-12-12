package com.sts.testautomation.core.pages;

import com.aventstack.extentreports.Status;
import com.sts.testautomation.utilities.Excel.ExcelHandler;
import com.sts.testautomation.utilities.FailureUtil;
import com.sts.testautomation.utilities.Util;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static com.sts.testautomation.core.reporting.ExtentTestManager.getTest;

public class BasePage {

    private static final int TIMEOUT = 10;
    private static final int POLLING = 5;

    protected WebDriver driver;
    private WebDriverWait wait;

    protected int rowIndex;
    private boolean isFailed;
    private String date;
    private String time;
    protected String description;
    private String error;
    private String message;

    public BasePage(WebDriver driver, int rowIndex) {
        this.driver = driver;
        this.rowIndex = rowIndex;
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    private void pass() {
        this.isFailed = false;
    }

    private void fail(String date, String time, String error, String message) {
        this.isFailed = true;
        this.date = date;
        this.time = time;
        this.error = error;
        this.message = message;
        getTest().log(Status.FAIL, this.message);
        getTest().addScreenCaptureFromBase64String(Util.base64Screenshot(driver), this.message);

        new ExcelHandler().logFailure(new FailureUtil(isFailed, rowIndex, date, time, description, error, message));
    }

    public BasePage navigate(String url) {
        try {
            driver.manage().window().maximize();
            driver.navigate().to(url);
            getTest().log(Status.PASS, "Successfully navigated to '"+url+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "Navigation",
                    "Failed to navigate to '"+url+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitForElementToAppear(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            getTest().log(Status.PASS, "Successfully found element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to find element located by '"+locator+"' after " + TIMEOUT + " seconds"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitForElementToAppear(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            getTest().log(Status.PASS, "Successfully found element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to find element located by '"+locator+"' after " + TIMEOUT + " seconds"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitForElementToBeClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            getTest().log(Status.PASS, "Successfully waited for element located by '"+locator+"' to be clickable" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to wait for element located by '"+locator+"' to be clickable within " + TIMEOUT + " seconds"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            getTest().log(Status.PASS, "Successfully waited for element located by '"+locator+"' to disappear" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to wait for element located by '"+locator+"' to disappear"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitForTextToDisappear(By locator, String text) {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
            getTest().log(Status.PASS, "Successfully waited for element with text '"+text+"' and located by '"+locator+"' to disappear" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to wait for element with text '"+text+"' and located by '"+locator+"' to disappear"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage enterText(By locator, String text) {
        try {
            waitForElementToAppear(locator);
            driver.findElement(locator).sendKeys(text);
            getTest().log(Status.PASS, "Successfully entered text '"+text+"' for element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to enter text '"+text+"' for element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage clickElement(By locator) {
        try {
            waitForElementToAppear(locator);
            driver.findElement(locator).click();
            getTest().log(Status.PASS, "Successfully clicked element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage clickElement(WebElement locator) {
        try {
            waitForElementToAppear(locator);
            locator.click();
            getTest().log(Status.PASS, "Successfully clicked element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage isElementSelected(By locator) {
        try {
            waitForElementToAppear(locator);
            if(driver.findElement(locator).isSelected()) {
                getTest().log(Status.PASS, "Successfully selected the element located by '"+locator+"'" );
                pass();
                return this;
            }
            throw new Exception();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to select the element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage isElementChecked(By locator) {
        try {
            String isChecked = driver.findElement(locator).getAttribute("checked");
            if(isChecked.equalsIgnoreCase("checked")) {
                getTest().log(Status.PASS, "Successfully checked the element located by '"+locator+"'" );
                pass();
                return this;
            }
            throw new Exception();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to check the element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage clickElementContainingText(By locator, String text) {
        try {
            waitForElementToAppear(locator);
            if (driver.findElement(locator).getText().toLowerCase().contains(text.toLowerCase())) {
                driver.findElement(locator).click();
                getTest().log(Status.PASS, "Successfully clicked element with text '"+text+"' and located by '"+locator+"'" );
                pass();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click element with text '"+text+"' and located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage selectFromDropdown(By locator, String text) {
        try {
            waitForElementToAppear(locator);
            Select dropdown = new Select(driver.findElement(locator));
            dropdown.selectByVisibleText(text);
            getTest().log(Status.PASS, "Successfully selected dropdown option with text '"+text+"' and located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to select dropdown option with text '"+text+"' and located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage selectFromDropdownByValue(By locator, String text) {
        try {
            waitForElementToAppear(locator);
            Select dropdown = new Select(driver.findElement(locator));
            dropdown.selectByValue(text);
            getTest().log(Status.PASS, "Successfully selected dropdown option with value '"+text+"' and located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to select dropdown option with value '"+text+"' and located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage hoverOverElement(By locator) {
        try {
            waitForElementToAppear(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(locator)).perform();
            getTest().log(Status.PASS, "Successfully hovered over element located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to hover over element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage clearTextField(By locator) {
        try {
            waitForElementToAppear(locator);
            driver.findElement(locator).clear();
            getTest().log(Status.PASS, "Successfully cleared text field located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to clear text field located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToIFrame(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
            getTest().log(Status.PASS, "Successfully switched to iframe with Id or Name '"+idOrName+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to switch to iframe with Id or Name '"+idOrName+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToIFrame(int index) {
        try {
            driver.switchTo().frame(index);
            getTest().log(Status.PASS, "Successfully switched to iframe with Index '"+index+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed switch to iframe with Index '"+index+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToIFrame(By locator) {
        try {
            driver.switchTo().frame((WebElement) driver.findElement(locator));
            getTest().log(Status.PASS, "Successfully switched to iframe located by '"+locator+"'" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to switch to iframe located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
            getTest().log(Status.PASS, "Successfully switched to Parent iframe" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to switch to Parent iframe"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToMainFrame() {
        try {
            driver.switchTo().defaultContent();
            getTest().log(Status.PASS, "Successfully switched to Main iframe" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to switch to Main iframe"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            getTest().log(Status.PASS, "Successfully clicked 'OK' on the alert dialog" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click 'OK' on the alert dialog"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            getTest().log(Status.PASS, "Successfully clicked 'CANCEL' on the alert dialog" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click 'CANCEL' on the alert dialog"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage enterTextOnAlert(String text) {
        try {
            driver.switchTo().alert().sendKeys(text);
            getTest().log(Status.PASS, "Successfully entered text '"+text+"' on the alert dialog" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to enter text '"+text+"' on the alert dialog"
            );
            e.printStackTrace();
        }
        return this;
    }

    public String getTextOnAlert() {
        try {
            pass();
            return driver.switchTo().alert().getText();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed get text for the alert dialog"
            );
            e.printStackTrace();
            return "";
        }
    }

    public BasePage clickElementUsingJS(By locator) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(locator));
            getTest().log(Status.PASS, "Successfully clicked element located by '"+locator+"' using JavaScript" );
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click element located by '"+locator+"' using JavaScript"
            );
            e.printStackTrace();
        }
        return this;
    }

    public String getElementText(By locator) {
        try {
            waitForElementToAppear(locator);
            pass();
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed get text for the element located by '"+locator+"'"
            );
            e.printStackTrace();
            return "";
        }
    }

    public BasePage dragAndDrop(By from, By to) {
        try {
            waitForElementToAppear(from);
            waitForElementToAppear(to);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(driver.findElement(from),driver.findElement(to)).build().perform();
            getTest().log(Status.PASS, "Successfully dragged '"+from+"' to '"+to+"'");
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to drag '"+from+"' to '"+to+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public boolean isElementDisplayed(By locator) {
        try {
            if(driver.findElements(locator).size() != 0){
                return driver.findElement(locator).isDisplayed();
            }
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to check if the element located by '"+locator+"' is displayed"
            );
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public BasePage checkForToastErrors(By errorOrWarning) {
        String errorOrWarningStr = "";
        try {
            List<WebElement> errorsOrWarnings = driver.findElements(errorOrWarning);
            if(errorsOrWarnings.size() == 0) {
                getTest().log(Status.PASS, "No '"+errorOrWarning+"' errors found");
                pass();
                return this;
            } else {
                for(WebElement error : errorsOrWarnings) {
                    List<WebElement> titleAndMessage = error.findElements(By.xpath(".//div"));
                    errorOrWarningStr = "\n" + titleAndMessage.get(0).getText() + " : " + titleAndMessage.get(1).getText() + "\n";
                }
                fail(
                        Util.getCurrentDate(),
                        Util.getCurrentTime(),
                        "HTML Element",
                        "Found the following errors for '"+errorOrWarning+"': " + errorOrWarningStr
                );
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage pause(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage enableElementUsingJS(By locator) {
        try {
            ((JavascriptExecutor) driver).executeAsyncScript(
                    "arguments[0].removeAttribute(\"disabled\")",
                    driver.findElement(locator)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage clickAutoSuggestionElement(By options, String text) {
        try {
            waitForElementToAppear(options);
            boolean isFound = false;
            List<WebElement> suggestions = driver.findElements(options);
            for(WebElement element : suggestions) {
                String option = element.getText();
                if(option.equals(text)) {
                    element.click();
                    isFound = true;
                    getTest().log(Status.PASS, "Successfully clicked element with text '"+text+"' and in the suggestions '"+options+"'" );
                    pass();
                    break;
                }
            }
            if(!isFound) throw new Exception();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to click element with text '"+text+"' and in the suggestions '"+options+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage takeScreenshot(String description) {
        getTest().addScreenCaptureFromBase64String(Util.base64Screenshot(driver), description);
        return this;
    }

    public BasePage waitForFullPageLoad() {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            wait.until(pageLoadCondition);
            getTest().log(Status.PASS, "Successfully waited for page to finish loading");
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to wait for page to finish loading"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage checkElementWidth(By locator) {
        try {
            waitForElementToAppear(locator);
            if(driver.findElement(locator).getSize().getWidth() > 0) {
                getTest().log(Status.PASS, "Successfully displayed element located by '"+locator+"'");
                pass();
                return this;
            }
            throw new Exception();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to display element located by '"+locator+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage switchToTab(int tabIndex) {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            getTest().log(Status.PASS, "Successfully switched to new tab at index : " + tabIndex);
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "Browser Tabs",
                    "Failed to switch to new tab at index : " + tabIndex
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage closeTab() {
        try {
            driver.close();
            getTest().log(Status.PASS, "Successfully closed the tab");
            pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "Browser Tabs",
                    "Failed to close the tab"
            );
            e.printStackTrace();
        }
        return this;
    }

    public String getInnerHtmlForElement(By locator) {
        try {
            String result = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", driver.findElement(locator));
            getTest().log(Status.PASS, "Successfully got the text '" + result + "' from inner HTML");
            pass();
            return result;
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "HTML Element",
                    "Failed to get text from inner HTML"
            );
            e.printStackTrace();
        }
        return "";
    }

    public BasePage validateEquals(String field1, String value1, String field2, String value2) {
        try {
            if (value1.equals(value2)) {
                getTest().log(Status.PASS, "Successfully validated that <b>"+field1+"</b> '"+value1+"' equals to <b>"+field2+"</b> '"+value2+"'");
                pass();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "Validation",
                    "Failed to validate that <b>"+field1+"</b> '"+value1+"' equals to <b>"+field2+"</b> '"+value2+"'"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage refreshPage() {
        try {
                driver.navigate().refresh();
                getTest().log(Status.PASS, "Successfully refreshed the page");
                pass();
        } catch (Exception e) {
            fail(
                    Util.getCurrentDate(),
                    Util.getCurrentTime(),
                    "Navigation",
                    "Failed to refresh the page"
            );
            e.printStackTrace();
        }
        return this;
    }

    public BasePage logFail(String error, String message) {
        fail(
                Util.getCurrentDate(),
                Util.getCurrentTime(),
                error,
                message
        );
        return this;
    }
}
