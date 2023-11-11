package myRunner;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;


@CucumberOptions(
				features="src/test/resource/featuress",
				glue= {"stepDefinition","hooks"},
				plugin= {"pretty","html:target/CucumberReports/Reports.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				//tags = "@Login"
				)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
	@BeforeTest
	@Parameters({"browser"})
	public void defbrowser(String browser) {
		
		ConfigReader.setBrowserType(browser);
	}

}
