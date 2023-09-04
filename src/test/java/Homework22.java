import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist();
        playlistPage.rightCLickPlaylist();
        playlistPage.clickEdit();
        playlistPage.enterNewName();

    }

    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
    public void deletePlaylist() throws  InterruptedException {

        basePage.navigateToPage(url);
        loginPage.provideEmail();
        loginPage.providePassword();
        loginPage.clickSubmit();
        playlistPage.clickPlaylist();
        playlistPage.clickRedBtn();
        playlistPage.clickOk();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(), notification);

    }



}



