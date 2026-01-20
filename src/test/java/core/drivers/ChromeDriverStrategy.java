package core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverStrategy implements DriverStrategy{
    @Override
    public WebDriver driverStrategy() {
        return new ChromeDriver();
    }
}
