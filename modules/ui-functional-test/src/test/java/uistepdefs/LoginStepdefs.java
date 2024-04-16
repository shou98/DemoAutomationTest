package uistepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.Dashboard;
import pageobject.Login;

/**
 * LoginStepdefs.
 */
public class LoginStepdefs extends BasePage {

  Login login;
  Dashboard dashboard;

  /**
   * Step.
   */
  @Given("^Open \"([^\"]*)\"")
  public void openPage(String page) throws InterruptedException, IOException {
    open(page);
    login = PageFactory.initElements(driver, Login.class);
    login.verifyTitle();
  }

  /**
   * Step.
   */
  @When("I login with {string} and {string} valid")
  public void iloginwithand(String user, String pass) {
    if (user.contains("username") && pass.contains("password")) {
      login.inputUserAndPass(user, pass);
    } else {
      login.inputUserAndPass(user, pass);
    }
  }

  @Then("^I login successfull on Dashboard page")
  public void iloginsuccessfulondashboardpage() {
    dashboard = PageFactory.initElements(driver, Dashboard.class);
    dashboard.dashboardIsDisplayed();
  }

  @And("I logout Admin successfully")
  public void ilogoutAdminSuccessfully() {
    login.logout();
  }

  @And("I login with account of {string} {string} successfully")
  public void iloginWithAccountOfSuccessfully(String user, String pass) {
  }

}
