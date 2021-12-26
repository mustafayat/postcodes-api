package io.postcodes.controller;

import io.postcodes.common.EndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomController extends TestBase {

  @Test
  public void validateRandomPostcode() {
    response = EndPoints.getRandomPostcodeBody();
    response.then().statusCode(200);
    String randomPostcode = response.path("result.postcode");
    Assert.assertTrue(Postcode.validatePostcode(randomPostcode));
  }
}
