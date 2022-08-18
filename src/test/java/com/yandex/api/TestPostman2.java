package com.yandex.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPostman2 {
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";


    }
    @Test
    public void checkCon(){
        File json = new File("src/test/resources/updateProfile.json");
        Response response = given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmZhMmM5MWQzYjg2YTAwM2Q2N2NkYTkiLCJpYXQiOjE2NjA1NjI1NzgsImV4cCI6MTY2MTE2NzM3OH0.4gE9CrCPh7Z7TUAjWgTBzbmGNBZ5Ub0WkUaxK1QdhIk")
                .and()
                .body(json)
                .when()
                .patch("/api/users/me");
        response.then().assertThat().statusCode(200).and().body("data.name", equalTo("Василий Васильев"));
    }
}
