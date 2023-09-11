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
    @FindBy (xpath ="//*[text()='New Playlist']" )
    WebElement newPlaylist;
    @FindBy (css = "#playlists> ul> li:nth-child(4)")
    WebElement playlistRightClick;
    @FindBy (css = ".menu.playlist-item-menu ul > li:nth-child(1)")
    WebElement editBtn;
    @FindBy (css = "input[name='name']")
    WebElement newPlaylistName;
    @FindBy (css ="#playlists> ul> li:nth-child(4)")
    WebElement playlistClick;

    public PlaylistPage(WebDriver driver) {

        super(driver);
    }


    public PlaylistPage rightCLickPlaylist() {
        contextClick(playlistRightClick);
        return this;
    }
    public PlaylistPage clickEdit() {
        click(editBtn);
        return this;
    }

    public PlaylistPage enterNewName(String name) {
        findElement(newPlaylistName).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        newPlaylistName.sendKeys(name);
        newPlaylistName.sendKeys(Keys.chord(Keys.ENTER));
        return this;
    }

    public String getDeletePlaylistMessage() {
        findElement(notification);
        return notification.getText();
    }

    public String getRenameMessage() {
        findElement(notification);
        return notification.getText();
    }

    public PlaylistPage clickPlaylist() {
        click(playlistClick);
        return this;
    }

    public PlaylistPage clickRedBtn() {
        click(deletePlaylistBtn);
        return this;
    }

//    public void clickOk() {
//        WebElement okay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ok")));
//        okay.click();
//    }

    public PlaylistPage clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusBtn));
        plusBtn.click();
        return this;
    }
    public PlaylistPage clickNewPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist)).click();
        return this;
    }
}
