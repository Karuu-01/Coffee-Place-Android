
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Links {

    @SerializedName("next")
    @Expose
    private String next;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param next
     */
    public Links(String next) {
        super();
        this.next = next;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
