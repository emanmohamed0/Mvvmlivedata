package com.al7osam.mvvmlivedata.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eman.eraqi on 12/30/2018.
 */

public class Species {
    @SerializedName("name")
    String name;
    @SerializedName("classification")
    String classification;
    @SerializedName("language")
    String language;
    @SerializedName("lifeSpan")
    String lifeSpan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
}
