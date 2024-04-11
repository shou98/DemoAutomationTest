package uistepdefs;

import static core.BasePage.driver;

import core.BasePage;
import io.cucumber.java.After;

/** Hook Config. */
public class Hooks {
  BasePage basePage;

  @After()
  public void afterEveryScenarion() {
    driver.quit();
  }
}
