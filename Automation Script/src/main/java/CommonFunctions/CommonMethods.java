package CommonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods
{
    WebDriver driver;
    public CommonMethods(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean clickElement(WebElement element, int timeOutInSecond, String elementName) {
        boolean isClickElement = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            isClickElement = true;
            System.out.println("Clicked on " + elementName + " successfully");
        } catch (Exception e) {
            isClickElement=false;
            e.printStackTrace();
            System.out.println(elementName+"Element did not clicked.");
        }
        return isClickElement;
    }


    public boolean sendKeyBoolean(WebElement element, String key) {
        boolean isSendKeyBoolean;
        try {
            element.clear();
            element.sendKeys(key);
            element.sendKeys(Keys.TAB);
            isSendKeyBoolean = true;
            System.out.println(key + " successfully passed into text area.");
        } catch (Exception e) {
            isSendKeyBoolean = false;
            System.out.println(key + " did not pass into text area.");
            e.printStackTrace();
        }
        return isSendKeyBoolean;
    }
    public boolean clickElementIfDisplayed(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed()) {
                element.click();
                isElementClicked = true;
                System.out.println("Clicked on " + elementName + " successfully");
            }
        } catch (Exception e) {
            isElementClicked = false;
            System.out.println("****** Unable to find " + elementName + " within " + timeOutInSecond + " seconds *****");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public String getElementText(WebElement element, String expectedText, int timeOutInSecond) {
        String text = "";
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText().trim();
            System.out.println("Get text from element successfully");
            System.out.println("Text found: " + text);
        } catch (Exception e) {
            System.out.println("Get text from element is not successful");
            e.printStackTrace();
        }
        return text;
    }

    public boolean checkElementText(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            if (isElementWithTextExist) {
                System.out.println(elementName + " verified successfully");
            } else {
                System.out.println(elementName + " verification failed");
            }
            System.out.println(elementName + " found: " + element.getText().trim());
        } catch (Exception e) {
            isElementWithTextExist = false;
            System.out.println(elementName + " text is not captured.");
            e.printStackTrace();
        }
        return isElementWithTextExist;
    }
    public boolean sendKeyBoolean(WebElement element, String key, int timeOutInSecond, String elementName) {
        boolean isSendKeyBoolean;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);

        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
            isSendKeyBoolean = true;
            System.out.println("SendKeys '" + key + "' to " + elementName + " successfully");
        } catch (Exception e) {
            isSendKeyBoolean = false;
            System.out.println(key + " did not pass into text area.");
            e.printStackTrace();
        }
        return isSendKeyBoolean;
    }

    public String getElementText(WebElement element, int timeOutInSecond) {
        String text = "";
        WebDriverWait wait;

        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            //wait.until(ExpectedConditions.textToBePresentInElement(element, "Hello, Tester11"));

            text = element.getText().trim();
            System.out.println("Get text from element successfully");
            System.out.println("Text found: " + text);
        } catch (Exception e) {
            System.out.println("Get text from element is not successful");
            e.printStackTrace();
        }
        return text;
    }
    public boolean compareTexts(String firstText, String secondText) {
        boolean isCompareTexts = false;
        try {
            if (firstText.equalsIgnoreCase(secondText)) {
                isCompareTexts = true;
                System.out.println(firstText + " and " + secondText + " both are matching.");
            }
        } catch (Exception e) {
            isCompareTexts = false;
            System.out.println("Strings are not matching.");
            e.printStackTrace();
        }
        return isCompareTexts;
    }
}
