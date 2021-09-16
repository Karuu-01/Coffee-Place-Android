package com.moringaschool.coffeeplace.network;


import com.moringaschool.coffeeplace.models.TravelBusinessesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TravelSearchApi {
    @GET("businesses/search")
    Call<TravelBusinessesSearchResponse> getHotels(
            @Query("location") String location,
            @Query("term") String term

    );
}
