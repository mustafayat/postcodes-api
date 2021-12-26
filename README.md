# postcodes-api 
####Codes and Tests Prepared by: 
####Mustafa YAT
_QA Test Automation Engineer_
## **Technology Used:**
- RestAssured Java API
- Build Tool: Maven
- Test Framework: TestNG 
## Task:
Write a Java application that allows a user to query and show details for a given UK postcode.
##Api Rest Service
`http://postcodes.io`

##API methods for Test:
- `GET /postcodes/{POSTCODE}`
- `GET /postcodes/{POSTCODE}/validate`
- `GET /postcodes/{POSTCODE}/nearest`
- `GET /random/postcodes`


## Validate a postcode
`validatePostcode("CB3 0FA")`

## Print Country and Region
`countryAndRegion("CB3 0FA");`

## Print nearest postcodes 
`nearestPostcodesInfo("CB3 0FA")`

## postcodes-api
Endpoint tests to validate the apis from postcodes.io. TestNG have been used to write the api tests. Maven has been chosen as the build tool. In order to make endpoint calls RestAssured library has been used


## Test RUN:
Run the command below to execute the tests

`mvn verify`

or run the `testng_runner.xml` file through an IDE

