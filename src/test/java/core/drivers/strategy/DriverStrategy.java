package core.drivers.strategy;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverStrategy {
    public WebDriver driverStrategy() throws MalformedURLException;
}
