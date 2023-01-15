package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/AppFeatures"},
		glue = {"stepdefinition" ,"appHooks"},
		/*tags = "not @Regression",*/
		plugin = {"pretty",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				   "timeline:test-output-thread/",
				   "rerun:target/failedRerun.txt"}				   
		)

public class MyTestRunner {
	
	
}
