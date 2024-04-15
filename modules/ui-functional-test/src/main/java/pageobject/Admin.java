package pageobject;

import static org.junit.Assert.*;

import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * PageAdmin.
 **/
public class Admin extends BasePage {

  @FindBy(xpath = "//a[contains(@class,\"oxd-main-menu-item\")][./span[text()='Admin']]")
  private static WebElement adminBtnDashboard;
  @FindBy(xpath = "//button[text() = ' Add ']")
  private static WebElement addBtnAdmin;
  @FindBy(xpath = "//div[contains(@class,\"oxd-select-text-input\")][1]")
  private static WebElement userRoleDropdown;
  @FindBy(xpath = "//div[contains(@class,\"oxd-select-option\")][./span[text()='Admin']]")
  private static WebElement roleAdminDropdown;

  @FindBy(xpath = "//label[contains(text(),'Status')]//parent::div//following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
  private static WebElement statusUserDropdown;
    @FindBy(xpath = "//div[@class = 'oxd-select-option']//span[text()= 'Enabled']")
  private static WebElement statusEnabled;

  @FindBy(xpath = "//input[contains(@placeholder,\"Type for hints...\")]")
  private static WebElement inputEmployeeName;
  @FindBy(xpath = "//div[contains(@class,\"oxd-autocomplete-option\")][./span[text()='Joy  Carter']]")
  private static WebElement selectEmployeeName;

  @FindBy(
      xpath =
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']//descendant::input[contains(@class, 'oxd-input oxd-input--active')]")
  private static WebElement inputUserName;
    @FindBy(
      xpath =
          "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
  private static WebElement redMessage;

  @FindBy(
      xpath =
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']//descendant::input[contains(@type, 'password')]")
  private static WebElement inputPassword;
  @FindBy(
      xpath =
          "//div[@class='oxd-grid-item oxd-grid-item--gutters']//descendant::input[contains(@type, 'password')]")
  private static WebElement inputCfPassword;
  @FindBy(xpath = "//button[text() = ' Save ']")
  private static WebElement saveBtnAdmin;
  @FindBy(xpath = "//p[text()='Successfully Saved']")
  private static WebElement successPopup;

  WebDriver driver;

  public Admin(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /**
   * Create new user on admin page.
   **/

  public void createAdmin(
      String role, String employeeName, String status, String username, String password)
      throws InterruptedException {
    adminBtnDashboard.click();
    addBtnAdmin.click();
    userRoleDropdown.click();
    roleAdminDropdown.click();
    statusUserDropdown.click();
    statusEnabled.click();
    inputEmployeeName.sendKeys(employeeName);
    selectEmployeeName.click();
    inputUserName.sendKeys(username);
    inputPassword.sendKeys(password);
    inputCfPassword.sendKeys(password);
    verifyElementNotDisplayed(redMessage);
    Thread.sleep(1000);
    saveBtnAdmin.click();
    Thread.sleep(7000);
    assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
  }
}
