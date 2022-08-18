package com.yandex.api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestPostman3 {
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";


    }
    @Test
    public void checkCon(){
        Card card = new Card("Интересное место", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card("Интересное место", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg"));
        cards.add(new Card("Интересное место", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg"));
        cards.add(new Card("Интересное место", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg"));
        System.out.println(cards);
        given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmZhMmM5MWQzYjg2YTAwM2Q2N2NkYTkiLCJpYXQiOjE2NjA1NjI1NzgsImV4cCI6MTY2MTE2NzM3OH0.4gE9CrCPh7Z7TUAjWgTBzbmGNBZ5Ub0WkUaxK1QdhIk")
                .and()
                .body(card)
                .when()
                .post("/api/cards")
                .then()
                .statusCode(201);
    }
}
