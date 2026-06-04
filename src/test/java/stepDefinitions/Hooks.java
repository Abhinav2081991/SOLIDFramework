package stepDefinitions;

import com.aventstack.extentreports.Status;
import core.context.TestContext;
import core.drivers.DriverFactory;
import core.drivers.DriverManager;
import core.drivers.enums.BrowserType;
import core.drivers.strategy.DriverStrategy;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.ExtentManager;
import reports.ExtentTestManager;

import java.net.MalformedURLException;

public class Hooks {


    @Before
    public void setup( Scenario scenario) throws MalformedURLException {
//        ExtentTestManager.setExtent(
//                ExtentManager.getExtent()
//                        .createTest(scenario.getName())
//                        .assignCategory(scenario.getSourceTagNames().toString())
//        );
        scenario.log("Test Setup");
        DriverFactory.initDriver();
        DriverManager.getDriver().get("https://demo.automationtesting.in/Register.html");
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//            ExtentTestManager.getExtent()
//                    .log(Status.FAIL, "Step failed");
//        } else {
//            ExtentTestManager.getExtent()
//                    .log(Status.PASS, "Step passed");
//        }
//    }

    @After
    public void quitDriver(Scenario scenario){
//        if (scenario.isFailed()) {
//            ExtentTestManager.getExtent()
//                    .log(Status.FAIL, "Scenario Failed");
//        } else {
//            ExtentTestManager.getExtent()
//                    .log(Status.PASS, "Scenario Passed");
//        }

//        ExtentTestManager.unload();
//        ExtentManager.getExtent().flush();
        System.out.println(scenario.getName());
        DriverFactory.tearDown();
    }


}
