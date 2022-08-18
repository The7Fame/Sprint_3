package com.yandex.api;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPostman {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";


    }

    @Test
    @DisplayName("Check status code of /users/me")
    public void checkCon(){
        File json = new File("src/test/resources/newCard.json");
        System.out.println(json);
        given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmZhMmM5MWQzYjg2YTAwM2Q2N2NkYTkiLCJpYXQiOjE2NjA1NjI1NzgsImV4cCI6MTY2MTE2NzM3OH0.4gE9CrCPh7Z7TUAjWgTBzbmGNBZ5Ub0WkUaxK1QdhIk")
                .and()
                .body(json)
                .when()
                .post("/api/users/me")
                .then()
                .statusCode(201);
    }
}
