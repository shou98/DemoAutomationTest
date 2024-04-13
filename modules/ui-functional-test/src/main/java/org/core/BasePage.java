package org.core;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesFile;

/** BasePage. */
public class BasePage {
  public static Driver driver;

  public static WebElement explicitWaitElemenetVisible(WebElement elements) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOf(elements));
  }

  /** Open URL. */
  public static void open(String env) {
    String browserName = Driver.getParameter("browser");
    driver = new Driver(browserName);
    if (env.contains("OrangeHrm")) {
      env = PropertiesFile.getDataOrangeHrm("orangeHrm");
      driver.get(env);
    }
  }
}
