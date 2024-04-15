package pageobject;

import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesFile;

/**
 * Login.
 */
public class Login extends BasePage {

  @FindBy(xpath = "//title[contains(text(),\"OrangeHRM\")]")
  private static WebElement title;
  public WebDriver driver;
  PropertiesFile propertiesFile;
  @FindBy(xpath = "//input[contains(@name, \"username\")]")
  private WebElement inputUsername;

  @FindBy(xpath = "//input[contains(@name, \"password\")]")
  private WebElement inputPassword;

  @FindBy(xpath = "//button[contains(.,'Login')]")
  private WebElement loginButton;

  @FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
  private WebElement logoutDropdown;

  @FindBy(xpath = "//a[text() = 'Logout']")
  private WebElement logoutbtn;
//  public Login() {
//    super();
//    PageFactory.initElements(driver, this);
//  }

  public Login(WebDriver driver) {
    this.driver =driver;
    PageFactory.initElements(driver, this);
  }

  public void verifyTitle() {
    title.isDisplayed();
  }

  /**
   * input username and password.
   */
  public void inputUserAndPass(String username, String password) {
    if (username.contains("username") && password.contains("password")) {
      String user = PropertiesFile.getDataOrangeHrm("username");
      String pass = PropertiesFile.getDataOrangeHrm("password");
      inputUsername.sendKeys(user);
      inputPassword.sendKeys(pass);
      loginButton.click();
    } else {
      inputUsername.sendKeys(username);
      inputPassword.sendKeys(password);
      loginButton.click();
    }
  }

  /**
   * logout.*
   */
  public void logout() {
    logoutDropdown.click();
    logoutbtn.click();
    title.isDisplayed();
    inputUsername.isDisplayed();
    inputPassword.isDisplayed();
  }
}
