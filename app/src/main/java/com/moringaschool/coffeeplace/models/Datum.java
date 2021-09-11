
package com.moringaschool.coffeeplace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("hotel")
    @Expose
    private Hotel hotel;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;
    @SerializedName("self")
    @Expose
    private String self;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param offers
     * @param available
     * @param hotel
     * @param self
     * @param type
     */
    public Datum(String type, Hotel hotel, Boolean available, List<Offer> offers, String self) {
        super();
        this.type = type;
        this.hotel = hotel;
        this.available = available;
        this.offers = offers;
        this.self = self;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

}
