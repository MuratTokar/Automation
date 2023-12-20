package day020_mrtt.testNg;

import org.openqa.selenium.By;

public enum Locators {
    Google_Accept_Cookie(By.id("L2AGLb")),
    Serach_Button(By.name("q"));
   private By locator;

    Locators(By locator) {
        this.locator=locator;
    }
    public By getLocator(){
        return locator;
    }
}
