package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagePOM
{
    WebDriver driver;

    @FindBy(xpath="//select[@id='category']")
    private WebElement allSelectDropDown;
    @FindBy(xpath="//input[@id='search']")
    private WebElement searchInput;
    @FindBy(xpath="//a[text()='Electronic']")
    private WebElement electronicLink;
    @FindBy(xpath="//h2[text()='noise']")
    private WebElement productName;
    @FindBy(xpath="//span[text()='4753']")
    private WebElement productPrice;
    @FindBy(xpath="//span[text()='buy now']")
    private WebElement buyNowBtn;
    @FindBy(xpath="//button[@id='Add To Cart']")
    private WebElement addToCartBtn;
    @FindBy(xpath="//input[@id='Check Delivery']")
    private WebElement quickDelTextField;
    @FindBy(xpath="//button[@id='Check']")
    private WebElement checkButton;
    @FindBy(xpath="//small[@id='locationPopupBlock']")
    private WebElement findMyPincodeRBtn;
    @FindBy(xpath = "//a[@id='cart']")
    private WebElement cartIcon;

    public ProductPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getallSelectDropDown()
    {

        return allSelectDropDown;

    }
    public WebElement getsearchInput()
    {
        return searchInput;

    }


    public WebElement getelectronicLink()
    {
        return electronicLink;

    }

    public WebElement getproductName() {
        return productName;
    }

    public WebElement getproductPrice() {
        return productPrice;
    }

    public WebElement getbuyNowBtn() {
        return buyNowBtn;
    }

    public WebElement getaddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getCartIcon()
    {
        return cartIcon;
    }

    public WebElement getquickDelTextField() {
        return quickDelTextField;
    }

    public WebElement getcheckButton() {
        return checkButton;
    }

    public WebElement getfindMyPincodeRBtn()
    {
        return findMyPincodeRBtn;
    }




}
