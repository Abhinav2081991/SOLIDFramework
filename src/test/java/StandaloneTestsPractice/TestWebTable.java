package StandaloneTestsPractice;

import core.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestWebTable {

    WebDriver driver;
//    @Test
    public void testWebtable(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        WebElement  table = driver.findElement(By.cssSelector(".table.table-striped.mt-3"));
        GetListOfTableRows();

    }

    public void GetListOfTableRows(){

        List<TableRow> rows = new ArrayList<>();
        for(WebElement ele : driver.findElements(By.cssSelector("table tbody tr")) ){
            TableRow row = TableRow.builder()
                    .firstName(ele.findElement(By.cssSelector("td:nth-child(1)")).getText())
                    .lastName(ele.findElement(By.cssSelector("td:nth-child(2)")).getText())
                    .age(Integer.parseInt((ele.findElement(By.cssSelector("td:nth-child(3)")).getText()))).build();

            rows.add(row);
        }

        for(TableRow r : rows){
            System.out.println(r.getFirstName() + "-"+r.getLastName() +" "+ r.getAge());
        }
        System.out.println("--------------------");

        rows.sort(Comparator.comparing(TableRow::getFirstName).thenComparing(TableRow::getLastName));

        for(TableRow r : rows){
            System.out.println(r.getFirstName() + "-"+r.getLastName() +" "+ r.getAge());
        }

        rows.sort(Comparator.comparing(s -> s.getFirstName().length()));

        System.out.println("--------------------");
        for(TableRow r : rows){
            System.out.println(r.getFirstName() + "-"+r.getLastName() +" "+ r.getAge());
        }

        boolean b = rows.stream().anyMatch(s->s.getFirstName().equals("Alden"));
        System.out.println(b);

        rows.stream().collect(Collectors.toList());





    }
}
