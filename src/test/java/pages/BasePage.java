package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BasePage {
   protected WebDriver driver;
    protected WebDriverWait wait;
   protected Actions actions;

    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions){
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
    public void navigateToPage(String url) { driver.get(url);}


    public void quitBrowser() {
        driver.quit();
    }

}
