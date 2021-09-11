
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cancellation {

    @SerializedName("numberOfNights")
    @Expose
    private Integer numberOfNights;
    @SerializedName("deadline")
    @Expose
    private String deadline;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cancellation() {
    }

    /**
     * 
     * @param numberOfNights
     * @param deadline
     */
    public Cancellation(Integer numberOfNights, String deadline) {
        super();
        this.numberOfNights = numberOfNights;
        this.deadline = deadline;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(Integer numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
