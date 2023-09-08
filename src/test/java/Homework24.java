import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework24 extends BaseTest{
    HomePage homePage;
    PlaylistPage playlistPage;
    LoginPage loginPage;
    String newName = "Updated playlist \"Rename.\"";
    String namedPlaylist = "Created playlist \"Test Pro.\"";

    @Test
       public void login() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.loginCorrectMethod();
        Assert.assertTrue(homePage.avatarDisplayed());
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
        playlistPage.clickPlaylist();
        String playNameDeleted = driver.findElement(By.cssSelector("#playlists> ul> li:nth-child(4)")).findElement(By.xpath("a")).getText();
        String notification = "Deleted playlist \""+playNameDeleted+".\"";
        playlistPage.clickRedBtn();
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
