package com.example.dynamicspinnerwithpreviousvalue.api;


import com.example.dynamicspinnerwithpreviousvalue.CoursesModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {



    //Get All course
    @GET("courses")
    Call<CoursesModel> getAllCourse();


}
