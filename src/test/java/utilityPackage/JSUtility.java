package utilityPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtility
{
    JavascriptExecutor executor;

    public JSUtility(WebDriver driver)
    {
        executor = (JavascriptExecutor) driver;
    }

    public void clickOnElementUsingJS(WebElement element)
    {
        executor.executeScript("arguments[0].click()",element);
    }

    public void scrollFullPage()
    {
        executor.executeScript("window.scrollTo({top: document.body.scrollHeight/2, behavior: 'smooth'})");
    }
}
