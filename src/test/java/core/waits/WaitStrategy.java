package core.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WaitStrategy {

    public WebElement waitFor(WebElement element, int seconds);
}
