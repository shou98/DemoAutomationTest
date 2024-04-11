package uistepdefs;

import core.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobject.Login;

/** LoginStepdefs. */
public class LoginStepdefs extends BasePage {
  Login login;

  /** Step. */
  @Given("^Open \"([^\"]*)\"")
  public void openPage(String page) throws InterruptedException {
    open(page);
    login = PageFactory.initElements(driver, Login.class);
    login.getTitle();
  }

  /** Step. */
  @When("I login with {string} and {string}")
  public void iloginwithand(String user, String pass) {
    if (user.contains("username") && pass.contains("password")) {
      login.inputUserAndPass(user, pass);
    } else {
      login.inputUserAndPass(user, pass);
    }
  }

  @Then("^I login successfull on Dashboard page")
  public void iloginsuccessfulondashboardpage() {
    login.getTitleDashboard();
  }
}