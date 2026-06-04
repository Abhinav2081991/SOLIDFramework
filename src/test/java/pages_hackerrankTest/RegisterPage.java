package pages_hackerrankTest;

import core.context.TestContext;
import core.waits.WaitResolver;
import core.waits.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import services.*;
import services.Decorator.ClickActionsDecoratorInterface;

import java.util.List;

public class RegisterPage extends BasePage{

    WebDriver driver;
    WaitResolver waitResolver;
    ClickActions clickActions;
    TypeActions typeActions;
    ClickActionsDecoratorInterface clickActionsDecoratorInterface;
    public RegisterPage(TestContext testContext){
        super(testContext);
        this.driver = testContext.getDriver();
        this.waitResolver = testContext.getWaitResolver();
        this.clickActions = testContext.getSeleniumClickActions();
        this.typeActions = testContext.getSeleniumTypeActions();
        this.clickActionsDecoratorInterface = testContext.getClickActionsDecoratorInterface();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;


    public void test(){
        List<WebElement> list = driver.findElements(By.xpath("//button[@name='Available']"));
        list.stream().forEach(s -> s.click());

    }

//    public WebElement button = driver.findElements(By.xpath("//button")).stream()
//            .filter( x -> x.getText().equals("Submit")).findFirst().orElseThrow( NoSuchElementException::new);

    public WebElement getSubmitButton() {
//        WebElement element =  driver.findElements(By.xpath("//button")).stream()
//                .filter(WebElement ::isDisplayed)
//                .filter(btn -> btn.getText().trim().equals("Submit"))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Submit button not found"));
//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//        return element;// This is a problematic code  when executed in headless mode.
//        ExtentTestManager.getExtent().log(Status.INFO, "Method invoked");


        return driver.findElement(By.id("submitbtn"));
    }

    public void fillForm(){
        click(register);
        type(firstName,"Abhinav");
        type(lastName,"Tiwari");
        System.out.println(driver.getTitle());
        System.out.println(getTestOfElement(register));
        System.out.println(getSubmitButton().getText());
    }

    public void fillFormUsingISP(){
        clickActions.click(register);
        typeActions.type(firstName,"Abhinav");
        typeActions.type(lastName,"Tiwari");
        System.out.println(driver.getTitle());
        System.out.println(getTestOfElement(register));
        System.out.println(getSubmitButton().getText());

    }

    public void fillFormUsingDecorator(){
//        clickActionsDecoratorInterface.click(register);
        waitResolver.resolve(WaitType.CLICK).waitFor(getSubmitButton(),10);
        clickActionsDecoratorInterface.click(getSubmitButton()); // requires wait for.

    }

}
