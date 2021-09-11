
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Guarantee {

    @SerializedName("acceptedPayments")
    @Expose
    private AcceptedPayments acceptedPayments;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Guarantee() {
    }

    /**
     * 
     * @param acceptedPayments
     */
    public Guarantee(AcceptedPayments acceptedPayments) {
        super();
        this.acceptedPayments = acceptedPayments;
    }

    public AcceptedPayments getAcceptedPayments() {
        return acceptedPayments;
    }

    public void setAcceptedPayments(AcceptedPayments acceptedPayments) {
        this.acceptedPayments = acceptedPayments;
    }

}
