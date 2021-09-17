
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Point {
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Point() {
    }

    /**
     * 
     * @param lon
     * @param lat
     */
    public Point(Double lon, Double lat) {
        super();
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
