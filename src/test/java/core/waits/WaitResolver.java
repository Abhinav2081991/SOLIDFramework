package core.waits;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WaitResolver {

    private Map<WaitType, WaitStrategy> strategies = new HashMap<>();

//     public  WaitResolver(WebDriver driver){
//         strategies.put(WaitType.CLICK, new ClickableWaitStrategy(driver));
//         strategies.put(WaitType.VISIBLE, new VisibleWaitStrategy(driver));
//     }

    public WaitResolver(Map<WaitType, WaitStrategy> strategies){
        this.strategies = strategies;
    }

     public WaitStrategy resolve(WaitType waitType){

         if(!strategies.containsKey(waitType)){
             throw new IllegalArgumentException("Wrong wait type selected" + waitType);
         }else {
             return strategies.get(waitType);
         }
     }

}
