package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserUtility
{
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                tlDriver.set(new ChromeDriver(options));
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./src/test/resources/BrowserDrivers/msedgedriver.exe");
                tlDriver.set(new EdgeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            default: throw new IllegalArgumentException("Wrong  Browser Name");
        }

        getDriver().manage().deleteAllCookies();
    }

    public void maximizeBrowser()
    {
        getDriver().manage().window().maximize();
    }

    public void openUrl(String url)
    {
        getDriver().get(url);
    }

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public void closeBrowser()
    {
        if (getDriver()!=null)
        {
           getDriver().quit();
        }
    }

    public void waitForPageToLoad(int num)
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num));
    }

    public void waitForElements(int num)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public void refreshBrowser()
        {
                getDriver().navigate().refresh();
        }
}
