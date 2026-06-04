package StandaloneTestsPractice;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static graphql.Assert.assertFalse;

public class LocalizationTests {

//    @Test
    public void testLocalization(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.un.org/fr/");
        System.out.println(driver.getCurrentUrl().contains("fr"));  // locale.
        List<WebElement> texts = driver.findElements(By.xpath("//*[text()]"));
        for (WebElement e : texts) {
            System.out.println(e.getText());
            assertFalse(e.getText().matches("^[A-Za-z ]+$"),
                    "Hardcoded English text found: " + e.getText());
        }


        driver.quit();
    }
}
