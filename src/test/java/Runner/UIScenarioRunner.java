package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/Features/UIScenario.feature"},
		glue={"StepDefinations"},
		plugin= {"html:target/cucumber-html-report/index.html"}
		)
public class UIScenarioRunner {

}

