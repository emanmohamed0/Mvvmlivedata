package com.al7osam.mvvmlivedata.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eman.eraqi on 12/30/2018.
 */

public class SpeciesList {
    @SerializedName("results")
    List<Species> speciesList;

    @SerializedName("next")
    String next;

    public void setSpeciesList(List<Species> speciesList) {
        this.speciesList = speciesList;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public String getNext() {
        return next;
    }
}
