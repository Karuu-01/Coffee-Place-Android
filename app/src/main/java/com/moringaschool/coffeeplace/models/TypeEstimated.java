
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TypeEstimated {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("beds")
    @Expose
    private Integer beds;
    @SerializedName("bedType")
    @Expose
    private String bedType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TypeEstimated() {
    }

    /**
     * 
     * @param category
     * @param beds
     * @param bedType
     */
    public TypeEstimated(String category, Integer beds, String bedType) {
        super();
        this.category = category;
        this.beds = beds;
        this.bedType = bedType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

}
