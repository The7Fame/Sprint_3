package com.yandex.api;

import com.google.gson.Gson;

public class tToJson {
    public static void main(String[] args){
        Card card = new Card("lslsls", "sdsdsds");
        Gson json = new Gson();
        String jsons = json.toJson(card);
        System.out.println(jsons);
        String jsonString = "{\"name\":\"Интересное место\", \"link\": \"https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg\"}";
// десериализуем строку
        Card card2 = json.fromJson(jsonString, Card.class);
        System.out.println(card2.getLink());
    }
}
