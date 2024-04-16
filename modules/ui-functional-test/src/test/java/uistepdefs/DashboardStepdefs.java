package uistepdefs;

import io.cucumber.java.en.Then;
import org.core.BasePage;
import org.openqa.selenium.support.PageFactory;
import pageobject.Dashboard;

/**
 * DashboardStepdefs.*
 */
public class DashboardStepdefs extends BasePage {

  Dashboard dashboard;

  /**
   * verify full name.
   **/
  @Then("Dashboard page is Displayed with {string} {string}")
  public void dashboardPageIsDisplayedWith(String firsName, String lastName) {
    dashboard = PageFactory.initElements(driver, Dashboard.class);
    dashboard.verifyName(firsName, lastName);
  }
}
