package basePackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

    @BeforeSuite
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
            browserUtil.waitForElements(15);

            driver = browserUtil.getDriver();

            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeTest
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

    @BeforeClass
    public void doLogIn()
    {
        jsUtil.clickOnElementUsingJS(nav.getLogInButton());

        login.performLogIn(email,password);
    }

    @AfterClass
    public void doLogOut()
    {
        actionUtil.clickOnElement(nav.getProfileIcon());
        actionUtil.clickOnElement(nav.getLogoutLink());
    }
}
