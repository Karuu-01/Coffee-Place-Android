
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Offer {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("checkInDate")
    @Expose
    private String checkInDate;
    @SerializedName("checkOutDate")
    @Expose
    private String checkOutDate;
    @SerializedName("rateCode")
    @Expose
    private String rateCode;
    @SerializedName("rateFamilyEstimated")
    @Expose
    private RateFamilyEstimated rateFamilyEstimated;
    @SerializedName("room")
    @Expose
    private Room room;
    @SerializedName("guests")
    @Expose
    private Guests guests;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("policies")
    @Expose
    private Policies policies;
    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("commission")
    @Expose
    private Commission commission;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Offer() {
    }

    /**
     * 
     * @param checkOutDate
     * @param price
     * @param guests
     * @param policies
     * @param self
     * @param rateFamilyEstimated
     * @param commission
     * @param id
     * @param checkInDate
     * @param rateCode
     * @param room
     */
    public Offer(String id, String checkInDate, String checkOutDate, String rateCode, RateFamilyEstimated rateFamilyEstimated, Room room, Guests guests, Price price, Policies policies, String self, Commission commission) {
        super();
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.rateCode = rateCode;
        this.rateFamilyEstimated = rateFamilyEstimated;
        this.room = room;
        this.guests = guests;
        this.price = price;
        this.policies = policies;
        this.self = self;
        this.commission = commission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public RateFamilyEstimated getRateFamilyEstimated() {
        return rateFamilyEstimated;
    }

    public void setRateFamilyEstimated(RateFamilyEstimated rateFamilyEstimated) {
        this.rateFamilyEstimated = rateFamilyEstimated;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Policies getPolicies() {
        return policies;
    }

    public void setPolicies(Policies policies) {
        this.policies = policies;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

}
