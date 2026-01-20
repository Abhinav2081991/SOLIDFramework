package core.drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.sql.Driver;

public class DriverFactory {

    public static DriverStrategy getDriverStrategy(String browser){

        switch (browser){
            case "Chrome":
                return new ChromeDriverStrategy();
            case "Edge":
                return new EdgeDriverStrategy();
            case "Grid":
                return new GridStrategy();
            default:
                throw new IllegalArgumentException("Invalid Selection");
        }
    }

    public static void initDriver(DriverStrategy driverStrategy) throws MalformedURLException {
        WebDriver driver = driverStrategy.driverStrategy();
        DriverManager.setDriver(driver);
    }

    public static void tearDown(){
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }


}
