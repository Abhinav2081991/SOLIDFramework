package services.Decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

public class SeleniumClickActionsRetryDecorator extends SeleniumClickActionsBaseDecorator {

    public SeleniumClickActionsRetryDecorator(ClickActionsDecoratorInterface clickActionsDecoratorInterface){
        super(clickActionsDecoratorInterface);
    }

    @Override
    public void click(WebElement element) {
        int max_Attempts = 5;
        int attempts = 1;
        while(attempts <= max_Attempts){
            try{
                System.out.println("Click try " + attempts);
                clickActionsDecoratorInterface.click(element);

                return;
            }catch (ElementClickInterceptedException e){
                if (attempts==max_Attempts){
                    throw e;
                }
                attempts++;
            }

        }

    }
}
