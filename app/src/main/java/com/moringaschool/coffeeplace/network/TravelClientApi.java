package com.moringaschool.coffeeplace.network;

import static com.moringaschool.coffeeplace.Constants.TRAVEL_API_KEY;
import static com.moringaschool.coffeeplace.Constants.TRAVEL_BASE_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TravelClientApi {
    private static Retrofit retrofit = null;
    public static TravelSearchApi getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", TRAVEL_API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(TRAVEL_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TravelSearchApi.class);
    }
}
