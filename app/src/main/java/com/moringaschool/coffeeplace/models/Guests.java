
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Guests {

    @SerializedName("adults")
    @Expose
    private Integer adults;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Guests() {
    }

    /**
     * 
     * @param adults
     */
    public Guests(Integer adults) {
        super();
        this.adults = adults;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

}
