import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
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
        Assert.assertTrue(soundBar.isDisplayed());

    }


}



