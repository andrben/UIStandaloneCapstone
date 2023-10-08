package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, plugin = { "pretty", "html:target/report.html",
				"json:target/cucumber.json" },
		features = "src/test/resources/Feature",
		glue = "stepdefs",
		stepNotifications = true)

public class TestRunner {

}
