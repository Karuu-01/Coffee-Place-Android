package com.moringaschool.newsapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClientApi {

    private static Retrofit retrofit = null;

    public static NewsSearchApi getNewsSearchApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(NewsSearchApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NewsSearchApi.class);
    }
}
