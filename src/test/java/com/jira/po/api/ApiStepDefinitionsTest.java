package com.jira.po.api;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepDefinitionsTest {

    static {
//        RestAssured.baseURI = "https://my-json-server.typicode.com/rizrahmanuk/jsonservertypicode/";
        RestAssured.baseURI = "https://my-json-server.typicode.com/rizrahmanuk/jsonservertypicode/";
    }


//    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//        RestAssured.baseURI = "https://my-json-server.typicode.com/rizrahmanuk/jsonservertypicode/";
    }

    private void postRequest() {
        String requestBody = "{\n" +
                "  \"title\": \"Mr\",\n" +
                "  \"email\": \"riz_rahmanuk@hadoopa.co.uk\"\n" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
        assertEquals("Mr", response.jsonPath().getString("title"));
//        assertEquals("baro", response.jsonPath().getString("body"));
        assertEquals("riz_rahmanuk@hadoopa.co.uk", response.jsonPath().getString("email"));
//        assertEquals("3", response.jsonPath().getString("id"));
    }

    @Given("create JSon data")
    public void postJSonData() {
        postRequest();
    }

    @When("get JSon by id {int}")
    public void getResponseBody(int id) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/"+id)
                .then()
                .extract().response();

        response.prettyPrint();
    }

    @When("update JSon by id {int}")
    public void updateJSonById(int id) {
        String requestBody = "{\n" +
                "  \"title\": \"Miss\",\n" +
                "  \"firstname\": \"Rizwana\",\n" +
                "  \"email\": \"miss_rahmanuk@hadoopa.co.uk\",\n" +
                " \"id\": \""+id+"\"" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .and()
                .body(requestBody)
                .when()
                .put("/posts/"+id)
                .then()
                .extract().response();
        assertEquals(200, response.statusCode());
        response.prettyPrint();
    }

    @When("delete JSon by id {int}")
    public void deleteJSonById(int id) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/posts/"+id)
                .then()
                .extract().response();
        assertEquals(200, response.statusCode());
        response.prettyPrint();
    }
}