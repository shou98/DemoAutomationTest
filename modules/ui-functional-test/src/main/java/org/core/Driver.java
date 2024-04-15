//package org.core;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeOptions;
//import utils.PropertiesFile;
//
///** Driver implements Webdriver. */
//public class Driver implements WebDriver {
//
//  WebDriver driver;
//  String browserName;
//
//  /** Driver. */
//  public Driver(String browserName) {
//    this.browserName = browserName;
//    PropertiesFile properties = new PropertiesFile();
//    boolean headless =
//        properties.getPropertiesFileSeleniumConfig("local.browser.headless").equals("true");
//    switch (browserName) {
//      case "chrome":
//      default:
//        ChromeOptions options = new ChromeOptions();
//        if (headless) {
//          options.addArguments("--headless");
//          options.addArguments("--disable-gpu");
//        }
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("start-maximized");
//        driver = WebDriverManager.chromedriver().capabilities(options).create();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        break;
//    }
//  }
//
//  /** getParameter. */
//  public static String getParameter(String name) {
//    String value = System.getProperty(name);
//    if (value.isEmpty()) {
//      throw new RuntimeException(name + " is empty!");
//    }
//    return value;
//  }
//
//  public void close() {
//    this.driver.close();
//  }
//
//  public WebElement findElement(By arg0) {
//    return this.driver.findElement(arg0);
//  }
//
//  public List<WebElement> findElements(By arg0) {
//    return this.driver.findElements(arg0);
//  }
//
//  public void get(String env) {
//    this.driver.get(env);
//  }
//
//  public String getCurrentUrl() {
//    return this.driver.getCurrentUrl();
//  }
//
//  public String getPageSource() {
//    return this.driver.getPageSource();
//  }
//
//  public String getTitle() {
//    return this.driver.getTitle();
//  }
//
//  public String getWindowHandle() {
//    return this.driver.getWindowHandle();
//  }
//
//  public Set<String> getWindowHandles() {
//    return this.driver.getWindowHandles();
//  }
//
//  public Options manage() {
//    return this.driver.manage();
//  }
//
//  public Navigation navigate() {
//    return this.driver.navigate();
//  }
//
//  public void quit() {
//    this.driver.quit();
//  }
//
//  public TargetLocator switchTo() {
//    return this.driver.switchTo();
//  }
//}
