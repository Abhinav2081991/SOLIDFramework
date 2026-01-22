package stepDefinitions;

import core.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegisterPage;

public class StepDefinition {

    BasePage basePage;
    RegisterPage registerPage;

    public  StepDefinition(TestContext testContext){
        this.basePage = new BasePage(testContext);
        this.registerPage = new RegisterPage(testContext);
    }

    @Given("I am on the Register page of Automation Practice url")
    public void i_am_on_the_register_page_of_automation_practice_url() {
//        registerPage.fillForm();
        registerPage.fillFormUsingISP();
    }
    @When("I enter the details in the form")
    public void i_enter_the_details_in_the_form() {
        System.out.println("ss");
    }
    @When("I CLick on submit button")
    public void i_c_lick_on_submit_button() {
        System.out.println("ss");
    }
    @Then("I am able to successfully register")
    public void i_am_able_to_successfully_register() {
        System.out.println("ss");
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(10);
    }

    @AfterMethod
    public void tearDown(){
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
