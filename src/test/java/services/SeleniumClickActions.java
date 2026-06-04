package services;

import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.WebElement;

public class SeleniumClickActions implements ClickActions{

   WaitResolver waitResolver;

   public SeleniumClickActions(WaitResolver waitResolver){
       this.waitResolver = waitResolver;
   }

    @Override
    public void click(WebElement element) {
       waitResolver.resolve(WaitType.CLICK).waitFor(element,10).click();
    }
}
