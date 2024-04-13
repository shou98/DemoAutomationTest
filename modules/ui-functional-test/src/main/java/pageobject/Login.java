package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uicore.UiBasePage;
import utils.PropertiesFile;

/** Login. */
public class Login extends UiBasePage {
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

  @FindBy(xpath = "//h6[text()='Dashboard']")
  private WebElement dashBoard;

  @FindBy(xpath = "//input[@placeholder='Search']")
  private WebElement search;

  public Login() {
    super();
    PageFactory.initElements(driver, this);
  }

  public Login(String pageType, WebDriver driver) {
    super();
    PageFactory.initElements(driver, this);
  }

  public void getTitle() throws InterruptedException {
    title.isDisplayed();
    Thread.sleep(2000);
  }

  /** input username and password. */
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

  /** get Title Dashboard. */
  public void getTitleDashboard() {
    explicitWaitElemenetVisible(dashBoard);
    explicitWaitElemenetVisible(search);
  }
}
