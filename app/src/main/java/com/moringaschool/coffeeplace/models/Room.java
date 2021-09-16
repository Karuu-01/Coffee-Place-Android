
package com.moringaschool.coffeeplace.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Room {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("typeEstimated")
    @Expose
    private TypeEstimated typeEstimated;
    @SerializedName("description")
    @Expose
    private Description__1 description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Room() {
    }

    /**
     * 
     * @param typeEstimated
     * @param description
     * @param type
     */
    public Room(String type, TypeEstimated typeEstimated, Description__1 description) {
        super();
        this.type = type;
        this.typeEstimated = typeEstimated;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeEstimated getTypeEstimated() {
        return typeEstimated;
    }

    public void setTypeEstimated(TypeEstimated typeEstimated) {
        this.typeEstimated = typeEstimated;
    }

    public Description__1 getDescription() {
        return description;
    }

    public void setDescription(Description__1 description) {
        this.description = description;
    }

}
