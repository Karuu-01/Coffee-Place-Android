
package com.moringaschool.coffeeplace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Address {

    @SerializedName("lines")
    @Expose
    private List<String> lines = null;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param cityName
     * @param countryCode
     * @param postalCode
     * @param lines
     */
    public Address(List<String> lines, String postalCode, String cityName, String countryCode) {
        super();
        this.lines = lines;
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.countryCode = countryCode;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
