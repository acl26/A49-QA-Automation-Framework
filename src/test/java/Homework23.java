import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework23 extends BaseTest{
    HomePage homePage;
    PlaylistPage playlistPage;
    LoginPage loginPage;
    String newName = "Updated playlist \"Rename.\"";
    String namedPlaylist = "Created playlist \"Test Pro.\"";
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
       public void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.loginCorrectMethod();
        Assert.assertTrue(homePage.avatarDisplayed());
    }

    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);

        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist()
            .rightCLickPlaylist()
            .clickEdit()
            .enterNewName("Rename1");
        Assert.assertEquals(playlistPage.getRenameMessage(), newName);

    }


    @Test
    public void createPlaylist() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);

        loginPage.loginCorrectMethod();
        playlistPage.clickPlusButton()
                    .clickNewPlaylist()
                    .enterNewName("Test Pro");
        Assert.assertEquals(playlistPage.getRenameMessage(), namedPlaylist);

    }

    @Test
    public void deletePlaylist() {
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);

        loginPage.loginCorrectMethod();
        playlistPage.clickPlaylist()
                    .clickRedBtn();
//        playlistPage.clickOk();
        Assert.assertEquals(playlistPage.getDeletePlaylistMessage(), notification);

    }

}


//1. Create a new branch named homework-23.
//
//        2. Refactor your code, implement Page Factory by using the initElements() method of Page Factory class.
//
//        3. Use @FindBy annotation for declaring Web Elements.
//
//        4. Implement Fluent Interfaces (optional).
//
//        5. Commit your changes to the new branch homework-23.
//
//        6. Push your code to the remote repository.
//
//        7. Create a pull request.



