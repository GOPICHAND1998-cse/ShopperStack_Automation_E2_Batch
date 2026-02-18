package testngPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pomPackage.CartPagePOM;
import pomPackage.HomePagePOM;
import pomPackage.LogInPagePOM;
import pomPackage.ProductPagePOM;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileutility;

public class AddItemToCartUsingPriority
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

//    @Test(priority = 1)
    @Test
    public void loadData()
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
            browserUtil.waitForElements(20);

            driver = browserUtil.getDriver();


            home = new HomePagePOM(driver);
            login = new LogInPagePOM(driver);
            product = new ProductPagePOM(driver);
            cart = new CartPagePOM(driver);

            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//    @Test(priority = 2)
    @Test(dependsOnMethods ="loadData")
    public void doLogIn()
    {
        jsUtil.clickOnElementUsingJS(home.getLogInButton());

        actionUtil.writeInsideElement(login.getEmailField(), email);
        actionUtil.writeInsideElement(login.getPasswordField(),password );
        actionUtil.clickOnElement(login.getLogInButton());

    }

//    @Test(priority = 3)
    @Test(dependsOnMethods = "doLogIn")
    public void addItemToCart()
    {
        try
        {
            actionUtil.scrollTillElement(home.getDesiredProd());

            home.selectDesiredProduct("FIREBOLT");

//        actionUtil.clickOnElement(product.getaddToCartBtn());

            Thread.sleep(2000);

            jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());

            jsUtil.clickOnElementUsingJS(product.getCartIcon());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
