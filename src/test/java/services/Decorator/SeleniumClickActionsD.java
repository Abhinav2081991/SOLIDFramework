package services.Decorator;

import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.WebElement;
import services.ClickActions;

public class SeleniumClickActionsD implements ClickActionsDecoratorInterface {

//   private final WebElement element;

//   public SeleniumClickActionsD(WebElement element){
//       this.element = element;
//   }

    @Override
    public void click(WebElement element) {
        element.click();
    }
}
