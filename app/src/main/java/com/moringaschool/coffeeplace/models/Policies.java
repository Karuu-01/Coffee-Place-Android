
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Policies {

    @SerializedName("guarantee")
    @Expose
    private Guarantee guarantee;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("cancellation")
    @Expose
    private Cancellation cancellation;
    @SerializedName("holdTime")
    @Expose
    private HoldTime holdTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Policies() {
    }

    /**
     * 
     * @param cancellation
     * @param guarantee
     * @param holdTime
     * @param paymentType
     */
    public Policies(Guarantee guarantee, String paymentType, Cancellation cancellation, HoldTime holdTime) {
        super();
        this.guarantee = guarantee;
        this.paymentType = paymentType;
        this.cancellation = cancellation;
        this.holdTime = holdTime;
    }

    public Guarantee getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Cancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public HoldTime getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(HoldTime holdTime) {
        this.holdTime = holdTime;
    }

}
