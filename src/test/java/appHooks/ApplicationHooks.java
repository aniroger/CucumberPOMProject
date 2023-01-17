package appHooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.*;

public class ApplicationHooks {

	private DriverFactory driverfactory;

	private WebDriver driver;

	private ConfigReader configReader;

	Properties prop;
	
	
	@Before(value = "@Regression" , order = 0)
	public void skipscenario(Scenario scenario)
	{
		System.out.println("SKIPPED scenario is :" + scenario.getName());
		Assume.assumeTrue(false);
	}

	@Before(order = 0)
	public void getProperty() {

		configReader = new ConfigReader();

		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchbrowser() {

		String browsername = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browsername); // here driver is used to avoid nullpointerexcep in line no 42
		
	}

	@After(order = 0)
	public void quitbrowser() {

		driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario scenario) {
		
		if(scenario.isFailed())
		{
			// take screenshot
			
			String screenshotname = scenario.getName().replaceAll(" ", " _ ");
			
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcepath, "image/png", screenshotname);
		}

	}

}
