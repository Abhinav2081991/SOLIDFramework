package stepDefinitions;

import core.drivers.DriverFactory;
import core.drivers.DriverManager;
import core.drivers.enums.BrowserType;
import core.drivers.strategy.DriverStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setup( Scenario scenario) throws MalformedURLException {
        scenario.log("Test Setup");
        DriverFactory.initDriver();
        DriverManager.getDriver().get("https://demo.automationtesting.in/Register.html");
    }

    @After
    public void quitDriver(Scenario scenario){
        System.out.println(scenario.getName());
        DriverFactory.tearDown();
    }

}
