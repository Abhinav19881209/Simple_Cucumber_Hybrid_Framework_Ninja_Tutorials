package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="src/test/resource/featuress/Login.feature",
				glue= {"stepDefinition","hooks"},
				plugin= {"pretty","html:target/CucumberReports/Reports.html"},
				tags = "@Login"
				)
public class TestRunner {


}
