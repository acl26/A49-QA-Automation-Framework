import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeSuite
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    public void provideEmail() {
        WebElement loginInput = driver.findElement(By.cssSelector("[type='email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("anna.gertzen@testpro.io");
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void clickSubmit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();
    }

    public void providePassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
    }



//    public void searchSong() {
//        WebElement search = driver.findElement(By.cssSelector("[type='search'])"));
//        search.clear();
//        search.sendKeys("Episode 2");
//        search.click();
//    }


//    protected void addSongtoAPlaylist() {
//        WebElement addTo = driver.findElement(By.cssSelector("#songsWrapper [data-test='add-to-btn']"));
//        addTo.click();
//
//        WebElement newPlaylist = driver.findElement(By.cssSelector(".existing-playlists> ul > li:nth-child(5) "));
//        newPlaylist.click();
//    }
//
//    protected void clickFirstSong() {
//        WebElement firstSong = driver.findElement(By.cssSelector("#queueWrapper div div div table .title"));
//        firstSong.click();
//    }
//
//    protected void viewAllSongs() {
//        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
//        viewAll.click();
//    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }

    public void searchSong() throws InterruptedException {
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.clear();
        search.sendKeys("Episode 2");
        Thread.sleep(2000);
    }

    public void viewAllSongs() throws  InterruptedException{
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    public void clickFirstSong()throws  InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws  InterruptedException {
        WebElement newPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'AAA')]"));
        newPlaylist.click();
        Thread.sleep(2000);
    }

    public void addToPlaylist() throws  InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public String getAddtoPlaylistSuccessMsg() throws InterruptedException {
        WebElement notification = driver.findElement(By.cssSelector(".alertify-logs.top.right"));
        return notification.getText();
    }
}