package utilityPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSUtility
{
    JavascriptExecutor executor;
    WebDriverWait wait;

    public JSUtility(WebDriver driver)
    {
        executor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnElementUsingJS(WebElement element)
    {
        executor.executeScript("arguments[0].click()",wait.until(ExpectedConditions.elementToBeClickable(element)));
    }

    public void scrollFullPage()
    {
        executor.executeScript("window.scrollTo({top: document.body.scrollHeight/2, behavior: 'smooth'})");
    }
}
