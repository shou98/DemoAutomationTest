package uistepdefs;

import io.cucumber.java.en.And;
import org.core.BasePage;
import pageobject.Admin;

/** adminstep.* */
public class AdminStepdefs extends BasePage {
  Admin admin;

  @And(
      "I create successfully new user with information {string} {string} {string} {string} {string} on Admin page")
  public void icreateSuccessfullyNewWithInformationOnAdminPage(
      String userRole, String employeeName, String status, String username, String password) {
    admin.createAdmin(userRole, employeeName, status, username, password);
  }
}
