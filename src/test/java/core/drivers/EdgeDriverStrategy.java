package core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverStrategy implements DriverStrategy{
    @Override
    public WebDriver driverStrategy() {
        return new EdgeDriver();
    }
}
