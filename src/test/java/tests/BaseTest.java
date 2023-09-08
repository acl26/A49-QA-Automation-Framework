package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import org.openqa.selenium.edge.EdgeOptions;


public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getThreadDriver() {return threadDriver.get();}


    @BeforeClass
//    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(setupBrowser("browser"));
        driver=setupBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }
    @AfterClass
    public void closeBrowser() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    public void navigateToPage() {
        driver.get(url);
    }

    WebDriver setupBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL="http://192.168.1.152:4444";

        switch (browser){
            case "MicrosoftEdge":
                return setupEdge();
            case "chrome":
                return setupChrome();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                return setupChrome();

        }
    }


    WebDriver setupEdge () {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver();
        return driver;
    }
    WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;

    }
}




