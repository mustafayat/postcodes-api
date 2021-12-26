package io.postcodes.controller;

import io.restassured.response.Response;

public class TestBase {

  public static Response response = null;
  public static String valid_postcode = "CB3 0FA";
  public static String invalid_postcode = "invalid!";
  public static String without_postcode = "";
  String[] nearestPostcodes = {"CB3 0GT", "CB3 0FT"};
}
