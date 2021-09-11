
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class HoldTime {

    @SerializedName("deadline")
    @Expose
    private String deadline;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HoldTime() {
    }

    /**
     * 
     * @param deadline
     */
    public HoldTime(String deadline) {
        super();
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
