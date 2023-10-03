package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="src/test/resource/featuress",
				glue= {"stepDefinition","hooks"},
				plugin= {"pretty",
						"html:target/CucumberReports/Reports.html",
						"timeline:test-output-thread/"}
				//,tags = "@Login"
				)

public class RunCucumberTest {
	
	
}
