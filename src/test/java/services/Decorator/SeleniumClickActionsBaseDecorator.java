package services.Decorator;

import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.WebElement;

public abstract class SeleniumClickActionsBaseDecorator implements ClickActionsDecoratorInterface {

    ClickActionsDecoratorInterface clickActionsDecoratorInterface;

   public SeleniumClickActionsBaseDecorator(ClickActionsDecoratorInterface clickActionsDecoratorInterface){
       this.clickActionsDecoratorInterface = clickActionsDecoratorInterface;
   }

    @Override
    public void click(WebElement element) {
       clickActionsDecoratorInterface.click(element);
    }

}
