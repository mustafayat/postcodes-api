package io.postcodes.common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class EndPoints {

  public static Response response = null;

  public static Response getValidateBody(String postcode) {
    return getRequest(Route.validate(postcode));
  }

  public static Response getPostcodeBody(String postcode) {
    return getRequest(Route.postcodes(postcode));
  }

  public static Response getNearestPostcodeBody(String postcode) {
    return getRequest(Route.nearest(postcode));
  }

  public static Response getRandomPostcodeBody() {
    return getRequest(Route.random());
  }

  public static Response getRequest(String uri) {
    try {
      response = given().accept(ContentType.JSON).when().get(uri);
    } catch (Exception e) {
      throw new RuntimeException();
    }
    return response;
  }

  public static void verifyPostcode(String expectedPostcode, String actualPostcode) {
    Assert.assertEquals(
        expectedPostcode, actualPostcode, "FAIL - Expected Postcode does not match with actual!!");
  }
}
