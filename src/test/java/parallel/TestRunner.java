package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.testng.runner.RunWith;


import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
				features="src/test/resource/parallel/Login.feature",
				glue= {"parallel"},
				plugin= {"pretty","html:target/CucumberReports/Reports.html"}
				//tags = "@Login"
				)

public class TestRunner extends AbstractTestNGCucumberTests{

	   @Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

}
