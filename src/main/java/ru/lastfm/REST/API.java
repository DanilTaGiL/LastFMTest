package ru.lastfm.REST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import ru.lastfm.REST.models.Session;
import ru.lastfm.REST.models.SessionResponse;
import ru.lastfm.REST.models.search.Album;
import ru.lastfm.REST.models.search.Track;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class API {
    public static final String API_ROOT = "http://ws.audioscrobbler.com/2.0";
    public static final String API_URL = "http://www.last.fm/api";
    public static final String API_KEY = "096b095633f2db454f5399a458c57fa0";

    public static String getToken(){
        Response response = given().
                param("method","auth.getToken").
                param("api_key",API_KEY).
                param("api_sig", getSignature("method", "auth.getToken")).
                param("format","json").
                header("User","Agent").
                when().get(API_ROOT).
                then().assertThat().
                statusCode(200).contentType(ContentType.JSON).
                extract().response();

        response.prettyPrint();

        return response.thenReturn().path("token") .toString();
    }

    public static Session getSession(String token){
        Response response = given().
                param("method", "auth.getSession").
                param("token", token).
                param("api_key", API_KEY).
                param("api_sig", getSignature("method", "auth.getSession","token", token)).
                param("format","json").
                header("User","Agent").
                when().get(API_ROOT).
                then().assertThat().
                statusCode(200).contentType(ContentType.JSON).
                extract().response();

        SessionResponse sr = response.as(SessionResponse.class);
        return sr.getSession();
    }

    public static List<Track> findTracks(String trackName, int count){
        ArrayList<Track> out = new ArrayList<>();
        Response response = findSmth(trackName, "track", count);

        for (int i = 0; i < count; i++){
            Track track = response.getBody().jsonPath().
                    getObject("results.trackmatches.track[" + i + "]", Track.class);
            out.add(track);
        }
        return out;
    }

    public static List<Album> findAlbum(String albumName, int count){
        ArrayList<Album> out = new ArrayList<>();
        Response response = findSmth(albumName, "album", count);

        for (int i = 0; i < count; i++){
            Album album = response.getBody().jsonPath().
                    getObject("results.albummatches.album[" + i + "]", Album.class);
            out.add(album);
        }
        return out;
    }

    public static void loveTrack(Track track, String sk){
//        JSONObject request = new JSONObject();
//        request.put("method", "track.love");
//        request.put("api_key", API_KEY);
//        request.put("api_sig", getSignature(
//                "api_key" , API_KEY,
//                "artist", track.getArtist(),
//                "method", "track.love",
//                "sk", sk,
//                "track", track.getName()));
//        request.put("artist", track.getArtist());
//        request.put("sk", sk);
//        request.put("track", track.getName());
//        request.put("format","json");
//
//        RequestSpecification req = RestAssured.given();
//        req.header("Content-Type", "application/json");
//        req.body(request.toString());




        Response response = //req.post(API_ROOT);
                given().
                param("api_sig", getSignature(
                        "api_key" , API_KEY,
                        "artist", track.getArtist(),
                        "method", "track.love",
                        "sk", sk,
                        "track", track.getName())).
                param("api_key", API_KEY).
                param("artist", track.getArtist()).
                param("method", "track.love").
                param("sk", sk).
                param("track", track.getName()).
                param("format","json").
                header("User","Agent").
                when().post(API_ROOT);
        response.prettyPrint();
    }

    private static Response findSmth(String searchRequest, String searchType, int count) {
        Response response = given().
                param("method", searchType + ".search").
                param("api_key", API_KEY).
                param(searchType, searchRequest).
                param("limit", count).
                param("format","json").
                header("User","Agent").
                when().get(API_ROOT).
                then().assertThat().
                statusCode(200).and().contentType(ContentType.JSON).
                extract().response();
        return  response;
    }

    private static String getSignature(String... params){
        StringBuilder signature = new StringBuilder();
        System.out.println(signature);
        for (String s : params) {
            signature.append(s);
            System.out.println(s);
        }
        signature.append("f73c250d816de1a2d1ffa7dd89c71e0d");
        System.out.println(DigestUtils.md5Hex(signature.toString()));
        return DigestUtils.md5Hex(signature.toString());
    }
}
