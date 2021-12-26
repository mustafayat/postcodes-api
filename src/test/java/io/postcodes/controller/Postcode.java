package io.postcodes.controller;

import io.postcodes.common.EndPoints;
import io.postcodes.pojo.NearestPostcode;
import io.postcodes.pojo.NearestResult;
import io.postcodes.pojo.Postcodes;
import io.postcodes.pojo.PostcodesResult;

import java.util.List;

public class Postcode extends TestBase {

  public static void main(String[] args) {
    String postcode = "CB3 0FA ";

    validatePostcode(postcode);
    countryAndRegion(postcode);
    nearestPostcodesInfo(postcode);

    // featureSpace(postcode);
  }

  public static void featureSpace(String postcode) {
    response = EndPoints.getValidateBody(postcode);
    countryAndRegion(postcode);
    nearestPostcodesInfo(postcode);
  }

  public static boolean validatePostcode(String postcode) {
    response = EndPoints.getValidateBody(postcode);
    boolean result = response.path("result");
    if (!result) {
      System.out.println("invalid postcode!");
      throw new IllegalArgumentException("Postcode is not valid!");
    }
    return result;
  }

  public static void countryAndRegion(String postcode) {
    response = EndPoints.getPostcodeBody(postcode);
    Postcodes postcodeInfo = response.body().as(Postcodes.class);
    PostcodesResult result = postcodeInfo.getResult();

    System.out.println(
        "Postcode = "
            + result.getPostcode()
            + ", "
            + "Country = "
            + result.getCountry()
            + ", "
            + "Region = "
            + result.getRegion());
  }

  public static void nearestPostcodesInfo(String postcode) {
    response = EndPoints.getNearestPostcodeBody(postcode);
    NearestPostcode nearestPostcodeInfo = response.body().as(NearestPostcode.class);
    List<NearestResult> results = nearestPostcodeInfo.getResult();

    System.out.println("Nearest postcodes and their countries and regions:");
    for (int i = 1; i < results.size(); i++) {
      System.out.println(
          i
              + "- Postcode="
              + results.get(i).getPostcode()
              + ", "
              + "Country="
              + results.get(i).getCountry()
              + ", "
              + "Region="
              + results.get(i).getRegion());
    }
  }
}
