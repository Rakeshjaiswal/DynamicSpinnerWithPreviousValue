package com.example.dynamicspinnerwithpreviousvalue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoursesModelDetails {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("subcourse")
    @Expose
    private String subcourseName;

    public String getId() {
        return id;
    }

    public String getSubcourseName() {
        return subcourseName;
    }

    public void setSubcourseName(String subcourseName) {
        this.subcourseName = subcourseName;
    }

    public void setId(String id) {
        this.id = id;
    }



}
