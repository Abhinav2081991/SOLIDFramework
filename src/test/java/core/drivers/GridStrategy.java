package core.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridStrategy implements DriverStrategy{
    @Override
    public WebDriver driverStrategy() throws MalformedURLException {
        return new RemoteWebDriver(new URL("Grid Url"), new MutableCapabilities());
    }
}
