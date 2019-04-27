package ru.lastfm.REST;


import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;

public class API {
    public static final String API_ROOT = "http://ws.audioscrobbler.com/2.0";
    public static final String API_KEY = "096b095633f2db454f5399a458c57fa0";

    public static void getToken(){
//        given().parameters("method","auth.getToken","api_key",API_KEY).
//                when()
        System.out.println( with().parameters("method","auth.getToken","api_key",API_KEY).when().get(API_ROOT).thenReturn().asString());

    }
}
