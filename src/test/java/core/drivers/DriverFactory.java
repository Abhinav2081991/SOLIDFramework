package core.drivers;

import core.drivers.browseroptions.BrowserOptionsProvider;
import core.drivers.browseroptions.ChromeOptionsProvider;
import core.drivers.browseroptions.EdgeOptionsProvider;
import core.drivers.enums.BrowserType;
import core.drivers.enums.ExecutionType;
import core.drivers.strategy.DriverStrategy;
import core.drivers.strategy.GridDriverStrategy;
import core.drivers.strategy.LocalDriverStrategy;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.sql.Driver;

public class DriverFactory {

//    public static DriverStrategy getDriverStrategy(String browser){
//
//        switch (browser){
//            case "Chrome":
//                return new ChromeDriverStrategy();
//            case "Edge":
//                return new EdgeDriverStrategy();
//            case "Grid":
//                return new GridStrategy();
//            default:
//                throw new IllegalArgumentException("Invalid Selection");
//        }
//    }
//
//    public static void initDriver(DriverStrategy driverStrategy) throws MalformedURLException {
//        WebDriver driver = driverStrategy.driverStrategy();
//        DriverManager.setDriver(driver);
//    }

    public static void initDriver() throws MalformedURLException {

        BrowserType browser = BrowserType.valueOf(System.getProperty("browser"));

        ExecutionType execution = ExecutionType.valueOf(System.getProperty("execution"));

        String gridUrl = System.getProperty("gridUrl");

        BrowserOptionsProvider browserOptions = switch(browser){
            case CHROME -> new ChromeOptionsProvider();
            case EDGE -> new EdgeOptionsProvider();
        };

        MutableCapabilities options = browserOptions.getBrowserOptions();

        DriverStrategy strategy = switch(execution){
            case LOCAL -> new LocalDriverStrategy(browser.name(), options);
            case GRID -> new GridDriverStrategy(gridUrl, options);
        };

        DriverManager.setDriver(strategy.driverStrategy());

    }

    public static void tearDown(){
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }


}
