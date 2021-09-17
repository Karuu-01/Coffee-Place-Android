package com.moringaschool.coffeeplace;

public class Constants {
    public static final String TRAVEL_BASE_URL = "http://api.opentripmap.com/0.1/en/";
    String newUrlString = TRAVEL_BASE_URL.replace("http", "https");
    public static final String TRAVEL_API_KEY = BuildConfig.TRAVEL_API_KEY;
    public static final String KEY = BuildConfig.KEY;
}
