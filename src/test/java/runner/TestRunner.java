package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/feature",glue = "steps", plugin = {"pretty","html:target/reports/RestAssured.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
