package apicore;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import utils.PropertiesFile;

/**
 * ApiBasePage.
 */
public class ApiBasePage {

  public static Object dataPayload;
  public static String token;
  static String newDataPayload;
  static String setCookieRs = null;
  private static String cookie;
  private static RequestSpecification httpRequest;
  private static Response response = null;
  private static String oneData = null;

  /**
   * getDataJson.
   */
  public static String getDataJson(String filepath) throws IOException {
    String filePath = ("./src/main/resources/json/orangehrm/" + filepath);
    String node = "";
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(Paths.get(filePath).toFile());
    node = jsonNode.toString();
    return node;
  }

  /**
   * prepare API Request payload Dynamically.
   */
  public static String prepareApiRequestDynamically(String request, String... args) {
    for (int i = 0; i < args.length; i++) {
      request = request.replace("#" + i + "#", args[i]);
    }
    return request;
  }

  /**
   * sendRequest.
   */
  public static Response sendRequest(
      String jsonfilepath, String baseUrl, String endPoint, String method, Object dataPayload,
      String tokenHeader)
      throws IOException {
    String payload = getDataJson(jsonfilepath);
    String baseUrlRq = PropertiesFile.getDataOrangeHrm(baseUrl);
    String endPointRq = PropertiesFile.getEndpointOrangeHrm(endPoint);
    RequestSpecification httpRequest;
    httpRequest =
        given()
            .header("Bearer", "" + token)
            .header("Connection", "" + "keep-alive")
            .header("cookie", "orangehrm=" + cookie)
            .header("accept", "application/json")
            .header("accept-language", "en,vi-VN;q=0.9,vi;q=0.8")
            .header("content-type", "application/json")
            .baseUri(baseUrlRq);
    switch (method.toUpperCase()) {
      case "GET":
        response = httpRequest.when().get(endPointRq).then().extract().response();
        break;
      case "POST":
        if (jsonfilepath.contains("Login.json")) {
          newDataPayload = prepareApiRequestDynamically(payload, (String) dataPayload);
        } else {
          newDataPayload = payload;
        }
        response = httpRequest.body(newDataPayload).when().post(endPointRq).then().extract().response();
        break;
      case "DELETE":
        httpRequest.body(newDataPayload).when().delete(endPointRq);
        break;
      case "PUT":
        httpRequest.body(dataPayload).when().put(endPointRq);
        break;
      case "PATCH":
        httpRequest.body(dataPayload).when().patch(endPointRq);
        break;
      default:
        Assert.fail("Please input Method");
        break;
    }
    return response;
  }

  /**
   * verifyStatusCode.
   */
  public static void verifyStatusCode(int sttCode) {
    String statusLine = String.valueOf(response.getStatusCode());
    if (statusLine == "302") {
      assertEquals("Correct status code returned", statusLine,
          "HTTP/1.1 " + sttCode + " " + "Found");
    }
    if (statusLine == "200") {
      assertEquals("Correct status code returned", statusLine, "HTTP/1.1 " + sttCode + " " + "OK");
    }
    if (statusLine.contains("401")) {
      assertEquals("HTTP/1.1 " + sttCode, "" + statusLine);
      System.out.println("Failed");
    }
    if ("422".equals(statusLine)) {
      System.out.println("Request failed with status code 422: Unprocessable Entity");
      assertEquals("Request failed",statusLine);
    }

  }

  /**
   * getSetCookie.
   */
  public static String getSetCookie() {
    String getSetCookie = response.getHeaders().toString();
    String bodyTesxt = String.valueOf(getSetCookie);
    Pattern patternDate = Pattern.compile("(?<=orangehrm=)[A-Za-z0-9-_.]+(?=;)");
    Matcher matcher = patternDate.matcher(bodyTesxt);
    while (matcher.find()) {
      setCookieRs = matcher.group();
    }
    return cookie = setCookieRs;
  }

  /**
   * getTokenOrgHRM.
   */
  public static String getTokenOrgHrm() {
    String data1 = null;
    String html = response.getBody().asString();
    String bodyTesxt = String.valueOf(html);
    Pattern patternDate = Pattern.compile("(?<=token=\"&quot;)[A-Za-z0-9-_.]+(?=&quot;)");
    Matcher matcher = patternDate.matcher(bodyTesxt);
    while (matcher.find()) {
      data1 = matcher.group();
    }
    System.out.println("Token: " + token);
    return token = data1;

  }

  /**
   * fullResponseData.
   */
  public static JsonNode fullResponseJsonData() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = response.asString();
    JsonNode detail = objectMapper.readTree(jsonString);
    System.out.println(detail);
    return detail;
  }

  /**
   * oneResponseData.
   */
  public static Object oneResponseData(String jsonString, String data)
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode getData = null;
    String oneData = null;
    getData = objectMapper.readTree(jsonString).get(data);
    oneData = getData.asText().replace(" ", "");
    System.out.println(oneData);
    return oneData;
  }

  /**
   * sendRequestWithBeaer.
   */
  public static Response sendRequestWithBeaer(String jsonfilepath,
      String baseUrl, String endPoint, String method)
      throws IOException {
    Object dataheader = getTokenOrgHrm();
    Object payload = getDataJson(jsonfilepath);
    String baseUrlRq = PropertiesFile.getDataOrangeHrm(baseUrl);
    String endPointRq = PropertiesFile.getEndpointOrangeHrm(endPoint);
    dataPayload = payload;
    RequestSpecification httpRequest =
        given()
            .header("Bearer", "" + dataheader)
            .contentType(ContentType.JSON)
            .baseUri(baseUrlRq);
    System.out.println(httpRequest.toString());
    switch (method.toUpperCase()) {
      case "GET":
        response = httpRequest.when().get(endPointRq);
        break;
      case "POST":
        response = httpRequest.body(dataPayload).when().post(endPointRq);
        break;
      case "DELETE":
        httpRequest.body(dataPayload).when().delete(endPointRq);
        break;
      case "PUT":
        httpRequest.body(dataPayload).when().put(endPointRq);
        break;
      case "PATCH":
        httpRequest.body(dataPayload).when().patch(endPointRq);
        break;
      default:
        Assert.fail("Please input Method");
        break;
    }
    fullResponseJsonData();
    return response;
  }

  /**
   * readResponseWithArrMsg.
   */
  public ArrayNode readResponseWithArrMsg(Response response) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = response.asString();
    ArrayNode detail =
        (ArrayNode) objectMapper.readTree(jsonString).get("errors").get(0).get("detail");
    return detail;
  }
}
