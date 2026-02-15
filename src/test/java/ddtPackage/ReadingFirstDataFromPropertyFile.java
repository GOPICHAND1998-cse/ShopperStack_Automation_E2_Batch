package ddtPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

public class ReadingFirstDataFromPropertyFile
{
    static WebDriver driver;
    static String browser;
    static String url;
    static String email;
    static String password;


    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/ShopperStackProperty.properties");

            Properties property = new Properties();

            property.load(fis);

            browser = property.getProperty("browser");
            url = property.getProperty("url");
            email = property.getProperty("email");
            password = property.getProperty("password");


            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver","./src/test/resources/BrowserDrivers/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                case "brave":
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
                    driver = new ChromeDriver(options);
                default: throw new InvalidArgumentException("Invalid Browser");
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            driver.get(url);

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']")))
                    .click();

            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);

            driver.findElement(By.xpath("//button[@id='Login']")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Account settings']")))
                    .click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]/child::li[text()='My Profile']")))
                    .click();

            WebElement accountInfoBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='myprofileOutlet']/child::div[@class='r2']/child::table")));

            Thread.sleep(2000);

            String key = wait.until(ExpectedConditions.visibilityOf(accountInfoBox.findElement(By.xpath("./child::thead/child::tr/child::th[1]")))).getText();
            String value = wait.until(ExpectedConditions.visibilityOf(accountInfoBox.findElement(By.xpath("./child::tbody/child::tr/child::td[1]")))).getText();

            property.setProperty(key,value);

            FileOutputStream fos = new FileOutputStream("./src/test/resources/ShopperStackProperty.properties");

            property.store(fos,"Updated by ATE Pritam");

            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
