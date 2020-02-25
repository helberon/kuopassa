import Pages.MainPage.FooterBlock;
import Pages.MainPage.LoginBlock;
import Pages.MainPage.PurchaseBlock;
import com.sun.org.glassfish.gmbal.Description;
import core.DriverProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {
    private WebDriver driver;

    @Before
    public void setupPage() {
        driver = DriverProvider.getDriver();
        driver.get("http://kuopassa.net/litecart/en/");
    }

    @Description("Verify correctness of text in About Us page")
    @Test
    public void aboutUsVerifyText() {
        FooterBlock instancePage = new FooterBlock(driver);
        String aboutUs = instancePage.goToAboutUsPage().getAboutUsText().getText();
        String aboutUsExpected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer fermentum quam eget molestie lacinia. Suspendisse consectetur velit vitae tellus commodo pharetra." +
                " Curabitur lobortis turpis tortor, id blandit metus pellentesque sit amet. Etiam cursus dolor purus, sit amet vestibulum ipsum aliquet nec. Nunc sed aliquet eros. Sed at vehicula urna." +
                " Aliquam euismod nisl a felis adipiscing tincidunt. Etiam vestibulum arcu sed massa ornare, vitae venenatis odio convallis.";
        Assert.assertEquals(aboutUsExpected, aboutUs);
    }

    @Description("Verify getting bad login alert after login with wrong credentials")
    @Test
    public void badLoginWithAppropriateEmailFormat() {
        LoginBlock instancePage = new LoginBlock(driver);
        Assert.assertTrue(instancePage.logInToSite("login@email.com", "password")
                .getBadLoginAlert().isDisplayed());
    }

    @Description("Verify duck was added to Shopping Cart after buying it")
    @Test
    public void checkPurchaseInShoppingCart() throws InterruptedException {
        PurchaseBlock instancePage = new PurchaseBlock(driver);
        instancePage.buyItem("Red Duck").addToShoppingCart();
        WebElement element = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src,'filled')]")));
        Assert.assertTrue(instancePage.goToShoppingCart().getShoppingCartTable().isDisplayed());
    }

    @After
    public void clearEnv() {
        DriverProvider.closeDriver();
    }
}
