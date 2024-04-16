package pageobject;

import org.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Dashboard.
 **/
public class Dashboard extends BasePage {

  WebDriver driver;
  @FindBy(xpath = "//h6[text()='Dashboard']")
  private WebElement dashBoardTitle;

  @FindBy(xpath = "//input[@placeholder='Search']")
  private WebElement search;

  /**
   * Dashboard.
   **/
  public Dashboard(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /**
   * get Title Dashboard.
   */
  public void dashboardIsDisplayed() {
    dashBoardTitle.isDisplayed();
    search.isDisplayed();
  }

  /**
   * verify full name on dashboard page.
   **/
  public void verifyName(String firstName, String lastName) {
    String fullName = String.format(firstName + " " + lastName);
    WebElement checkName = driver.findElement(
        By.xpath("//span[@class=\"oxd-userdropdown-tab\"]//p[text()= '" + fullName + "']"));
    checkName.isDisplayed();
  }
}
