package Actions;
import Base.BaseClass;
import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class PreDefinedActions extends BaseClass {
    private static Logger log = Logger.getLogger(PreDefinedActions.class);

    public static void sendKeysMethod(WebElement element, String text) {
// here we have implement wrapper methods which increase reusability of code
        element.sendKeys(text);
    }

    public static void selectByVisibleText(WebElement selectElement, String visibleText) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(visibleText);
    }

    public static List<WebElement> getListOfWebElement(List<WebElement> elementList) {//used list for getting list of elements
        List<WebElement> webElementList = wait.until(visibilityOfAllElements(elementList));//wait method used
        return webElementList;
    }

    public static List<Double> getListOfWebElementInDouble(List<WebElement> elementList) {
        List<Double> elementListString = new ArrayList<>();
        for (WebElement element : elementList) {
            elementListString.add(Double.parseDouble(element.getText().replace("+","")
                    .replace(" ","")
                    .replace("USD","").replace(",","")));
        }
        return elementListString;
    }
    public static void scrollInToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void navigateBack()
    {
        driver.navigate().back();
    }

    public static void frameHandles(WebElement element, boolean isWaitRequired) {
        if (isWaitRequired == true) {
            wait.until(frameToBeAvailableAndSwitchToIt(element));
        } else {
            driver.switchTo().frame(element);
        }
    }

    public static String getText(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element)).getText();//it has wait so worked
    }

    public static void switchDefaultPage() {
        driver.switchTo().defaultContent();
    }

    public static void clearField(WebElement element, boolean isWaitRequired, String text) {
        element.clear();
        element.sendKeys(text);

    }

    public static void clickMethod(WebElement element, boolean isWaitRequired) {
        if (isWaitRequired == true) {
            wait.until(elementToBeClickable(element)).click();
        } else {
            element.click();
        }
    }
    public static void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
        File file = new File("src/test/java/ScreenShot" + fileName + ".png");
        try {
            Files.copy(screenshotFile, file); // copying file to a folder with File object
        } catch (IOException e) {
            log.error("User not able to copy Screenshot file");
            throw new RuntimeException();
        }
    }
    public static void clickWithJS(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }


    public static void windowHandles() {
        String parentWindow = driver.getWindowHandle();
        Set<String> stringSet = driver.getWindowHandles(); 
        Iterator<String> I1 = stringSet.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parentWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
            }

        }
    }
}



