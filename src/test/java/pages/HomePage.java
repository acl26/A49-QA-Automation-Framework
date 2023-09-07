package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    @FindBy (css = ".view-profile .avatar")
   WebElement avatar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean avatarDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(avatar));
        return avatar.isEnabled();
    }
}
