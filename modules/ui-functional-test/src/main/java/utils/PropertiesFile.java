package utils;

import java.io.FileInputStream;
import java.util.Properties;

/** PropertiesFile. */
public class PropertiesFile {

  static String projectPath = System.getProperty("user.dir") + "/";
  private static Properties properties;
  private static FileInputStream fileIn;
  private static String propertiesFilePathRoot = "src/main/resources/selenium.properties";
  private static String orgHrmData = "src/main/resources/propertiespage/orangeHrmData.properties";

  /** getDataFromPropertiesFile. */
  public static String getDataOrangeHrm(String keyProp) {
    properties = new Properties();
    String value = null;
    try {
      fileIn = new FileInputStream(projectPath + orgHrmData);
      properties.load(fileIn);
      value = properties.getProperty(keyProp);
    } catch (Exception exp) {
      System.out.println(exp.getMessage());
      System.out.println(exp.getCause());
      exp.printStackTrace();
    }
    return value;
  }

  /** getPropertiesFileSeleniumConfig. */
  public static String getPropertiesFileSeleniumConfig(String keyPropSeleniumConfig) {
    properties = new Properties();
    String value = null;
    try {
      fileIn = new FileInputStream(projectPath + propertiesFilePathRoot);
      properties.load(fileIn);
      value = properties.getProperty(keyPropSeleniumConfig);
    } catch (Exception exp) {
      System.out.println(exp.getMessage());
      System.out.println(exp.getCause());
      exp.printStackTrace();
    }
    return value;
  }
}
