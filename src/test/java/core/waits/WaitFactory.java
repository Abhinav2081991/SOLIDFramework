package core.waits;

import org.openqa.selenium.WebDriver;

public class WaitFactory {

    public static WaitStrategy getWaitType(WaitType wait, WebDriver driver){

        switch (wait){
            case CLICK:
                return new ClickableWaitStrategy(driver);
            case VISIBLE:
                return new VisibleWaitStrategy(driver);
            default:
                throw new IllegalArgumentException("Wrong wait type");
        }
    }




}
