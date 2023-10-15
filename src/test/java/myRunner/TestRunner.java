package myRunner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


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

}
