package core.context;

import core.drivers.DriverManager;
import core.waits.WaitResolver;
import core.waits.WaitStrategyConfig;
import org.openqa.selenium.WebDriver;
import services.ClickActions;
import services.Decorator.*;
import services.SeleniumClickActions;
import services.SeleniumTypeActions;
import services.TypeActions;

public class TestContext {

    private final WebDriver driver;
    private final WaitResolver waitResolver;
    private final ClickActions clickActions;
    private final TypeActions typeActions;
    private final ScenarioContext scenarioContext;
    private final ClickActionsDecoratorInterface clickActionsDecoratorInterface;

    public TestContext() {
        this.driver = DriverManager.getDriver();
        this.waitResolver = new WaitResolver(WaitStrategyConfig.create(driver));
        this.clickActions = new SeleniumClickActions(waitResolver);
        this.typeActions =  new SeleniumTypeActions(waitResolver);
        this.scenarioContext = new ScenarioContext();
        this.clickActionsDecoratorInterface = new SeleniumClickActionsBaseDecorator(
                new SeleniumClickActionsRetryDecorator( new SeleniumActionsLoggingDecorator(new SeleniumClickActionsD())
                        )) {
        };
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WaitResolver getWaitResolver() {
        return waitResolver;
    }

    public ClickActions getSeleniumClickActions() {
        return clickActions;
    }

    public TypeActions getSeleniumTypeActions() {
        return typeActions;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public ClickActionsDecoratorInterface getClickActionsDecoratorInterface() {
        return clickActionsDecoratorInterface;
    }
}
