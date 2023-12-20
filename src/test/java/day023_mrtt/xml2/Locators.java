package day023_mrtt.xml2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Locators {
    WebDriver driver;
    WebDriverWait wait;
    String url="https://demoblaze.com";

    @FindBy(xpath = "//a[text()='Phones']")
    WebElement ePhonelink;

    @FindBy(xpath = "//h4[@class='card-title']")
    List<WebElement>  urunlist; // bu sekil findElements gorevi görür

    public Locators(WebDriver driver){
        this.driver=driver;
       // wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
         // bu css veya xpath ile elemntleri  alir.
        // Icindeki @FindBy lar ile belirtilen tum elemntleri ayri ayri bilur
     /*   @FindAll({
                @FindBy(css = "hggh"),
                @FindBy(xpath = "fhgs")
        } )
                List<WebElement> elements;
        // ilk elemnt altinda digerini arar
        @FindBys({
                @FindBy(css = ""),
                @FindBy(css = "")}
        )
                WebElement element;*/



    }
// eger tüm producks lari bie class aatarsak
    @FindBy(css = "#tbodyid>div")
    List<WebElement> products;

}
