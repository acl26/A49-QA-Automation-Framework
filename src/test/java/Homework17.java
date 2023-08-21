import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.Thread;


public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into \"AAA.\"";

        launchBrowser();
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
        Thread.sleep(2000);
        searchSong();
        viewAllSongs();
        clickFirstSong();
        addToPlaylist();
        choosePlaylist();
        Assert.assertEquals(getAddtoPlaylistSuccessMsg(), expectedSongAddedMessage);

    }




    public void searchSong() throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.clear();
        search.sendKeys("Episode 2");
        Thread.sleep(2000);
    }


    private void viewAllSongs() throws  InterruptedException{
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    private void clickFirstSong()throws  InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
        Thread.sleep(2000);
    }

    private void choosePlaylist() throws  InterruptedException {
        WebElement newPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'AAA')]"));
        newPlaylist.click();
        Thread.sleep(2000);
    }

    private void addToPlaylist() throws  InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public String getAddtoPlaylistSuccessMsg() throws InterruptedException {
        WebElement notification = driver.findElement(By.cssSelector(".alertify-logs.top.right]"));
        return notification.getText();
    }


}

//        6. Search for a song (choose any song of your choice).
//
//        7. Click View All to display the search results.
//
//        8. Click the first song in the search results.
//
//        9. Click ADD TO...
//
//        10. Choose the playlist to add it to, (we can create a new one with a unique name).
//
//        11. Verify that the notification message appears.
//
//        12. Verify that notification message has the text, "Added 1 song into {your playlist}".
