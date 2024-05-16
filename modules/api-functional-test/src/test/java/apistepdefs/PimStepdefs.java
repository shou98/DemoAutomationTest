package apistepdefs;

import static apicore.ApiBasePage.fullResponseJsonData;
import static apicore.ApiBasePage.token;
import static apicore.ApiBasePage.verifyStatusCode;

import io.cucumber.java.en.And;
import io.restassured.response.Response;
import java.io.IOException;
import pageobject.Pim;

/**
 * class PimStepdefs.
 */
public class PimStepdefs {

  Pim pim = new Pim();
  private Response response;

  /**
   * And.
   */
  @And("Call API create new employee on PIM page")
  public void createNewEmployeeOnPimPage() throws IOException {
    response = pim.createNewEmployee("CreateEmployee.json", "orangeHrm", "createEmployee", "POST",
        null, token);
    verifyStatusCode(200);
    fullResponseJsonData();
  }

}
