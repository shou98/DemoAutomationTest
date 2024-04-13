package uistepdefs;

import io.cucumber.java.en.Then;
import org.core.BasePage;

/** DashboardStepdefs.* */
public class DashboardStepdefs extends BasePage {

  @Then("Dashboard page is Displayed with {string} {string}")
  public void dashboardPageIsDisplayedWith(String firsName, String lastName) {}
}
