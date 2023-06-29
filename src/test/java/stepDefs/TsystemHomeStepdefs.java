package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TsystemHomeStepdefs {
    static WebDriver driver;

    @Given("User Launch the Chrome browser")
    public void User_Launch_the_Chrome_browser() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("User opens TSystems URL")
    public void User_opens_TSystems_URL () {
        driver.navigate().to("https://www.t-systems.com/in/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @And("Click on SearchButton")
    public void Click_on_SearchButton() {
        driver.findElement(By.xpath("//*[@id=\"top\"]/div[3]/div/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
        @Then("User can view SearchPage")
        public void User_can_view_SearchPage () {
            driver.findElement(By.id("searchterm")).sendKeys("T Systems India");
            driver.findElement(By.xpath("//*[@id=\"top\"]/div[4]/div[1]/div[1]/div/div/form/div/div/button")).click();
        }
    }
