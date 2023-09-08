package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import tests.BaseTest;

public class Homework25 extends BaseTest {
    HomePage homePage;
    PlaylistPage playlistPage;
    LoginPage loginPage;
    String newName = "Updated playlist \"Rename.\"";
    String namedPlaylist = "Created playlist \"Test Pro.\"";
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
       public void login() {
        loginPage = new LoginPage(getThreadDriver());
        homePage = new HomePage(getThreadDriver());

        loginPage.loginCorrectMethod();
        Assert.assertTrue(homePage.avatarDisplayed());
    }


    @Test
    public void createPlaylist() {
        loginPage = new LoginPage(getThreadDriver());
        playlistPage = new PlaylistPage(getThreadDriver());

        loginPage.loginCorrectMethod();
        playlistPage.clickPlusButton()
                    .clickNewPlaylist()
                    .enterNewName("Test Pro");
        Assert.assertEquals(playlistPage.getRenameMessage(), namedPlaylist);
    }

    @Test
    public void deletePlaylist() {
        loginPage = new LoginPage(getThreadDriver());
        playlistPage = new PlaylistPage(getThreadDriver());

        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist()
                    .clickRedBtn();
//        playlistPage.clickOk();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(), notification);

    }

    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);

        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist()
                .rightCLickPlaylist()
                .clickEdit()
                .enterNewName("Rename");
        Assert.assertEquals(playlistPage.getRenameMessage(), newName);
    }

}

//1. Create a new branch named homework-25.
//
//        2. Create your new Lambdatest account with a free trial here:
//        https://accounts.lambdatest.com/register.
//
//        2. Add the cloud execution capability to your framework.
//
//        3. Run your tests in the cloud and make sure they pass (check the videos).
//
//        4. Commit your changes to the new branch homework-25.
//
//        5. Push your code to the remote repository.
//
//        6. Create a pull request.