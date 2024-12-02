package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I'm on login page of herokuapp website")
    public void i_m_on_login_page_of_herokuapp_website() {
       driver.get("https://the-internet.herokuapp.com/login");
    }

    @And("I entered valid username {string} and password {string}")
    public void i_entered_valid_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click teh login button")
    public void i_click_teh_login_button() {
        driver.findElement(By.cssSelector(".fa")).click();
    }

    @Then("I should be taken to the login welcome page")
    public void i_should_be_taken_to_the_login_welcome_page() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-2x")).isDisplayed());
    }

    @Given("I entered invalid username {string} and password {string}")
    public void i_entered_invalid_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @Then("I should see error message")
    public void i_should_see_error_message() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".flash")).isDisplayed());
    }

    @When("I try to login with the following credentials:")
    public void i_try_to_login_with_the_following_credentials(DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> user: users){
            String username = user.get("username");
            String password = user.get("password");

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.cssSelector(".fa")).click();
        }
    }


}
