package services;

import core.context.TestContext;
import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.WebElement;

public class SeleniumTypeActions implements TypeActions{

    WaitResolver resolver;

    public SeleniumTypeActions(WaitResolver resolver){
        this.resolver = resolver;
    }

    @Override
    public void type(WebElement element, String text) {
        resolver.resolve(WaitType.VISIBLE).waitFor(element,10).sendKeys(text);
    }
}
