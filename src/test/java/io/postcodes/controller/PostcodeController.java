package io.postcodes.controller;

import io.postcodes.common.EndPoints;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostcodeController extends TestBase{

    /*******************************************************
     Verify postcode payload info
     ******************************************************/
    /**
     1- the request with a valid postcode
     * Given accept type is Json
     * When user sends get request to postcodes/{postcode}
     * Then status code is 200
     * And response payload values match the following:
     "postcode": "CB3 0FA", "country": "England", "region": "East of England",
     */

    @Test
    public void verifyPostcode() {
        response = EndPoints.getPostcodeBody(valid_postcode);
        response
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(
                        "result.postcode",
                        equalTo("CB3 0FA"),
                        "result.country",
                        equalTo("England"),
                        "result.region",
                        equalTo("East of England"));
    }

    /**
     2- the request with a invalid postcode
     * Given accept type is Json
     * When user sends get request to postcodes/{postcode}
     * Then status code is 404
     * And response payload contains with an error "Invalid postcode"
     */

    @Test
    public void verifyInvalidPostcode() {
        response = EndPoints.getPostcodeBody(invalid_postcode);
        response.then().statusCode(404).and().assertThat().body("error", equalTo("Invalid postcode"));
    }

    /**
     3- the request without postcode
     * Given accept type is Json user sends get request to postcodes/{postcode}/validate
     * When user should be able to see response with a status 404
     * Then user should be able to see response with a error "No postcode query submitted. Remember to include query parameter"
     */
    @Test
    public void verifyWithoutPostcode() {
        response = EndPoints.getPostcodeBody(without_postcode);
        response
                .then()
                .statusCode(400)
                .and()
                .assertThat()
                .body("error", equalTo("No postcode query submitted. Remember to include query parameter"));
    }

}
