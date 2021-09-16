
package com.moringaschool.coffeeplace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AcceptedPayments {

    @SerializedName("creditCards")
    @Expose
    private List<String> creditCards = null;
    @SerializedName("methods")
    @Expose
    private List<String> methods = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AcceptedPayments() {
    }

    /**
     * 
     * @param creditCards
     * @param methods
     */
    public AcceptedPayments(List<String> creditCards, List<String> methods) {
        super();
        this.creditCards = creditCards;
        this.methods = methods;
    }

    public List<String> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<String> creditCards) {
        this.creditCards = creditCards;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

}
