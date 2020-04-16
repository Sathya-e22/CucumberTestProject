package TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features=".//Features/Customers.Feature",
					glue="StepDefinitions",
					dryRun = false, monochrome=true,
					plugin= {"pretty", "html:test-output"}
				)
			
public class TestRun extends AbstractTestNGCucumberTests{

}
