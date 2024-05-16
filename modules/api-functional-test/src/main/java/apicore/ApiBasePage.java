package apicore;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;

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
  private static String cookie;
  private static RequestSpecification httpRequest;
  private static Response response = null;
  private static String oneData = null;
  String setToken;
  String getToken;
//  /** sendRequest. */
//  public static Response sendRequest(
//      String jsonfilepath, String baseUrl, String endPoint, String method, Object dataPayload)
//      throws IOException {
//    Object payload = getDataJson(jsonfilepath);
//    String baseUrlRq = PropertiesFile.getDataOrangeHrm(baseUrl);
//    String endPointRq = PropertiesFile.getEndpointOrangeHrm(endPoint);
//    dataPayload = payload;
//    RequestSpecification httpRequest = given().baseUri(baseUrlRq).contentType(ContentType.JSON);
//    switch (method.toUpperCase()) {
//      case "GET":
//        response = httpRequest.when().get(endPointRq);
//        break;
//      case "POST":
//        response = httpRequest.body(dataPayload).when().post(endPointRq);
//        break;
//      case "DELETE":
//        httpRequest.body(dataPayload).when().delete(endPointRq);
//        break;
//      case "PUT":
//        httpRequest.body(dataPayload).when().put(endPointRq);
//        break;
//      case "PATCH":
//        httpRequest.body(dataPayload).when().patch(endPointRq);
//        break;
//      default:
//        Assert.fail("Please input Method");
//        break;
//    }
//    fullResponseHtmldata();
////    fullResponseJsonData();
//    return response;
//  }

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

  public static String prepareAPIRequestDynamically(String request, String... args) {
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

//    if (dataPayload == null) {
//      newDataPayload = payload;
//      if (!(jsonfilepath == "Blank.json") && (!(dataPayload == "Blank.json")) && (!(
//          dataPayload == null))) {
//        newDataPayload = prepareAPIRequestDynamically(payload,
//            (String) dataPayload);
//      }
//    }

    String baseUrlRq = PropertiesFile.getDataOrangeHrm(baseUrl);
    String endPointRq = PropertiesFile.getEndpointOrangeHrm(endPoint);
    RequestSpecification httpRequest;
    httpRequest =
        given()
            .header("Bearer", ""+token)
            .header("Connection", "" + "keep-alive")
                        .header("cookie", "orangehrm=" + cookie)
            .header("accept", "application/json")
            .header("accept-language", "en,vi-VN;q=0.9,vi;q=0.8")
            .header("content-type", "application/json")
            .header("Cache-Control",
                "no-store, no-cache, must-revalidate, post-check=0, pre-check=0")
            .header("origin", "https://opensource-demo.orangehrmlive.com")
//            .header("referer",
//                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee")
            .header("sec-ch-ua",
                "\"Google Chrome\";v=\"123\", \"Not:A-Brand\";v=\"8\", \"Chromium\";v=\"123\"")
            .header("sec-ch-ua-platform", "Windows")
            .header("sec-fetch-dest", "empty")
            .header("sec-fetch-mode", "cors")
            .header("sec-fetch-site", "same-origin")
            .header("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
            .baseUri(baseUrlRq);
    switch (method.toUpperCase()) {
      case "GET":
        response = httpRequest.when().get(endPointRq);
        break;
      case "POST":
        if(jsonfilepath.contains("Login.json")){
          newDataPayload = prepareAPIRequestDynamically(payload, (String) dataPayload);
        }
        else {
          newDataPayload =payload;
        }
        response = httpRequest.body(newDataPayload).when().post(endPointRq);
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
//    getSetCookie();
    //show request header
//    System.out.println(httpRequest.body(newDataPayload).toString());
    System.out.println("=====================START Request Header====================="+baseUrlRq+endPointRq);
    FilterableRequestSpecification spec = (FilterableRequestSpecification)httpRequest;
    System.out.println(spec.getHeaders());
    System.out.println("=====================END Request Header=====================");
    //end request header
    return response;
  }

  /**
   * verifyStatusCode.
   */
  public static void verifyStatusCode(int sttCode) {
    String statusLine = response.getStatusLine();
    if (statusLine == "302") {
      assertEquals("Correct status code returned", statusLine,
          "HTTP/1.1 " + sttCode + " " + "Found");
    }
    if (statusLine == "200") {
      assertEquals("Correct status code returned", statusLine, "HTTP/1.1 " + sttCode + " " + "OK");
    }
    if (statusLine.contains("401")) {
      assertEquals("HTTP/1.1 " + sttCode, "" + statusLine);
      System.out.println();
    }
//    if (statusLine.equals(sttFound)) {
//      assertEquals("Correct status code returned", statusLine,
//          "HTTP/1.1 " + sttCode + " " + sttFound);
//    }

//    assertEquals("Correct status code returned", statusLine, "HTTP/1.1 " + sttCode + " "+"OK");
    System.out.println("Statut code: " + statusLine);
  }

  public static String getSetCookie() {
    String setCookieRs = null;
//    String getSetCookie = response.getHeader("Set-Cookie");
    String getSetCookie = response.getHeaders().toString();
    System.out.println("==============response=====================");
    System.out.println(getSetCookie);
    System.out.println("==============response=====================");
    String bodyTesxt = String.valueOf(getSetCookie);
    Pattern patternDate = Pattern.compile("(?<=orangehrm=)[A-Za-z0-9-_.]+(?=;)");
    Matcher matcher = patternDate.matcher(bodyTesxt);
    while (matcher.find()) {
      setCookieRs = matcher.group();
    }
//    cookie = setCookieRs;
    /****/
//    String getBodyDetail = response.getBody().asString();
//    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//    System.out.println(getBodyDetail);
    /****/
//    System.out.println("Cookie: " + cookie);
//    return cookie = "orangehrm=" + setCookieRs;
    return cookie = setCookieRs;
  }

  public static String getTokenOrgHRM() {
    String data1 = null;
    String html = response.getBody().asString();
    String bodyTesxt = String.valueOf(html);
//    System.out.println("áđâsdá"+bodyTesxt);
    Pattern patternDate = Pattern.compile("(?<=token=\"&quot;)[A-Za-z0-9-_.]+(?=&quot;)");
    Matcher matcher = patternDate.matcher(bodyTesxt);
    while (matcher.find()) {
      data1 = matcher.group();
    }
//    token = data1;
    System.out.println("Token: " + token);
    return token = data1;
  }
//  public void setToken(){
//    this.setToken=token;
//  }
//  public void getToken(){
//    this.token=setToken;
//  }
//  public ApiBasePage(String token){
//    this.token = token;
//  }

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
   *
   * @return
   */
  public static Response sendRequestWithBeaer(String jsonfilepath,
      String baseUrl, String endPoint, String method)
      throws IOException {
    Object dataheader = getTokenOrgHRM();
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
