package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework26 extends BaseTest {
    HomePage homePage;
    PlaylistPage playlistPage;
    LoginPage loginPage;
    String newName = "Updated playlist \"Rename.\"";


    @Test
       public void login() {
        loginPage = new LoginPage(getThreadDriver());
        homePage = new HomePage(getThreadDriver());

        loginPage.loginCorrectMethod();
        Assert.assertTrue(homePage.avatarDisplayed());
    }

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
//#
//        #  1. Create a new branch named homework-27.
//        #
//        #  2. Install Cucumber for TestNG as shown during our class.
//        #
//        #  3. Configure it for at least one test case (login should be enough).
//        #
//        #  4. Run the test, and it should pass.
//        #
//        #  5. Commit your changes to the new branch homework-27.
//        #
//        #  6. Push your code to the remote repository.
//        #
//        #  7. Create a pull request.
