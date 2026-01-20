package core.waits;

import core.drivers.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VisibleWaitStrategy implements  WaitStrategy{

    WebDriver driver;

    public VisibleWaitStrategy(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public WebElement waitFor( WebElement element, int seconds){
        System.out.println("Visible Strategy triggered");
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));



    }

}
