package com.example.go360mart.utils;

import com.ciyashop.library.apicall.URLS;

public class APIS {

    //TODO:Copy and Paste URL and Key Below from Admin Panel.
    public final String APP_URL = "https://go360mart.com/";
    public final String WOO_MAIN_URL = APP_URL + "wp-json/wc/v2/";
    public final String MAIN_URL = APP_URL + "wp-json/pgs-woo-api/v1/";

    public static final String CONSUMERKEY = "HOIHOQDi8C89";
    public static final String CONSUMERSECRET = "AIlpI4qIfDf3KRiuimXR74vypxUaRhwlxoBc27SKZwmAJibB";
    public static final String OAUTH_TOKEN = "K2Ikzao8c5lyCrzDYZYhPVDm";
    public static final String OAUTH_TOKEN_SECRET = "4lBO34cVSsdQ0i5Hpa44peYk6qSDGva9t7cxRBo5AhHo8N7N";

    public static final String WOOCONSUMERKEY = "ck_3dd94896246b388b67fe2353ea8d9ea2ca53b49f";
    public static final String WOOCONSUMERSECRET = "cs_a4da13203f4634d71cceb66be439e5b46b04722d";
    public static final String version="3.2.4";


    public APIS() {
        URLS.APP_URL = APP_URL;
        URLS.NATIVE_API = APP_URL + "wp-json/wc/v3/";
        URLS.WOO_MAIN_URL = WOO_MAIN_URL;
        URLS.MAIN_URL = MAIN_URL;
        URLS.version = version;
        URLS.CONSUMERKEY = CONSUMERKEY;
        URLS.CONSUMERSECRET = CONSUMERSECRET;
        URLS.OAUTH_TOKEN = OAUTH_TOKEN;
        URLS.OAUTH_TOKEN_SECRET = OAUTH_TOKEN_SECRET;
        URLS.WOOCONSUMERKEY = WOOCONSUMERKEY;
        URLS.WOOCONSUMERSECRET = WOOCONSUMERSECRET;
    }
}