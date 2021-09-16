
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TypeEstimated {

    @SerializedName("category")
    @Expose
    private String category;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TypeEstimated() {
    }

    /**
     * 
     * @param category
     */
    public TypeEstimated(String category) {
        super();
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
