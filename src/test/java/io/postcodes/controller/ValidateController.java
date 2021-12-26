package io.postcodes.controller;

import io.postcodes.common.EndPoints;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateController extends TestBase{


    /*******************************************************
     *    Validate postcode parameter
     ******************************************************/
    /**
     1- the request with a valid postcode
     * accept type is Json
     * user sends get request to postcodes/{postcode}/validate
     * user should be able to see response with a status 200
     * user should be able to see response with a result "true"
     */

    @Test
    public void validatePostcode() {
        response = EndPoints.getValidateBody(valid_postcode);
        Assert.assertTrue((Boolean) response.path("result"), "Postcode is not valid!");
    }

    /**
     2- the request with a invalid postcode
     * accept type is Json
     * user sends get request to postcodes/{postcode}/validate
     * user should be able to see response with a status 404
     * user should be able to see response with a error "Invalid postcode"
     */
    @Test
    public void validateInvalidPostcode() {
        response = EndPoints.getValidateBody(invalid_postcode);
        Assert.assertFalse((Boolean) response.path("result"));
    }
}
