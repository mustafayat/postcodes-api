package io.postcodes.controller;

import io.postcodes.common.EndPoints;
import io.postcodes.pojo.NearestPostcode;
import io.postcodes.pojo.NearestResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NearestController extends TestBase {

  /**
   * *****************************************************
   * Verify nearest postcodes payload info
   * ****************************************************
   */
  /**
   * 1- the request with a valid postcode
   * Given accept type is Json
   * When user sends get request to postcodes/{postcode}/nearest
   * Then status code is 200
   * And response payload values match the
   * following nearest postcodes: "postcode": "CB3 0GT", "postcode": "CB3 0FT",
   */
  @Test
  public void verifyPostcode() {
    response = EndPoints.getNearestPostcodeBody(valid_postcode);
    NearestPostcode nearestPostcodeInfo = response.body().as(NearestPostcode.class);
    List<NearestResult> results = nearestPostcodeInfo.getResult();
    for (int i = 1; i < results.size(); i++) {
      String actualPostcode = results.get(i).getPostcode();
      String expectedPostcode = nearestPostcodes[i - 1];
      Assert.assertEquals(actualPostcode, expectedPostcode);
    }
  }
}
