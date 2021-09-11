
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Price {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("variations")
    @Expose
    private Variations variations;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param total
     * @param variations
     * @param currency
     * @param base
     */
    public Price(String currency, String base, String total, Variations variations) {
        super();
        this.currency = currency;
        this.base = base;
        this.total = total;
        this.variations = variations;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Variations getVariations() {
        return variations;
    }

    public void setVariations(Variations variations) {
        this.variations = variations;
    }

}
