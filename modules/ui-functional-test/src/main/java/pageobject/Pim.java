package pageobject;

import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PIM.*
 */
public class Pim extends BasePage {

  @FindBy(xpath = "//a[contains(@class,\"oxd-main-menu-item\")][./span[text()='PIM']]")
  private static WebElement pimBtnDashboard;
  @FindBy(xpath = "//button[text() = ' Add ']")
  private static WebElement addBtnPim;
  @FindBy(xpath = "//input[contains(@name, \"firstName\")]")
  private static WebElement firstName;
  @FindBy(xpath = "//input[contains(@name, \"lastName\")]")
  private static WebElement lastName;
  @FindBy(xpath = "//button[text() = ' Save ']")
  private static WebElement saveBtnPim;
  @FindBy(xpath = "//h6[text() = 'Personal Details']")
  private static WebElement personalDetailsPim;
  @FindBy(xpath = "//p[text()='Successfully Saved']")
  private static WebElement successPopup;
  WebDriver driver;

  public Pim(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /**
   * createUseronPimPage.
   **/
  public void createUserOnPimPage(String inputFirstName, String inputlastName) {
    pimBtnDashboard.click();
    addBtnPim.click();
    firstName.sendKeys(inputFirstName);
    lastName.sendKeys(inputlastName);
    saveBtnPim.click();
    explicitWaitElemenetVisible(personalDetailsPim);
    successPopup.isDisplayed();
    personalDetailsPim.isDisplayed();
//    explicitWaitElemenetVisible(successPopup);
  }
}
