package apistepdefs;

import apicore.ApiBasePage;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import java.io.IOException;
import pageobject.Admin;

public class AdminStepdefs {
  Response response;
  @And("Call API create new Admin on Admin page")
  public void callApiCreateNewAdmin() throws IOException {
    response = Admin.createNewAdmin("Blank.json", "orangeHrm", "lointoken", "GET", null,
        null);
  }
  }
