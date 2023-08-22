import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        launchBrowser();
        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
        Thread.sleep(2000);
        playNextSong();
        Thread.sleep(2000);
        clickPlayButton();
        Thread.sleep(2000);
        WebElement soundBar = driver.findElement(By.cssSelector("[alt='Sound bars']"));
//        Assert.assertEquals(soundBar.isDisplayed());


    }

//    private boolean soundBarPlaying() {
//        WebElement soundBar = driver.findElement(By.cssSelector("[alt='Sound bars']"));
//        return  soundBar;
//    }


}

//        10. Click «Play next song» (media player controls), then the Play button to play a song.
//
//        11. Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.