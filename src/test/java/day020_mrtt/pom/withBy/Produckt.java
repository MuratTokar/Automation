package day020_mrtt.pom.withBy;

import lombok.*;
import org.openqa.selenium.WebElement;
@Getter // bunlar hepsi lombok sayesinde
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Produckt {
   private WebElement name;
    private String text;
    private double price;
    private WebElement addToCart;
    //burda getter ve setter metodlarini sildik cunku pom a
    // yukledigimiz lombok sayesinde

}

