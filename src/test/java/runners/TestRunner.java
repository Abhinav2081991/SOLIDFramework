package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"html:target/cucumber-reports/cucumber-report.json","pretty","json:target/cucumber-reports/cucumber-report.json"},
        tags = "@Datatable3"
//tags = "~@Main or @Datatable1"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
