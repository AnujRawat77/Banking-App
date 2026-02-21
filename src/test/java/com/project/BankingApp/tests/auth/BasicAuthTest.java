package com.project.BankingApp.tests.auth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthTest {

    @Test
    public void testBasicAuthValidCredentials(){
        given()
                .auth().basic("user", "passwd")
                .pathParam("username", "user")
                .pathParam("password", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/{username}/{password}")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testBasicAuthInvalidUser(){
        given()
                .auth().basic("wronguser", "passwd")
                .pathParam("username", "user")
                .pathParam("password", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/{username}/{password}")

                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void testBasicAuthInvalidPassword(){
        given()
                .auth().basic("user", "wrongpass")
                .pathParam("username", "user")
                .pathParam("password", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/{username}/{password}")

                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void testBasicAuthEmptyUser(){
        given()
                .auth().basic("user", "passwd")
                .pathParam("username", "")
                .pathParam("password", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/{username}/{password}")

                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testBasicAuthEmptyPassword(){
        given()
                .auth().basic("user", "passwd")
                .pathParam("username", "user")
                .pathParam("password", "")

                .when()
                .get("https://httpbin.org/basic-auth/{username}/{password}")

                .then()
                .statusCode(404)
                .log().all();
    }
}
