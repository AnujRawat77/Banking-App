package com.project.BankingApp.basictests.ApiTests.auth;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BearerTokenTest {

    private String token = System.getenv("GITHUB_API_TOKEN");

    @Test
    public void testBearerToken(){
        given()
                .header("Authorization", "Bearer " + token)

                .when()
                    .get("https://api.github.com/user")
                .then()
                    .statusCode(200)
                    .log().all();

    }

    @DataProvider(name = "InvalidCredentialData")
    public Object[][] invalidCredentialData(){
        return new Object[][]{
                {"XYZ"},
                {"Abbajhkasanibyaduadid"}
        };
    }

    @Test(dataProvider = "InvalidCredentialData")
    public void testBearerInvalidToken(String accessToken){
        given()
                .header("Authorization", "Bearer "+accessToken)

                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(401)
                .log().all();

    }

    @Test
    public void testBearerEmptyToken(){
        given()
                .header("Authorization", "Bearer ")

                .when()
                .get("https://api.github.com/user")
                .then()
                .statusCode(401)
                .log().all();

    }
}
