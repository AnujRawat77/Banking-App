package com.project.BankingApp.basictests.ApiTests.PetstoreAPI;

import com.project.BankingApp.basictests.ApiTests.PetstoreAPI.POJO.User;
import com.project.BankingApp.basictests.ApiTests.PetstoreAPI.filters.CustomLoggingFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserTests {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    }

    @Test(testName = "TC_01_Create_User")
    public void testCreateUser() {

        User newUser = new User(
                7,
                "AnujRawat",
                "Anuj",
                "Rawat",
                "anuj@gmail.com",
                "Pass1234",
                "1234567890",
                0
        );

        given()
                    .contentType("application/json")
                    .body(newUser)
                .when()
                    .post("/user")
                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test(testName = "TC_02_Get_User_By_Username")
    public void testGetUserByUsername(){
        String username = "AnujRawat";

        Response response =
                given()
                        .contentType("application/json")
                        .pathParam("username", username)
                        .when()
                        .get("/user/{username}")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath("schema/petstore/user-schema.json"))
                        .extract().response();
    }


    @Test(testName = "TC_03_Login_User", description = "This a a Login Test By Accepting Query Params Username Password")
    public void testLoginUser() throws SkipException {

//        if( true )
//            throw new SkipException("Skipping this test for demonstration purposes.");

        String username = "AnujRawat";
        String password = "Pass1234";

        given()
                    .contentType("application/json")
                    .queryParam("username", username)
                    .queryParam("password", password)
                    .filter(new CustomLoggingFilter())
                .when()
                    .get("/user/login")
                .then()
                    .statusCode(200)
                    .body("code", equalTo(200))
                    .body("message", containsString("logged in user session:"))
                    .time(lessThan(2000L))
                    .log().all();

    }

}
