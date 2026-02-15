package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOM
{
    WebDriver driver;

    @FindBy(xpath="//a[@id='cart']")
    private WebElement cartIcon;
    @FindBy(xpath="//h3[text()='noise']")
    private WebElement productNameInCart;
    @FindBy(xpath="(//span[text()='4753'])[1]")
    private WebElement productPriceInCart;
    @FindBy(xpath="//span[text()='buy now']")
    private WebElement buyNowBtnInCart;
    @FindBy(xpath="//span[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(xpath="//button[text()='Remove from cart']")
    private WebElement removeFromCartBtn;

    public CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getcartIcon() {
        return cartIcon;
    }
    public WebElement getproductNameInCart() {
        return productNameInCart;
    }
    public WebElement getproductPriceInCart() {
        return productPriceInCart;
    }

    public WebElement getbuyNowBtnInCart() {
        return buyNowBtnInCart;
    }
    public WebElement getcontinueShoppingBtn() {
        return continueShoppingBtn;
    }
    public WebElement getremoveFromCartBtn() {
        return removeFromCartBtn;
    }



}
