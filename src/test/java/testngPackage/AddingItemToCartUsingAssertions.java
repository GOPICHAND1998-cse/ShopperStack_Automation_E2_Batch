package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddingItemToCartUsingAssertions extends PurchasingWatchBaseClass
{

    @Test
    public void goToELectronics()
    {
        Assert.assertTrue(nav.getProfileIcon().isDisplayed(),"The Profile Icon is not displayed");
        Reporter.log("The Profile Icon is diaplyed",true);

        actionUtil.moveMouseToElement(nav.getShopperStackIcon());

        actionUtil.scrollTillElement(home.getDesiredProd());

        Assert.assertTrue(home.getDesiredProd().isDisplayed(),"The desired Product is not displayed");
        Reporter.log("The desired product is displayed",true);

        actionUtil.clickOnElement(home.getDesiredProd());

        Assert.assertTrue(product.getaddToCartBtn().isDisplayed(),"The Add To cart Button is not displayed");
        Reporter.log("The Add To Cart Button is displayed",true);

        actionUtil.moveMouseToElement(product.getaddToCartBtn());

        actionUtil.clickOnElement(product.getaddToCartBtn());
    }

}
