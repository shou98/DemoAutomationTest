package pageobject;

import apicore.ApiBasePage;
import io.restassured.response.Response;
import java.io.IOException;

/**
 * class Admin.
 */
public class Admin extends ApiBasePage {

  /**
   * Response createNewAdmin.
   */
  public static Response createNewAdmin(String jsonfilepath, String baseUrl, String endPoint,
      String method,
      Object dataPayloadString, String tokenHeader)
      throws IOException {
    return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayloadString, tokenHeader);
  }
}
