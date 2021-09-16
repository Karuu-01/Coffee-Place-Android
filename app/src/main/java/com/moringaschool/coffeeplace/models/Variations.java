
package com.moringaschool.coffeeplace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Variations {

    @SerializedName("average")
    @Expose
    private Average average;
    @SerializedName("changes")
    @Expose
    private List<Change> changes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Variations() {
    }

    /**
     * 
     * @param average
     * @param changes
     */
    public Variations(Average average, List<Change> changes) {
        super();
        this.average = average;
        this.changes = changes;
    }

    public Average getAverage() {
        return average;
    }

    public void setAverage(Average average) {
        this.average = average;
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }

}
