package org.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
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

  public BasePage() {
    PageFactory.initElements(driver, this);
  }

  public void explicitWaitElementVisible(WebElement elements) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOf(elements));
  }

  /**
   * Open URL.
   */
  public void open(String env) throws IOException {
    if (env.contains("OrangeHrm")) {
      env = PropertiesFile.getDataOrangeHrm("orangeHrm");
      this.invokeBrowser();
      driver.get(env);
    }
  }

  public void invokeBrowser() throws IOException {
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
  }

  public boolean verifyElementNotDisplayed(WebElement element) throws InterruptedException {
    Thread.sleep(3000);
    try {
      if (element.isDisplayed()) {
        return false;
      }
      return false;
    } catch (Exception e) {
      System.out.println("No element is displayed");
      return true;
    }
  }
}
