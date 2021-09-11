
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RateFamilyEstimated {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RateFamilyEstimated() {
    }

    /**
     * 
     * @param code
     * @param type
     */
    public RateFamilyEstimated(String code, String type) {
        super();
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
