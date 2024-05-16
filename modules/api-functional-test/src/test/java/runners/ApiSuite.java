package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * runner config.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "apistepdefs",
    plugin = {"json:target/cucumber/cucumber.json",
        "pretty",
        "html:target/cucumber-html-reports/cucumber.html"},
    stepNotifications = true,
    tags = "@API")
public class ApiSuite {
}
