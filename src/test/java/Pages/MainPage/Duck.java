package Pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Duck {

    private String duckList = "//div[@id='box-popular-products']//a";
    private String duckInfo = ".//div[@class='info']/div";
    private String price = ".//span";

    private WebElement ownElement;
    private String duckName;
    private String duckManufacturer;
    private String duckPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return duckName.equals(duck.duckName) &&
                duckManufacturer.equals(duck.duckManufacturer) &&
                duckPrice.equals(duck.duckPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duckName, duckManufacturer, duckPrice);
    }

    @Override
    public String toString() {
        return "Pages.MainPage.Duck{" +
                "duckName='" + duckName + '\'' +
                ", duckManufacturer='" + duckManufacturer + '\'' +
                ", duckPrice='" + duckPrice + '\'' +
                '}';
    }

    public Duck() {
    }

    public Duck(String duckName, String duckManufacturer, String duckPrice) {
        this.duckName = duckName;
        this.duckManufacturer = duckManufacturer;
        this.duckPrice = duckPrice;
    }

    public Duck(WebElement elementFacade) {
        this.ownElement = elementFacade;
        this.duckName = elementFacade.findElements(By.xpath(duckInfo)).get(0).getText();
        this.duckManufacturer = elementFacade.findElements(By.xpath(duckInfo)).get(1).getText();
        this.duckPrice = elementFacade.findElements(By.xpath(duckInfo)).get(2).findElement(By.xpath(price)).getText();
    }

    public List<Duck> getAllProducts(WebElement webElementFacade) {
        List<Duck> allElemList = new ArrayList<>();
        List<WebElement> duckListGeneral = webElementFacade.findElements(By.xpath(duckList));
        for (WebElement elem : duckListGeneral) {
            allElemList.add(new Duck(elem));
        }
        return allElemList;
    }

    public WebElement getElementByName(WebElement container, String customDuckName) {
        List<WebElement> duckListGeneral = container.findElements(By.xpath(duckList));
        WebElement searchResult = null;
        for (WebElement elem : duckListGeneral) {
            Duck instance = new Duck(elem);
            if (instance.duckName.equals(customDuckName)) {
                searchResult = elem;
            }
        }
        return searchResult;
    }
}