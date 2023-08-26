import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    String notification = "Deleted playlist \"Test Pro.\"";
    @Test
    public void deletePlaylist() throws  InterruptedException {

        navigateToPage();
        provideEmail();
        providePassword();
        clickSubmit();
        clickPlaylist();
        clickRedBtn();
        clickOk();
        Assert.assertEquals(getDeletePlaylistMessage(), notification);

    }

}



//        1. Create a new branch named homework-20.
//
//2. Create a new file Homework20.java in IntelliJ IDEA.
//
//3. Refactor the previous test case deletePlaylist() - implement Explicit waits.
//
//4. Remove all implementations of Thread.sleep.
//Note: Includes all other Java classes (BaseTest, previous homeworks etc. if applicable)
//
//5. Make sure our codes run without errors.
//
//6. Commit your changes to the new branch homework-20.
