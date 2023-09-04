package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void rightCLickPlaylist() {
        WebElement rightClick = driver.findElement(By.cssSelector("#playlists> ul> li:nth-child(4)"));
        actions.contextClick(rightClick).perform();
    }
    public void clickEdit() {
        WebElement editBtn = driver.findElement(By.cssSelector(".menu.playlist-item-menu ul > li:nth-child(1)"));
        editBtn.click();
    }

    public void enterNewName() {

        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        newPlaylistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        newPlaylistName.sendKeys("Rename Playlist");
        newPlaylistName.click();
    }
    public String getDeletePlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs.top.right")));
//                driver.findElement(By.cssSelector(".alertify-logs.top.right"));
        return notification.getText();
    }
    public void clickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists> ul> li:nth-child(4)"))).click();
    }

    public void clickRedBtn() {
        WebElement redBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
//        WebElement redBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        redBtn.click();
    }

    public void clickOk() {
        WebElement okay = driver.findElement(By.cssSelector(".ok"));
        okay.click();
    }
}
