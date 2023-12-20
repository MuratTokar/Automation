package day020_mrtt.pom.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {
    private By producks = By.cssSelector(".inventory_item");// cercevesini aldik
    private By producksName = By.cssSelector(".inventory_item_name");
    private By producksPrice = By.cssSelector(".inventory_item_price");
    private By producksAddToCart = By.cssSelector(".inventory_item button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getlistOfProduksNames() {
        return driver.findElements(producksName).stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());


    }
}
