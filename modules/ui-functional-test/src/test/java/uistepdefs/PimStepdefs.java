package uistepdefs;

import io.cucumber.java.en.And;
import org.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.Dashboard;
import pageobject.Pim;

/**
 * PimStepdefs.*
 */
public class PimStepdefs extends BasePage {

  Pim pim;

  @And("I Create successfully new Employee with information {string} and {string} in Add Employee on PIM page")
  public void iCreateNewEmployeeWithInformationFirstNameAndLastNameInAddEmployeeOnPIMPage(
      String inputFirstName, String inputLastName) {
    pim = PageFactory.initElements(driver, Pim.class);
    pim.createUserOnPimPage(inputFirstName, inputLastName);
  }
}
