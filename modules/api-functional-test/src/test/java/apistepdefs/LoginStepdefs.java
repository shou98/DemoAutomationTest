package apistepdefs;

import static apicore.ApiBasePage.getSetCookie;
import static apicore.ApiBasePage.getTokenOrgHrm;
import static apicore.ApiBasePage.token;
import static apicore.ApiBasePage.verifyStatusCode;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import java.io.IOException;
import pageobject.Login;

/**
 * class LoginStepdefs.
 */
public class LoginStepdefs {

  Login login;
  Response response;

  /**
   * Given.
   */
  @Given("Login and get token successfully")
  public void loginAndGetToken() throws IOException {
    response = login.getToken("Blank.json", "orangeHrm", "lointoken", "GET", null,
        null);
    getTokenOrgHrm();
    getSetCookie();
    verifyStatusCode(200);
    response = login.sendRequestData("Login.json", "orangeHrm", "loginValidate", "POST", token,
        null);
    getSetCookie();
    verifyStatusCode(302);
    response = login.getToken("Blank.json", "orangeHrm", "loginIndex", "GET", null,
        null);
    verifyStatusCode(200);
  }
}
