package uistepdefs;

import io.cucumber.java.en.And;
import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.Pim;

/**
 * PimStepdefs.*
 */
public class PimStepdefs extends BasePage {

  Pim pim;

  @And("I Create successfully new Employee with information {string} and {string} in Add Employee on PIM page")
  public void iCreateNewEmployeeWithInformationFirstNameAndLastNameInAddEmployeeOnPIMPage(
      String inputFirstName, String inputLastName) {
    pim.createUserOnPimPage(inputFirstName, inputLastName);
  }
}
