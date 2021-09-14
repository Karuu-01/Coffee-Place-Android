package com.moringaschool.coffeeplace;

public class Constants {
    public static final String TRAVEL_BASE_URL = "https://api.yelp.com/v3/";
    String newUrlString = TRAVEL_BASE_URL.replace("http", "https");
    public static final String TRAVEL_API_KEY = BuildConfig.TRAVEL_API_KEY;
}
