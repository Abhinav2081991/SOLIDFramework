package core.waits;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class WaitStrategyConfig {

    public static Map<WaitType, WaitStrategy> create(WebDriver driver){
        Map<WaitType, WaitStrategy> strategyMap = new HashMap<>();
        strategyMap.put(WaitType.CLICK, new ClickableWaitStrategy(driver));
        strategyMap.put(WaitType.VISIBLE, new VisibleWaitStrategy(driver));
        return strategyMap;
    }

}
