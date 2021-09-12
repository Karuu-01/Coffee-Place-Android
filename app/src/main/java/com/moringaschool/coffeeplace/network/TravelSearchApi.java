package com.moringaschool.coffeeplace.network;

import com.moringaschool.coffeeplace.models.HotelSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TravelSearchApi {
    @GET("shopping/hotel/offers")
    Call<HotelSearchResponse> getHotels(
            @Query("cityCode") String cityCode,
            @Query("hotelName") String hotelName,
            @Query("priceRange") String priceRange,
            @Query("view") String view

    );
}
