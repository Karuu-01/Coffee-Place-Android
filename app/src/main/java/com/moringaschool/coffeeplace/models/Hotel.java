
package com.moringaschool.coffeeplace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hotel {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("hotelId")
    @Expose
    private String hotelId;
    @SerializedName("chainCode")
    @Expose
    private String chainCode;
    @SerializedName("dupeId")
    @Expose
    private String dupeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("cityCode")
    @Expose
    private String cityCode;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("hotelDistance")
    @Expose
    private HotelDistance hotelDistance;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("amenities")
    @Expose
    private List<String> amenities = null;
    @SerializedName("media")
    @Expose
    private List<Medium> media = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hotel() {
    }

    /**
     * 
     * @param amenities
     * @param address
     * @param chainCode
     * @param cityCode
     * @param latitude
     * @param dupeId
     * @param rating
     * @param description
     * @param hotelId
     * @param media
     * @param type
     * @param hotelDistance
     * @param contact
     * @param name
     * @param longitude
     */
    public Hotel(String type, String hotelId, String chainCode, String dupeId, String name, String rating, String cityCode, Double latitude, Double longitude, HotelDistance hotelDistance, Address address, Contact contact, Description description, List<String> amenities, List<Medium> media) {
        super();
        this.type = type;
        this.hotelId = hotelId;
        this.chainCode = chainCode;
        this.dupeId = dupeId;
        this.name = name;
        this.rating = rating;
        this.cityCode = cityCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hotelDistance = hotelDistance;
        this.address = address;
        this.contact = contact;
        this.description = description;
        this.amenities = amenities;
        this.media = media;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getDupeId() {
        return dupeId;
    }

    public void setDupeId(String dupeId) {
        this.dupeId = dupeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public HotelDistance getHotelDistance() {
        return hotelDistance;
    }

    public void setHotelDistance(HotelDistance hotelDistance) {
        this.hotelDistance = hotelDistance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

}
