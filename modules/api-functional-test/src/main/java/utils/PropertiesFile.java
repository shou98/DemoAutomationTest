package utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * PropertiesFile.
 */
public class PropertiesFile {

  static String projectPath = System.getProperty("user.dir") + "/";
  private static Properties properties;
  private static FileInputStream fileIn;
  private static String orgHrmApiEndpoint = "src/main/resources/endpoint/orangehrm"
          + "/orgHrmApiEndpoint.properties";
  private static String orangeHrmData = "src/main/resources/orangeHrmData.properties";

  /**
   * getDataFromPropertiesFile.
   */
  public static String getDataOrangeHrm(String keyProp) {
    properties = new Properties();
    String valuedata = null;
    try {
      fileIn = new FileInputStream(projectPath + orangeHrmData);
      properties.load(fileIn);
      valuedata = properties.getProperty(keyProp);
    } catch (Exception exp) {
      System.out.println(exp.getMessage());
      System.out.println(exp.getCause());
      exp.printStackTrace();
    }
    return valuedata;
  }

  /**
   * getEndpointOrangeHrm.
   */
  public static String getEndpointOrangeHrm(String keyProp) {
    properties = new Properties();
    String valueEndpoint = null;
    try {
      fileIn = new FileInputStream(projectPath + orgHrmApiEndpoint);
      properties.load(fileIn);
      valueEndpoint = properties.getProperty(keyProp);
    } catch (Exception exp) {
      System.out.println(exp.getMessage());
      System.out.println(exp.getCause());
      exp.printStackTrace();
    }
    return valueEndpoint;
  }
}
