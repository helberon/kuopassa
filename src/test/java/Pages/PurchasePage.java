package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/main/div[1]/div[1]/div[3]/div[6]/form/div/div/div[2]/button")
    private WebElement addToCartButton;


    public PurchasePage(WebDriver driver){
        super(driver);
    }

    public void addToShoppingCart(){
        addToCartButton.click();
    }
}
