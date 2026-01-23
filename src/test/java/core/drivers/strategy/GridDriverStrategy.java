package core.drivers.strategy;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriverStrategy implements DriverStrategy{

    String gridUrl;
    MutableCapabilities options;

    public GridDriverStrategy(String gridUrl, MutableCapabilities options) {
        this.gridUrl = gridUrl;
        this.options = options;
    }

    @Override
    public WebDriver driverStrategy() throws MalformedURLException {
        return new RemoteWebDriver(new URL(gridUrl), options);
    }
}
