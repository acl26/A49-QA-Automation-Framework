import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework22 extends BaseTest{

    String newName = "Updated playlist \"Rename.\"";
    @Test
    public void renamePlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist();
        playlistPage.rightCLickPlaylist();
        playlistPage.clickEdit();
        playlistPage.enterNewName();
        Assert.assertEquals(playlistPage.getRenameMessage(), newName);

    }

    String namedPlaylist = "Created playlist \"Test Pro.\"";
    @Test
    public void createPlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlusButton();
        playlistPage.clickNewPlaylist();
        playlistPage.enterNewPlaylist();
        Assert.assertEquals(playlistPage.getRenameMessage(), namedPlaylist);

    }
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
    public void deletePlaylist() {

        basePage.navigateToPage(url);
        loginPage.provideEmail();
        loginPage.providePassword();
        loginPage.clickSubmit();
        playlistPage.clickPlaylist();
        playlistPage.clickRedBtn();
//        playlistPage.clickOk();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(), notification);

    }



}



