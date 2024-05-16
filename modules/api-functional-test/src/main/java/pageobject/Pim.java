package pageobject;


import apicore.ApiBasePage;
import io.restassured.response.Response;
import java.io.IOException;

/**
 * class Pim.
 */
public class Pim extends ApiBasePage {

  public Response createNewEmployee(String jsonfilepath, String baseUrl, String endPoint,
      String method,
      Object dataPayloadString, String tokenHeader)
      throws IOException {
    return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayloadString, tokenHeader);
  }
}

