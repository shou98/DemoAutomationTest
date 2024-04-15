package uistepdefs;

import io.cucumber.java.After;
import org.core.BasePage;
import org.openqa.selenium.WebDriver;

/** Hook Config. */
public class Hooks extends BasePage {
  public WebDriver driver;
  @After
  public void afterEveryScenarion() {
    driver.close();
  }
}
