
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Commission {

    @SerializedName("amount")
    @Expose
    private String amount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Commission() {
    }

    /**
     * 
     * @param amount
     */
    public Commission(String amount) {
        super();
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
