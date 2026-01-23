package core.drivers.strategy;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;

public class LocalDriverStrategy implements DriverStrategy{

    String browser;
    MutableCapabilities options;

     public LocalDriverStrategy(String browser, MutableCapabilities options){
         this.browser = browser;
         this.options = options;
     }

    @Override
    public WebDriver driverStrategy() throws MalformedURLException {
         switch(browser){
             case "CHROME":
                 return new ChromeDriver((ChromeOptions) options);
             case "EDGE":
                 return  new EdgeDriver((EdgeOptions) options);
             default:
                 throw new IllegalArgumentException("Invalid Selection");
         }
    }
}
