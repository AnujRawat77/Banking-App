package com.project.BankingApp.tests.auth;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OAuthTest {

    private String token = System.getenv("GITHUB_API_TOKEN");

    @Test
    public void testOAuthValidCredential(){
        given()
                .auth().oauth2(token)

                .when()
                    .get("https://api.github.com/user")

                .then()
                    .statusCode(200);
    }

    @DataProvider(name = "InvalidCredentialData")
    public Object[][] invalidCredentialData(){
        return new Object[][]{
                {"XYZ"},
                {"Abbajhkasanibyaduadid"}
        };
    }
    @Test(dataProvider = "InvalidCredentialData")
    public void testOAuthInvalidCredential(String accessToken){
        given()
                .auth().oauth2(accessToken)

                .when()
                .get("https://api.github.com/user")

                .then()
                .statusCode(401);
    }

    @Test
    public void testOAuthEmptyToken(){
        given()
                .auth().oauth2("")

                .when()
                .get("https://api.github.com/user")

                .then()
                .statusCode(401);
    }
}
