package com.moringaschool.coffeeplace.network;


import com.moringaschool.coffeeplace.BuildConfig;
import com.moringaschool.coffeeplace.models.TravelAttractionResponse;
import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TravelSearchApi {
    @GET("places/radius?radius=10000000&lon=37.9062&lat=0.0263&format=json&apikey=")
    Call<TravelGeoSightingResponse> getHotels(
            @Query(BuildConfig.TRAVEL_API_KEY) String apikey);

    @GET("places/radius?radius=10000000&lon=37.9062&lat=0.02363&kinds=tourist_facilities&format=json")
    Call<TravelAttractionResponse> getTourist();
}
