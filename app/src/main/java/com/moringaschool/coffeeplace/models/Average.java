
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Average {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("total")
    @Expose
    private String total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Average() {
    }

    /**
     * 
     * @param total
     * @param base
     */
    public Average(String base, String total) {
        super();
        this.base = base;
        this.total = total;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
