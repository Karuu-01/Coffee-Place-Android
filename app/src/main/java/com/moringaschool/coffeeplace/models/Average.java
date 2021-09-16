
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Average {

    @SerializedName("base")
    @Expose
    private String base;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Average() {
    }

    /**
     * 
     * @param base
     */
    public Average(String base) {
        super();
        this.base = base;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
