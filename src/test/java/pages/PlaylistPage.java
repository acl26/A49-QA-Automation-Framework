package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaylistPage extends BasePage{
    @FindBy (css = ".alertify-logs.top.right")
    WebElement notification;
    @FindBy (css = ".del.btn-delete-playlist")
    WebElement deletePlaylistBtn;
    @FindBy (css = ".fa.fa-plus-circle.create")
    WebElement plusBtn;
    @FindBy (css ="#playlists > nav > ul > li:nth-child(1)" )
    WebElement newPlaylist;
    @FindBy (css = "#playlists> ul> li:nth-child(4)")
    WebElement playlistRightClick;
    @FindBy (css = ".menu.playlist-item-menu ul > li:nth-child(1)")
    WebElement editBtn;
    @FindBy (css = "input[name='name']")
    WebElement newPlaylistName;
    @FindBy (css ="#playlists> ul> li:nth-child(4)")
    WebElement playlistClick;


    public PlaylistPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void rightCLickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistRightClick));
        actions.contextClick(playlistRightClick).perform();
    }
    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        editBtn.click();
    }

    public void enterNewName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistName));
        newPlaylistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.chord(Keys.ENTER));
    }

    public String getDeletePlaylistMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(notification));
        return notification.getText();
    }

    public String getRenameMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(notification));
        return notification.getText();
    }


    public void clickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistClick)).click();
    }

    public void clickRedBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtn));
        deletePlaylistBtn.click();
    }

//    public void clickOk() {
//        WebElement okay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ok")));
//        okay.click();
//    }

    public void clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusBtn));
        plusBtn.click();
    }
    public void clickNewPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist)).click();
    }
}
