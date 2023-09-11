package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {
   protected WebDriver driver;
    protected WebDriverWait wait;
   protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }



    public void navigateToPage(String url) { driver.get(url);}
    public WebElement findElement (WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void click (WebElement webElement) {
        findElement(webElement).click();
    }
    public void doubleClick (WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }
    public void contextClick (WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }
}
