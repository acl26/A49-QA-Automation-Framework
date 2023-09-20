package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy (css ="[type='email']")
    WebElement emailField;
    @FindBy (css ="[type='password']")
    WebElement passwordField;
    @FindBy (css = "[type='submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void loginCorrectMethod(){
//        navigateToPage(driver.getCurrentUrl());
        provideEmail("anna.gertzen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    public void provideEmail(String email) {
        findElement(emailField).clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        click(submitBtn);
    }
}

