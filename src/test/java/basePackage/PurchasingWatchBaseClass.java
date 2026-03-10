package basePackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pomPackage.*;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileutility;

public class PurchasingWatchBaseClass
{

    public WebDriver driver;

    public  String browser;
    public  String email;
    public  String password;
    public  String url;

    public PropertyFileutility property;
    public BrowserUtility browserUtil;
    public ActionsUtility actionUtil;
    public JSUtility jsUtil;

    public HomePagePOM home;
    public LogInPagePOM login;
    public CartPagePOM cart;
    public ProductPagePOM product;
    public AddressPagePOM address;
    public NavBarPOM nav;


    @BeforeClass
    public void loadData()
    {
        try
        {
            property = new PropertyFileutility();
            browserUtil = new BrowserUtility();

            browser = property.getData("browser");
            url = property.getData("url");
            email = property.getData("email");
            password = property.getData("password");

            browserUtil.openBrowser(browser);
            browserUtil.openUrl(url);
            browserUtil.maximizeBrowser();
            browserUtil.waitForPageToLoad(20);
            browserUtil.waitForElements(25);
            driver = browserUtil.getDriver();

            Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/","The Expected URL is not opened");
            Reporter.log("The Expected URL is opened",true);

//            Assert.fail("Intentionally Failed");



            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeClass(dependsOnMethods = "loadData")
    public void loadPage()
    {
        try
        {
            home = new HomePagePOM(driver);
            login = new LogInPagePOM(driver);
            nav = new NavBarPOM(driver);
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

    @BeforeClass(dependsOnMethods = "loadPage")
    public void doLogIn()
    {
        SoftAssert sAssert = new SoftAssert();

        browserUtil.refreshBrowser();

        jsUtil.clickOnElementUsingJS(nav.getLogInButton());

        sAssert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/user-signin","The LogIn Page is not opened");
        Reporter.log("The LogIn Page is opened",true);

        login.performLogIn(email,password);

        sAssert.assertAll();
    }

    @AfterClass(enabled = false)
    public void doLogOut()
    {
        actionUtil.clickOnElement(nav.getProfileIcon());
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        actionUtil.clickOnElement(nav.getLogoutLink());

        browserUtil.closeBrowser();
    }


}
