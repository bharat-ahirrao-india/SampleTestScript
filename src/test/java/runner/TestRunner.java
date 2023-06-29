package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/LoginFeature.feature",
        glue = "stepDefs",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-Report.html", "json:target/cucumber-Report.json"},
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

    TestNGCucumberRunner testNGCucumber = new TestNGCucumberRunner(this.getClass());
}
