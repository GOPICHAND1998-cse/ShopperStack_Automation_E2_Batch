package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserUtility
{
    private WebDriver driver;

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./src/test/resources/BrowserDrivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default: throw new IllegalArgumentException("Wrong  Browser Name");
        }

        driver.manage().deleteAllCookies();
    }

    public void maximizeBrowser()
    {
        driver.manage().window().maximize();
    }

    public void openUrl(String url)
    {
        driver.get(url);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void closeBrowser()
    {
        if (driver!=null)
        {
           driver.quit();
        }
    }

    public void waitForElements(int num)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
}
