package pageobject;


import io.restassured.response.Response;
import apicore.ApiBasePage;
import java.io.IOException;

public class Pim extends ApiBasePage {
  public Response createNewEmployee(String jsonfilepath, String baseUrl, String endPoint,
      String method,
      Object dataPayloadString, String tokenHeader)
      throws IOException {
    return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayloadString, tokenHeader);
//  return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayload);
  }
}

