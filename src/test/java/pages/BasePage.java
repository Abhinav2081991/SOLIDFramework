package pages;

import core.context.TestContext;
import core.drivers.DriverManager;
import core.waits.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    WaitResolver waitResolver;

    public BasePage(TestContext testContext){
        this.driver  = testContext.getDriver();
        this.waitResolver = testContext.getWaitResolver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement register;

    public void  click(WebElement element){
        waitResolver.resolve(WaitType.CLICK).waitFor(element,10).click();
    }

    public void type(WebElement element, String text){
        waitResolver.resolve(WaitType.CLICK).waitFor(element,10).sendKeys(text);
    }

    public String getTestOfElement(WebElement element){
        return waitResolver.resolve(WaitType.VISIBLE).waitFor(element,10).getText();
    }
}
