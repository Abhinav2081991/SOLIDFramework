package services.Decorator;

import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.WebElement;

public class SeleniumActionsLoggingDecorator extends SeleniumClickActionsBaseDecorator {


    public SeleniumActionsLoggingDecorator(ClickActionsDecoratorInterface clickActionsDecoratorInterface) {
        super(clickActionsDecoratorInterface);
    }

    @Override
    public void click(WebElement element) {
        System.out.println("Implement logging with this click methif.");
        clickActionsDecoratorInterface.click(element);
    }
}

