package ru.lastfm.REST;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class APIMethods {
//    public static final String API_ROOT = "http://ws.audioscrobbler.com/2.0";
//    public static final String API_URL = "http://www.last.fm/api";
//    public static final String API_KEY = "096b095633f2db454f5399a458c57fa0";
//
//    public static String getToken(){
//        Response response = get(API_ROOT + "/?method=auth.gettoken&api_key=" + API_KEY + "&api_sig=");
//        System.out.println(response.asString());
//        System.out.println(response.path("lfm.token").toString());
//        return response.path("lfm.token").toString();
//    }
//
//    public static String getSignature(String methodName, HashMap<String, String> params){
//        StringBuilder signature = new StringBuilder("api_key" + API_KEY + "method" + methodName);
//        for (Map.Entry<String,String> entry : params.entrySet()){
//            signature.append(entry.getKey());
//            signature.append(entry.getValue());
//        }
//        System.out.println(signature.toString());
//        return DigestUtils.md5Hex(signature.toString());
//    }
//
//    public static String getSig(String methodName, String token){
//        String sig = "api_key" + API_KEY + "method" + methodName + "token" + token + "f73c250d816de1a2d1ffa7dd89c71e0d";
////        System.out.println(sig);
//        System.out.println("Token_1: " + DigestUtils.md5Hex(sig));
//
////        try {
////            java.io.PrintStream sysout = new java.io.PrintStream(System.out, true, "UTF-8");
////            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
////            byte[] md5_byte_array = md5.digest(sig.getBytes());
////            String md5_string = new String(md5_byte_array);
////            System.out.println("Token_2: " + md5_string);
////            return DigestUtils.md5Hex(sig);
////        } catch (Exception e){
////
////        }
//
//
//        return DigestUtils.md5Hex(sig);
//    }
//
//    public static String getSessionKey(String token){
//        String api_sig = getSig("auth.getSession", token);
//        String auth = "/?method=auth.getSession&api_key=%s&token=%s&api_sig=%s";
//        Response response = get(API_ROOT + String.format(auth, API_KEY, token, api_sig));
//        System.out.println(response.asString());
//        return "";
//    }
}
