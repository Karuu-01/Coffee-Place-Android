
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Change {

    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("base")
    @Expose
    private String base;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Change() {
    }

    /**
     * 
     * @param endDate
     * @param startDate
     * @param base
     */
    public Change(String startDate, String endDate, String base) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.base = base;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
