package uistepdefs;

import static org.core.BasePage.driver;

import io.cucumber.java.After;

/**
 * Hook Config.
 */
public class Hooks {

  @After
  public void afterEveryScenarion() {
    driver.quit();
  }
}
