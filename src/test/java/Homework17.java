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
}


