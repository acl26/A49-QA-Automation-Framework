import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
    @Test
            public void login() {
        loginPage.loginCorrectMethod();
        Assert.assertTrue(homePage.avatarDisplayed());
    }
    String newName = "Updated playlist \"Rename.\"";
    @Test
    public void renamePlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist();
        playlistPage.rightCLickPlaylist();
        playlistPage.clickEdit();
        playlistPage.enterNewName("Rename");
        Assert.assertEquals(playlistPage.getRenameMessage(), newName);

    }

    String namedPlaylist = "Created playlist \"Test Pro.\"";
    @Test
    public void createPlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlusButton();
        playlistPage.clickNewPlaylist();
        playlistPage.enterNewName("Test Pro");
        Assert.assertEquals(playlistPage.getRenameMessage(), namedPlaylist);

    }
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
    public void deletePlaylist() {
        basePage.navigateToPage(url);
        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist();
        playlistPage.clickRedBtn();
//        playlistPage.clickOk();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(), notification);

    }

}

//
//2.  Set up our Selenium Grid (Standalone option) locally. Chrome browser would be enough to get an idea.
//
//        3. Implement Browser Factory method like we did in the class, so you can run Chrome browser using your local Grid.




