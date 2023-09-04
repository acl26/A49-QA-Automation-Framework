import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
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
import pages.BasePage;
import pages.LoginPage;
import pages.PlaylistPage;


public class BaseTest {

    public WebDriver driver = null;
//    public String url;
    public static Actions actions = null;
    WebDriverWait wait;
    BasePage basePage;
    PlaylistPage playlistPage;
    LoginPage loginPage;


    public String url = "https://qa.koel.app/";


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

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
        basePage = new BasePage(driver, wait, actions);
        playlistPage = new PlaylistPage (driver, wait, actions);
        loginPage = new LoginPage(driver, wait, actions);
        basePage.navigateToPage(url);
    }

    @AfterMethod
    public void quitBrowser() { driver.quit(); }











}




