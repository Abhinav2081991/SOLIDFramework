package stepDefinitions;

import core.drivers.DriverFactory;
import core.drivers.DriverManager;
import core.drivers.DriverStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setup( Scenario scenario) throws MalformedURLException {
        scenario.log("Test Setup");
        DriverStrategy driverStrategy = DriverFactory.getDriverStrategy("Chrome");
        DriverFactory.initDriver(driverStrategy);
        DriverManager.getDriver().get("https://demo.automationtesting.in/Register.html");
    }

    @After
    public void quitDriver(Scenario scenario){
        System.out.println(scenario.getName());
        DriverFactory.tearDown();
    }

}
