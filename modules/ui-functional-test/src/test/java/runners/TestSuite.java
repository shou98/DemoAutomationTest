package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** runner config. */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "uistepdefs",
    plugin = {"pretty"},
    stepNotifications = true)
public class TestSuite {}
