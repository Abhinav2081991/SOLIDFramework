package BusinessSteps;

import core.context.TestContext;
import pages_hackerrankTest.BasePage;
import pages_hackerrankTest.RegisterPage;

public class RegistrationSteps {


    RegisterPage registerPage;
    BasePage basePage;

    public RegistrationSteps(TestContext testContext){
        registerPage = new RegisterPage(testContext);
        basePage = new BasePage(testContext);
    }

    public void RegisterUser(){
        registerPage.fillForm();
    }


}
