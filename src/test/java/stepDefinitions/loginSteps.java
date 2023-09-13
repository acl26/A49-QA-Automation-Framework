package stepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class loginSteps {
    WebDriver driver;
    WebDriverWait wait;
    public loginSteps() {
        @Given("I open broswer")
        @Before
        public void openBrowser(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @And("I open Login page")
        public void openLoginPage() {
            driver.get("https://qa.koel.app/");
        }

//
//        When("^I enter email \"([^\"]*)\"$", (String arg0) -> {
//        });
//        And("^I enter password \"([^\"]*)\"$", (String arg0) -> {
//        });
//        And("^I submit$", () -> {
//        });
//        Then("^I am logged in$", () -> {
//        });
    }
}
