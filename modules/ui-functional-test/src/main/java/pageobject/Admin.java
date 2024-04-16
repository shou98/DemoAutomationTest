package pageobject;

import static org.junit.Assert.assertEquals;

import org.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
  @FindBy(xpath = "//label[contains(text(),'Username')]/following::input")
  private static WebElement searchUserF;
  @FindBy(xpath = "//button[text() = ' Search ']")
  private static WebElement searchBtnAdmin;
  @FindBy(xpath = "//i[@class=\"oxd-icon bi-trash\"]")
  private static WebElement deleteBtnInAdmPage;
  @FindBy(xpath = "//button[text() = ' Yes, Delete ']")
  private static WebElement deleteBtnCfInAdmPage;

  @FindBy(xpath = "//button[text() = ' Add ']")
  private static WebElement addBtnAdmin;
  @FindBy(xpath = "//div[contains(@class,\"oxd-select-text-input\")][1]")
  private static WebElement userRoleDropdown;
  @FindBy(xpath = "//div[contains(@class,\"oxd-select-option\")][./span[text()='Admin']]")
  private static WebElement roleAdminDropdown;
  @FindBy(xpath = "//label[contains(text(),'Status')]//following::div[text() = '-- Select --']")
  private static WebElement statusUserDropdown;
  @FindBy(xpath = "//div[@class = 'oxd-select-option']//span[text()= 'Enabled']")
  private static WebElement statusEnabled;

  @FindBy(xpath = "//input[contains(@placeholder,\"Type for hints...\")]")
  private static WebElement inputEmployeeName;
  @FindBy(xpath = "//span[text()='Joy  Carter']")
  private static WebElement selectEmployeeName;
  @FindBy(xpath = "//label[contains(text(),'Username')]//following::input")
  private static WebElement inputUserName;
  @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message')]")
  private static WebElement redMessage;
  @FindBy(xpath = "//label[contains(text(),'Password')]//following::input")
  private static WebElement inputPassword;
  @FindBy(xpath = "//label[contains(text(),'Confirm Password')]//following::input")
  private static WebElement inputCfPassword;
  @FindBy(xpath = "//button[text() = ' Save ']")
  private static WebElement saveBtnAdmin;
  @FindBy(xpath = "//p[text()='Successfully Saved']")
  private static WebElement successPopup;

  WebDriver driver;

  /**
   * Admin.
   **/
  public Admin(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  /**
   * check username before create.
   **/
  public void checkUserName(String username) throws InterruptedException {
    searchUserF.click();
    searchUserF.sendKeys(username);
    searchBtnAdmin.click();
    try {
      WebElement checkName = driver.findElement(
          By.xpath("//div[@class=\"oxd-table-card\"]//div[text()='" + username + "']"));
      explicitWaitElementVisible(checkName);
      deleteBtnInAdmPage.click();
      explicitWaitElementVisible(deleteBtnCfInAdmPage);
      deleteBtnCfInAdmPage.click();
    } catch (NoSuchElementException exception) {
      System.out.println("Không tìm thấy user name");
    }
  }

  /**
   * Create new user on admin page.
   **/
  public void createAdmin(
      String role, String employeeName, String status, String username, String password)
      throws InterruptedException {
    adminBtnDashboard.click();
    checkUserName(username);
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
    assertEquals(driver.getCurrentUrl(),
        "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
  }
}
