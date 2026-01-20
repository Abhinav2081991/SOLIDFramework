package pages;

import core.context.TestContext;
import core.drivers.DriverManager;
import core.waits.WaitFactory;
import core.waits.WaitResolver;
import core.waits.WaitStrategy;
import core.waits.WaitType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import services.ClickActions;
import services.TypeActions;

public class RegisterPage extends BasePage{

    WebDriver driver;
    WaitResolver waitResolver;
    ClickActions clickActions;
    TypeActions typeActions;
    public RegisterPage(TestContext testContext){
        super(testContext);
        this.driver = testContext.getDriver();
        this.waitResolver = testContext.getWaitResolver();
        this.clickActions = testContext.getSeleniumClickActions();
        this.typeActions = testContext.getSeleniumTypeActions();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    public void fillForm(){
        click(register);
        type(firstName,"Abhinav");
        type(lastName,"Tiwari");
        System.out.println(driver.getTitle());
        System.out.println(getTestOfElement(register));
    }

    public void fillFormUsingISP(){
        clickActions.click(register);
        typeActions.type(firstName,"Abhinav");
        typeActions.type(lastName,"Tiwari");
        System.out.println(driver.getTitle());
        System.out.println(getTestOfElement(register));
    }

}
