package TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= {".//Features/Customers.Feature", ".//Features/Login.Feature"},
					glue="StepDefinitions",
					dryRun = false, monochrome=true,
					plugin= {"pretty", "html:test-output"}, 
					tags= {"@sanity"}
				)
			
public class TestRun extends AbstractTestNGCucumberTests{

}
