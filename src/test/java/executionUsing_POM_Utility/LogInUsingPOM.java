package executionUsing_POM_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pomPackage.HomePagePOM;
import pomPackage.LogInPagePOM;

import java.time.Duration;

public class LogInUsingPOM
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            driver.get("https://www.shoppersstack.com/");

            HomePagePOM home = new HomePagePOM(driver);

            home.getLogInButton().click();

            LogInPagePOM login = new LogInPagePOM(driver);

            login.getEmailField().sendKeys("mydummy@gmail.com");

            login.getPasswordField().sendKeys("Password@12345");

            login.getLogInButton().click();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
