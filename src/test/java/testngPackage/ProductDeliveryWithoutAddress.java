package testngPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pomPackage.*;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileutility;

public class ProductDeliveryWithoutAddress
{
    static WebDriver driver;

    public static String browser;
    public static String email;
    public static String password;
    public static String url;

    static PropertyFileutility property;
    static BrowserUtility browserUtil;
    static ActionsUtility actionUtil;
    static JSUtility jsUtil;

    static HomePagePOM home;
    static LogInPagePOM login;
    static CartPagePOM cart;
    static ProductPagePOM product;
    static AddressPagePOM address;
    static NavBarPOM nav;


    @Test
    public void doSetUp()
    {
        try
        {
            property = new PropertyFileutility();
            browser = property.getData("browser");
            url = property.getData("url");
            email = property.getData("email");
            password = property.getData("password");

            browserUtil = new BrowserUtility();
            browserUtil.openBrowser(browser);
            browserUtil.maximizeBrowser();
            browserUtil.openUrl(url);
            browserUtil.waitForElements(10);

            driver = browserUtil.getDriver();

            nav = new NavBarPOM(driver);
            home = new HomePagePOM(driver);
            login = new LogInPagePOM(driver);
            cart = new CartPagePOM(driver);
            product = new ProductPagePOM(driver);
            address = new AddressPagePOM(driver);
            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "doSetUp" ,enabled = false)
    public void preConditions()
    {
        jsUtil.clickOnElementUsingJS(nav.getLogInButton());

        actionUtil.writeInsideElement(login.getEmailField(),email);
        actionUtil.writeInsideElement(login.getPasswordField(),password);
        actionUtil.clickOnElement(login.getLogInButton());
    }

    @Test()
    public void selectYourProduct() throws Exception
    {
        actionUtil.clickOnElement(nav.getElectronicsLink());
        actionUtil.moveMouseToElement(nav.getShopperStackIcon());
        try{Thread.sleep(2000);}
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        browserUtil.refreshBrowser();

        Thread.sleep(2000);

        actionUtil.scrollTillElement(home.getDesiredProd());

        actionUtil.clickOnElement(home.getDesiredProd());

        browserUtil.refreshBrowser();

        try{Thread.sleep(2000);}
        catch (InterruptedException e) {e.printStackTrace();}

        actionUtil.clickOnElement(product.getbuyNowBtn());
    }
}
