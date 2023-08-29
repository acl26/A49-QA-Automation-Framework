import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

    public WebDriver driver = null;
   public String url;
   public static Actions actions = null;
   WebDriverWait wait;


    @BeforeSuite
    static void setupClass() { WebDriverManager.chromedriver().setup(); }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        url=baseURL;
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);

    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail() {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("anna.gertzen@testpro.io");
    }

    public void providePassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
    }

    public void clickSubmit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
}

    protected void clickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists> ul> li:nth-child(4)"))).click();
    }

    protected void clickRedBtn() {
     WebElement redBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
     redBtn.click();
    }

    protected void clickOk() {
     WebElement okay = driver.findElement(By.cssSelector(".ok"));
     okay.click();
    }

    public String getDeletePlaylistMessage() {
            WebElement notification = driver.findElement(By.cssSelector(".alertify-logs.top.right"));
            return notification.getText();
        }
        public void loginCorrectMethod(){
            navigateToPage();
            provideEmail();
            providePassword();
            clickSubmit();
        }

    protected void rightCLickPlaylist() {
        WebElement rightClick = driver.findElement(By.cssSelector("#playlists> ul> li:nth-child(4)"));
        actions.contextClick(rightClick).perform();
    }
    protected void clickEdit() {
        WebElement editBtn = driver.findElement(By.cssSelector(".menu.playlist-item-menu ul > li:nth-child(1)"));
        editBtn.click();
    }

    public void enterNewName() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li.playlist.playlist.editing > input[type=text]")));
        WebElement newPlaylistName = driver.findElement(By.cssSelector("#playlists > ul > li.playlist.playlist.editing > a"));
        newPlaylistName.clear();
        newPlaylistName.sendKeys("Rename Playlist");
        newPlaylistName.click();
    }
    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}




