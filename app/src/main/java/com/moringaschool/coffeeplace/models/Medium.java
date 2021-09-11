
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Medium {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("category")
    @Expose
    private String category;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param category
     * @param uri
     */
    public Medium(String uri, String category) {
        super();
        this.uri = uri;
        this.category = category;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
