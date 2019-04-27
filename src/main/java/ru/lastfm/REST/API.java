package ru.lastfm.REST;


import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;

import static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;

public class API {
    public static final String API_ROOT = "http://ws.audioscrobbler.com/2.0";
    public static final String API_URL = "http://www.last.fm/api";
    public static final String API_KEY = "096b095633f2db454f5399a458c57fa0";

    public static String getToken(){
        String token = given().
                param("method","auth.getToken").
                param("api_key",API_KEY).
                param("api_sig", getSignature("auth.getToken")).
                header("User","Agent").
        when().
                get(API_ROOT).thenReturn().path("lfm.token") .toString();
        if (token.length()==0) throw new RuntimeException();
        return token;
    }

    public static String getSignature(String methodName, String... params){
        StringBuilder signature = new StringBuilder("api_key" + API_KEY + "method" + methodName);
        for (String s : params)
            signature.append(s);
        signature.append("f73c250d816de1a2d1ffa7dd89c71e0d");
//        System.out.println(signature.toString());
//        System.out.println(DigestUtils.md5Hex(signature.toString()));
        return DigestUtils.md5Hex(signature.toString());
    }

    public static String getSessionKey(String token){
        return  given().
                param("method", "auth.getSession").
                param("token", token).
                param("api_key", API_KEY).
                param("api_sig", getSignature("auth.getSession","token",
                        token)).
                header("User","Agent").
                when().get(API_ROOT).thenReturn().asString();
    }
}
