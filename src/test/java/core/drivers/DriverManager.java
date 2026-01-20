package core.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    //Singleton class

    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverManager(){
    }

    public static WebDriver getDriver(){
       return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver){
        threadLocalDriver.set(driver);
    }

    public static void unload(){
        threadLocalDriver.remove();
    }

}
