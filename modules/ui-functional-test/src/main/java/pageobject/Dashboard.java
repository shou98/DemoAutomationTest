package pageobject;

import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**Dashboard.**/
public class Dashboard extends BasePage {
  WebDriver driver;
  @FindBy(xpath = "//h6[text()='Dashboard']")
  private WebElement dashBoard;

  @FindBy(xpath = "//input[@placeholder='Search']")
  private WebElement search;
  public Dashboard() {
    super();
    PageFactory.initElements(driver, this);
  }

  public Dashboard(String pageType, WebDriver driver) {
    super();
    PageFactory.initElements(driver, this);
  }
  /** get Title Dashboard. */
  public void dashboardIsDisplayed() {
    dashBoard.isDisplayed();
    search.isDisplayed();
  }
}
