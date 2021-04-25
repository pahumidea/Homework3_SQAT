package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        //i tuka zapazi kako ti e by css selector tolku top e i posle idi na testovi 3 tesotvi se sega kje ti dadam primer da me sfatish
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"app_logo\"]"))).isDisplayed();
    }
}