package io.postcodes.common;

import io.postcodes.utilities.ConfigurationReader;

public class Route {

  private static final String BASE_URL = ConfigurationReader.get("base_url");
  private static final String POSTCODES = ConfigurationReader.get("postcodes_endpoint");
  private static final String VALIDATE = ConfigurationReader.get("validate_endpoint");
  private static final String NEAREST = ConfigurationReader.get("nearest_endpoint");
  private static final String RANDOM = ConfigurationReader.get("random_endpoint");


  public static String postcodes(String postcode) {
    return BASE_URL + POSTCODES + "/" + postcode;
  }

  public static String validate(String postcode) {
    return BASE_URL + POSTCODES + "/" + postcode + VALIDATE;
  }

  public static String nearest(String postcode) {
    return BASE_URL + POSTCODES + "/" + postcode + NEAREST;
  }
  public static String random() {
    return BASE_URL + RANDOM  +  POSTCODES;
  }
}
