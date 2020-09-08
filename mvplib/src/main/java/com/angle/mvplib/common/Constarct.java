package com.angle.mvplib.common;

public interface Constarct {


//    String BASE_URL = "https://www.seetao.com";
    String BASE_URL = "http://169.254.96.147:8085/";
    String VALUE_FROM = "ios";
    String VALUE_LANG = "zh";



    interface  URL{
        String LOGIN = "app/v_1_7_2/user/login2";
        String GET_USER = "/api/user/getuserinfo";
        String COLUMN_MANAGER = "/api/column/columnmanagelist";
        String CONTENT = "home/content";
    }


    interface  RequestKey{


        String KEY_FROM = "from";
        String KEY_LANG = "lang";
        String KEY_TIMESTAMP = "timestamp";
        String KEY_NONCE = "nonce";
        String KEY_SIGNATURE = "signature";


        String KEY_USER_ACCOUNT = "username";
        String KEY_USER_PASSWORD = "password";
        String KEY_CODE = "code";
        String KEY_TOKEN = "token";



    }
}
