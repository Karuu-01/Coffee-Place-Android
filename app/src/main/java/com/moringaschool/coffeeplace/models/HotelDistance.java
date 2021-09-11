
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class HotelDistance {

    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("distanceUnit")
    @Expose
    private String distanceUnit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HotelDistance() {
    }

    /**
     * 
     * @param distanceUnit
     * @param distance
     */
    public HotelDistance(Double distance, String distanceUnit) {
        super();
        this.distance = distance;
        this.distanceUnit = distanceUnit;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

}
