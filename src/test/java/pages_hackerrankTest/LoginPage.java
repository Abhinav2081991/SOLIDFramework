package pages_hackerrankTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameEle;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordEle;

    @FindBy(xpath = "//button")
    WebElement loginButtonEle;

    @FindBy(xpath = "//*[@role='alert']//p")
    WebElement invalidCredentialsMessage;


    public void enterUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(usernameEle));
        usernameEle.sendKeys(username);
    }

    public String getTitleOfHolePage(){
        return driver.getTitle();
    }

    public void enterPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(passwordEle));
        passwordEle.sendKeys(password);
    }

    public void clickOnLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonEle));
        loginButtonEle.click();
    }

    public String getTextForInvalidCredentials(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(invalidCredentialsMessage));
        return  invalidCredentialsMessage.getText();
    }


     public String validateRequiredUsername(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span"))));
         WebElement ele = driver.findElements(By.xpath("//span")).getFirst();
        return  ele.getText();
     }

    public String validateRequiredPassword(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span"))));
        WebElement ele = driver.findElements(By.xpath("//span")).get(1);
        return  ele.getText();
    }
}
