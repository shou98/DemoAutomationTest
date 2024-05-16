package pageobject;

import apicore.ApiBasePage;
import io.restassured.response.Response;
import java.io.IOException;

public class Login extends ApiBasePage {
public static Response getToken(String jsonfilepath, String baseUrl, String endPoint, String method,
    Object dataPayloadString, String tokenheader)
    throws IOException {
  return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayload, tokenheader);
}
public static Response sendRequestData(String jsonfilepath, String baseUrl, String endPoint, String method,
    Object dataPayloadString, String tokenHeader)
    throws IOException {
  return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayloadString, tokenHeader);
//  return sendRequest(jsonfilepath, baseUrl, endPoint, method, dataPayload);
}

}
