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
        playlistPage.clickPlaylist()
            .rightCLickPlaylist()
            .clickEdit()
            .enterNewName("Rename");
        Assert.assertEquals(playlistPage.getRenameMessage(), newName);

    }

    String namedPlaylist = "Created playlist \"Test Pro.\"";
    @Test
    public void createPlaylist() {
        loginPage.loginCorrectMethod();
        playlistPage.clickPlusButton()
                    .clickNewPlaylist()
                    .enterNewName("Test Pro");
        Assert.assertEquals(playlistPage.getRenameMessage(), namedPlaylist);

    }
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
    public void deletePlaylist() {
        basePage.navigateToPage(url);
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



