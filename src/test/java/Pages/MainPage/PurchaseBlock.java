package Pages.MainPage;

import Pages.BasePage;
import Pages.PurchasePage;
import Pages.ShoppingCartPage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PurchaseBlock extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='http://kuopassa.net/litecart/en/rubber-ducks-c-1/blue-duck-p-4']")
    private WebElement purchaseItem;
    @FindBy(xpath = "//div[@class='content']")
    private WebElement shoppingCart;

    public PurchaseBlock(WebDriver driver){
        super(driver);
    }

    public PurchasePage buyItem(){
        purchaseItem.click();
        return new PurchasePage(driver);
    }

    public ShoppingCartPage goToShoppingCart(){
        shoppingCart.click();
        return new ShoppingCartPage(driver);
    }
}
