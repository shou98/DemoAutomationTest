package apistepdefs;

import io.cucumber.java.en.And;
import io.restassured.response.Response;
import java.io.IOException;
import pageobject.Admin;

/**
 * class AdminStepdefs.
 */
public class AdminStepdefs {

  Response response;

  @And("Call API create new Admin on Admin page")
  public void callApiCreateNewAdmin() throws IOException {
    response = Admin.createNewAdmin("CreatAdmin.json", "orangeHrm", "createAdmin", "POST", null,
        null);
  }
}
