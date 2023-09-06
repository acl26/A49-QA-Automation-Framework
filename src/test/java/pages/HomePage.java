package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage (WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    @FindBy (css = ".view-profile .avatar")
   WebElement avatar;
    public boolean avatarDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(avatar));
        return avatar.isEnabled();
    }
}
