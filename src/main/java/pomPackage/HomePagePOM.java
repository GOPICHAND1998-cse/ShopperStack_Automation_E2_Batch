package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePagePOM
{
    WebDriver driver;

    WebDriverWait wait;

    private By logInButton = By.xpath("//button[@id='loginBtn']");
    private By menLink = By.xpath("//a[text()='Men']");
    private By womenLink = By.xpath("//a[text()='Women']");
    private By kidsLink = By.xpath("//a[text()='Kids']");
    private By electronicLink = By.xpath("//a[text()='Electronic']");
    private By beautyLink = By.xpath("//a[text()='Beauty']");

    private By allProducts = By.xpath("//div[contains(@class,'MuiPaper-root MuiCard-root featuredProducts_productCard__xe40f MuiPaper-elevation1 MuiPaper-rounded aos-init aos-animate')]");

    public HomePagePOM(WebDriver driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getMenLink()
    {
        return driver.findElement(menLink);
    }

    public WebElement getWomenLink()
    {
        return driver.findElement(womenLink);
    }

    public WebElement getLogInButton()
    {
        return driver.findElement(logInButton);
    }

    public WebElement getKidsLink()
    {
        return driver.findElement(kidsLink);
    }

    public WebElement getElectronicsLink()
    {
        return driver.findElement(electronicLink);
    }

    public WebElement getBeautyLink()
    {
        return driver.findElement(beautyLink);
    }

    public List<WebElement> getAllProducts()
    {
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(allProducts)));
    }

    public void selectDesiredProduct(String prodName) throws Exception
    {
        for(WebElement element: getAllProducts())
        {
            Thread.sleep(1000);

           String itemName=  element.findElement(By.xpath("descendant::div[@class='featuredProducts_footerLeft__PmkNa']/span[1]")).getText();

            if (itemName.equals(prodName))
            {
                element.click();
                break;
            }

        }

    }



}
