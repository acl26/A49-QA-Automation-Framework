import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
 String notification = "Deleted playlist \"Test Pro.\"";
 @Test
 public void deletePlaylist() throws  InterruptedException {

        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
        Thread.sleep(2000);
        clickPlaylist();
        Thread.sleep(2000);
        clickRedBtn();
        clickOk();
        Thread.sleep(2000);
     WebElement getDeletePlaylistMessage = driver.findElement(By.cssSelector(".success.show"));
     Assert.assertEquals(getDeletePlaylistMessage, notification);

    }

}

//        1. Create a new branch named homework-19.
//
//        2. Create a new file Homework19.java in IntelliJ IDEA.
//
//        3. Create a test case, deletePlaylist() using @Test annotation.
//
//        4. Use the helper/reusable methods we created.
//
//        5. Use @Parameters for passing baseUrl from the TestNG config file to the tests.
//
//        6. Navigate to "https://qa.koel.app/".
//
//        7. Log in with your credentials.
//
//        8. Click the playlist you want to delete.
//
//        9. We should see the red button "x PLAYLIST" on the top right part of the page, and click on it.
//
//        Note: If the red button is not displayed, let's create a new playlist and click on it.
//
//        10. Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
