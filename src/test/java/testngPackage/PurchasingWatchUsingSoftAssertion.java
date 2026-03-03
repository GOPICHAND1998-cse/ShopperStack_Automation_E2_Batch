package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchasingWatchUsingSoftAssertion extends PurchasingWatchBaseClass
{
    @Test
    public void openHomepage()
    {
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/user-signin","The LogIn Unsuccessful");
        Reporter.log("The LogIn is Successful",true);

//        browserUtil.refreshBrowser();
        actionUtil.scrollTillElement(home.getDesiredProd());
        sAssert.assertTrue(home.getDesiredProd().isDisplayed(),"The DesiredProduct is not displayed");
        Reporter.log("The desired Product is displayed",true);
        actionUtil.clickOnElement(home.getDesiredProd());

        try{Thread.sleep(2000);} catch (Exception e) {
            e.printStackTrace();
        }

//        browserUtil.refreshBrowser();

       jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
        sAssert.assertEquals(product.getaddToCartBtn().getText().toLowerCase(),"added","The Product is not added to Cart");
        Reporter.log("The product is added to Cart",true);


        sAssert.assertAll();
    }



}
