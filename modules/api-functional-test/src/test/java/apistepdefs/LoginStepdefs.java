package apistepdefs;

import static apicore.ApiBasePage.getTokenOrgHRM;
import static apicore.ApiBasePage.getSetCookie;
import static apicore.ApiBasePage.token;
import static apicore.ApiBasePage.verifyStatusCode;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import java.io.IOException;
import pageobject.Login;

public class LoginStepdefs {
  Login login;
  Response response;

  @Given("Login and get token successfully")
  public void  loginAndGetToken() throws IOException {
    response = login.getToken("Blank.json", "orangeHrm", "lointoken", "GET", null,
        null);
    getTokenOrgHRM();
    getSetCookie();
    verifyStatusCode(200);
    response = login.sendRequestData("Login.json", "orangeHrm", "loginValidate", "POST", token,
        null);
    getSetCookie();
    verifyStatusCode(302);
    response = login.getToken("Blank.json", "orangeHrm", "loginIndex", "GET", null,
        null);
//    getSetCookie();
    verifyStatusCode(200);
//    response = login.sendRequestData("CreateEmployee.json", "orangeHrm", "createEmployee", "POST", null,null);
//    verifyStatusCode(200);
  }
}
