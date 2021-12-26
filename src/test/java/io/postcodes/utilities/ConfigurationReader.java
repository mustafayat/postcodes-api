package io.postcodes.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
  private static Properties properties;

  static {
    try {
      String path = "configuration.properties";
      FileInputStream input = new FileInputStream(path);
      properties = new Properties();
      properties.load(input);
      input.close();
    } catch (IOException e) {
      System.out.println("Failed to load properties file!");
      e.printStackTrace();
    }
  }

  public static String get(String keyName) {
    return properties.getProperty(keyName);
  }
}
