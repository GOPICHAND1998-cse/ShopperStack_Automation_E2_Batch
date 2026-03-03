package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePagePOM
{
    @FindBy(xpath = "//a/descendant::div[text()='My Profile']")
    private WebElement myProfileLink;

    @FindBy(xpath = "//a/descendant::div[text()='My Addresses']")
    private WebElement myAddressLink;

    @FindBy(xpath = "//a/descendant::div[text()='My Wallet']")
    private WebElement myWallet;

    @FindBy(xpath = "//a/descendant::div[text()='My Likes']")
    private WebElement myLinkesLink;

    public MyProfilePagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getMyProfileLink() {
        return myProfileLink;
    }

    public WebElement getMyAddressLink() {
        return myAddressLink;
    }

    public WebElement getMyWallet() {
        return myWallet;
    }

    public WebElement getMyLinkesLink() {
        return myLinkesLink;
    }
}
