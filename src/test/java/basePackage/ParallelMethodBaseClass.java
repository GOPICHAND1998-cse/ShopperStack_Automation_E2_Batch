package basePackage;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pomPackage.*;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileutility;

public class ParallelMethodBaseClass
{
    public WebDriver driver;
    public String browser;
    public String email;
    public String password;
    public String url;
    public PropertyFileutility property;
    public BrowserUtility browserUtil;
    public ActionsUtility actionUtil;
    public JSUtility jsUtil;
    public LogInPagePOM login;
    public NavBarPOM navBar;
    public HomePagePOM home;
    public CartPagePOM cart;
    public ProductPagePOM product;


    @BeforeMethod
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

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @BeforeMethod(dependsOnMethods = "loadData")
    public void performSetUp()
    {
        browserUtil.openBrowser(browser);
//        browserUtil.maximizeBrowser();
        browserUtil.waitForElements(30);
        browserUtil.openUrl(url);

        driver = browserUtil.getDriver();

        login = new LogInPagePOM(driver);
        navBar = new NavBarPOM(driver);
        home = new HomePagePOM(driver);
        cart = new CartPagePOM(driver);
        product = new ProductPagePOM(driver);



        actionUtil = new ActionsUtility(driver);
        jsUtil = new JSUtility(driver);

//        jsUtil.clickOnElementUsingJS(navBar.getLogInButton());

        actionUtil.clickOnElement(navBar.getLogInButton());

        login.performLogIn(email,password);
    }
}
