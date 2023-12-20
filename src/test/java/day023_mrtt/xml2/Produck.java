package day023_mrtt.xml2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.WebElement;
@Getter
@Setter
@ToString
@AllArgsConstructor

public class Produck {
   private WebElement link;
   private String name;
   private int price;
   private String description;

   // bu degerleri atamam icin constructor acmam lazim
   // ama yukarida @AllArgsConstructor eklersem buna gerek kalmaz
   /* public Produck(WebElement name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }*/
}
