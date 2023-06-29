package stepDefs;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginPageStepDef {
    public WebDriver driver;
    public LoginPage loginPg;

    @Given("User Launch Chrome browser")
    public void User_Launch_Chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPg = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String emailadd, String password) {
        loginPg.enterEmail(emailadd);
        loginPg.enterPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        loginPg.clickOnLoginButton();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        loginPg.clickOnLogoutButton();
    }

    @Then("close browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }


}
