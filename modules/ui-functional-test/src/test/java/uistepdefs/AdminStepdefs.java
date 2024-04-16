package uistepdefs;


import io.cucumber.java.en.And;
import org.core.BasePage;
import org.openqa.selenium.support.PageFactory;
import pageobject.Admin;


/**
 * adminstep.*
 */
public class AdminStepdefs extends BasePage {

  Admin admin;

  @And("I created new user with {string} {string} {string} {string} {string} on Admin page")
  public void icreateSuccessfullyNewWithInformationOnAdminPage(
      String userRole, String employeeName, String status, String username, String password)
      throws InterruptedException {
    admin = PageFactory.initElements(driver, Admin.class);
    admin.createAdmin(userRole, employeeName, status, username, password);
  }
}
