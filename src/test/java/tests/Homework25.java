package tests;

import org.openqa.selenium.By;
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


//    @Test
//       public void login() {
//        loginPage = new LoginPage(getThreadDriver());
//        homePage = new HomePage(getThreadDriver());
//
//        loginPage.loginCorrectMethod();
//        Assert.assertTrue(homePage.avatarDisplayed());
//    }

    @Test
    public void loginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("invalid@email.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Assert.assertEquals(getThreadDriver().getCurrentUrl(),url);
}
    @Test
    public void loginEmptyPassword() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("anna.gertzen@testpro.io");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertEquals(getThreadDriver().getCurrentUrl(), url);
    }

    @Test
    public void loginEmptyEmail() {
        LoginPage loginPage = new LoginPage(getThreadDriver());

        loginPage.provideEmail("");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Assert.assertEquals(getThreadDriver().getCurrentUrl(), url);
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