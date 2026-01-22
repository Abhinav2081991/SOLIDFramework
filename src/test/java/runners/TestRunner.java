package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"html:target/cucumber-reports/cucumber-report.json","pretty","json:target/cucumber-reports/cucumber-report.json"},
        tags = "@Main"
//tags = "~@Main or @Datatable1"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
