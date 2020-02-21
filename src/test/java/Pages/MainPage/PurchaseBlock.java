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

    @FindBy(xpath = "//div[@class='content']//span[@class='quantity']")
    private WebElement amountOfPurchases;

    @FindBy(xpath = "//div[@class='content']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='tab-content']")
    private WebElement itemsContainer;

    public PurchaseBlock(WebDriver driver){
        super(driver);
    }

    public PurchasePage buyItem(String userChoice){
        Duck duck = new Duck();
        duck.getElementByName(itemsContainer,userChoice).click();
        return new PurchasePage(driver);
    }

    public ShoppingCartPage goToShoppingCart(){
        shoppingCart.click();
        return new ShoppingCartPage(driver);
    }
}
