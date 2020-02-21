package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement addToCartButton;


    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void addToShoppingCart() {
        addToCartButton.click();
    }
}
