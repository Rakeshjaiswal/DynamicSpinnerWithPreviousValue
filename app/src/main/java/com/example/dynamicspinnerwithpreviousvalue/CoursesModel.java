package com.example.dynamicspinnerwithpreviousvalue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoursesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private List<CoursesModelDetails> coursesModelDetails = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<CoursesModelDetails> getCoursesModelDetails() {
        return coursesModelDetails;
    }

    public void setCoursesModelDetails(List<CoursesModelDetails> coursesModelDetails) {
        this.coursesModelDetails = coursesModelDetails;
    }


}
