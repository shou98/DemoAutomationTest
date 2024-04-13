package uistepdefs;

import static uicore.UiBasePage.driver;

import io.cucumber.java.After;

/** Hook Config. */
public class Hooks {

  @After()
  public void afterEveryScenarion() {
    driver.quit();
  }
}
