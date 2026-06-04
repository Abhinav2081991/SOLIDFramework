package pages_hackerrankTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assessment {
    WebDriver driver;

    @BeforeMethod
    public void launchBrowserAndApplication(){
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void TestLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getTitleOfHolePage(),"OrangeHRM");
    }

    @Test
    public void TestLoginWithInvalidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("WrongUsername");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getTextForInvalidCredentials(),"Invalid credentials");
    }

    @Test
    public void TestLoginWithEmptyCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.validateRequiredUsername(),"Required");
        Assert.assertEquals(loginPage.validateRequiredPassword(),"Required");
    }


    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
