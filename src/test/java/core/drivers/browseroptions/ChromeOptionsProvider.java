package core.drivers.browseroptions;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsProvider implements BrowserOptionsProvider{

    public ChromeOptions getBrowserOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new","--disable-gpu","--window-size=1920,1080","--no-sandbox","--disable-dev-shm-usage","--remote-allow-origins=*");
        // Very important to increase viewport size
        return  options;
    }
}
