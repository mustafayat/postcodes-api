package io.postcodes.common;

import org.testng.Assert;

public class GenericFunctions {

    public static void verifyStatusCode( int expectedStatusCode , int actualStatusCode){
        Assert.assertEquals(actualStatusCode,expectedStatusCode,"FAIL - Expected Status code does not match with actual!!");
    }

    public static void verifyResponseBody( String expectedBody , String actualBody){
        Assert.assertEquals(actualBody,expectedBody,"FAIL - Expected Body does not match with actual!!");
    }

}
