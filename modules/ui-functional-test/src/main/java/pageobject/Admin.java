package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**PageAdmin.**/
public class Admin {
  @FindBy(xpath = "//a[contains(@class,\"oxd-main-menu-item\")][./span[text()='Admin']]")
  private static WebElement adminBtnDashboard;
  @FindBy(xpath = "//button[text() = ' Add ']")
  private static WebElement addBtnAdmin;
  @FindBy(xpath = "//div[contains(@class,\"oxd-select-text-input\")][1]")
  private static WebElement userRoleDropdown;
  @FindBy(xpath = "//label[contains(text(),'Status')]//parent::div//following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
  private static WebElement statusUserDropdown;
  @FindBy(xpath = "//input[contains(@placeholder,\"Type for hints...\")]")
  private static WebElement inputEmployeeName;
  @FindBy(
      xpath =
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']//descendant::input[contains(@class, 'oxd-input oxd-input--active')]")
  private static WebElement inputUserName;
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
  WebDriver driver;
  public Admin() {
    super();
    PageFactory.initElements(driver, this);
  }

  public Admin(String pageType, WebDriver driver) {
    super();
    PageFactory.initElements(driver, this);
  }
  /**Create new user on admin page.**/

  public void createAdmin(
      String role, String employeeName, String status, String username, String password) {
    Select userRole = new Select(driver.findElement(By.xpath(String.valueOf(userRoleDropdown))));
    userRole.selectByValue(role);
    Select statusUser =
        new Select(driver.findElement(By.xpath(String.valueOf(statusUserDropdown))));
    statusUser.selectByValue(status);
    inputEmployeeName.sendKeys(employeeName);
    inputUserName.sendKeys(username);
    inputPassword.sendKeys(password);
    inputCfPassword.sendKeys(password);
  }
}
