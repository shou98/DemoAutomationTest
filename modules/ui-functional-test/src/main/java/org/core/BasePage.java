package org.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesFile;

/**
 * BasePage.
 */
public class BasePage {

  public static WebDriver driver;
  public Properties properties;
  public PropertiesFile propertiesFile;
  String browserName;
  private static Integer ajaxWaitSeconds;
  public static Integer getAjaxWaitSeconds() {
    return ajaxWaitSeconds;
  }

  public WebElement explicitWaitElemenetVisible(WebElement elements) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOf(elements));
  }

  /**
   * Open URL.
   */
  public void open(String env) throws IOException {
//    String browserName = Driver.getParameter("browser");
//    driver = new Driver(browserName);
    if (env.contains("OrangeHrm")) {
      env = PropertiesFile.getDataOrangeHrm("orangeHrm");
      this.invokeBrowser();
      driver.get(env);
    }
  }
  public static String getParameter(String name) {
    String browserName = System.getProperty(name);
    if (browserName.isEmpty()) {
      throw new RuntimeException(name + " is empty!");
    }
    return browserName;
  }
  public WebDriver invokeBrowser() throws IOException {
    browserName = System.getProperty("browser");
    boolean headless =
        propertiesFile.getPropertiesFileSeleniumConfig("local.browser.headless").equals("true");
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    if (browserName.equals("chrome") && headless) {
      options.addArguments("--headless");
      options.addArguments("--disable-gpu");
    }
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    return driver;
  }
  public void close(){
    driver.close();
  }
  public void actionSendKeys(String keys) {
    Actions act = new Actions(driver);
    act.sendKeys(keys).perform();
  }
}
