package com.example.dynamicspinnerwithpreviousvalue;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dynamicspinnerwithpreviousvalue.api.Api_Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchCourse extends AppCompatActivity {
    private SharedPreferences prefs;
    private String prefName = "spinner_value";
    int id;

    ArrayAdapter arrayAdapter;

    Spinner sp;

  public static List<String> myList;
  public static List<String> myCourseId;

  String CourseID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_course);


        sp = (Spinner) findViewById(R.id.spinner1);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id = prefs.getInt("last_val", 0);
        CourseApi();


       /* sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int pos, long arg3) {
                // TODO Auto-generated method stub

                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putInt("last_val", pos);

                //---saves the values---
                editor.commit();

                Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });*/
    }


    public void CourseApi() {
        //get Course Data from API
        Call<CoursesModel> call = Api_Client.getInstance().getAllCourse();
        call.enqueue(new Callback<CoursesModel>() {
            @Override
            public void onResponse(Call<CoursesModel> call, Response<CoursesModel> response) {
                if (response.isSuccessful()) {
                    CoursesModel coursesModel = response.body();
                    final ArrayList<CoursesModelDetails> courseDetails = (ArrayList<CoursesModelDetails>) coursesModel.getCoursesModelDetails();

                    for (CoursesModelDetails subParent : courseDetails) {
                        myList = new ArrayList<String>();
                        myCourseId = new ArrayList<String>();
                        for (int i = 0; i < courseDetails.size(); i++) {
                            myList.add(courseDetails.get(i).getSubcourseName());
                            myCourseId.add(courseDetails.get(i).getId());
                        }
                        arrayAdapter = new ArrayAdapter(getApplication(), android.R.layout.simple_list_item_1, myList);
                        sp.setAdapter(arrayAdapter);


                        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                                       int pos, long arg3) {
                                // TODO Auto-generated method stub

                                CourseID = courseDetails.get(pos).getId();
                                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();

                                //---save the values in the EditText view to preferences---
                                editor.putInt("last_val", pos);

                                //---saves the values---
                                editor.commit();


                                Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(),
                                        Toast.LENGTH_SHORT).show();

                                Toast.makeText(getBaseContext(), CourseID.toString(),
                                        Toast.LENGTH_SHORT).show();

                            }

                            public void onNothingSelected(AdapterView<?> arg0) {
                                // TODO Auto-generated method stub

                            }
                        });

                        sp.setSelection(id);
                    }
                }
            }

            @Override
            public void onFailure(Call<CoursesModel> call, Throwable t) {

                // Toast.makeText(LoginPage.this, "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* public void CourseApi() {
        //get Course Data from API
        Call<CoursesModel> call = Api_Client.getInstance().getAllCourse();
        call.enqueue(new Callback<CoursesModel>() {
            @Override
            public void onResponse(Call<CoursesModel> call, Response<CoursesModel> response) {
                if (response.isSuccessful()) {
                    CoursesModel coursesModel = response.body();
                    final ArrayList<CoursesModelDetails> courseDetails = (ArrayList<CoursesModelDetails>) coursesModel.getCoursesModelDetails();

                    for (CoursesModelDetails subParent : courseDetails) {
                        List<String> myList = new ArrayList<String>();
                        //  myList.add("Choose Your Course");
                        for (int i = 0; i < courseDetails.size(); i++) {
                            myList.add(courseDetail s.get(i).getSubcourseName());
                        }
                        arrayAdapter = new ArrayAdapter(getApplication(), android.R.layout.simple_list_item_1, myList);
                        course_spinner.setAdapter(arrayAdapter);
                        course_spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                                if (position != 0) {
                                    courseDetails.get(position).getSubcourseName();
                                    CourseID = courseDetails.get(position).getId();
                                    System.out.println("courseId::" + CourseID);
                                    Toast.makeText(FetchCourse.this, "My course  " + courseDetails.get(position).getSubcourseName(), Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(FetchCourse.this,
                                            "Please Select My course !!", Toast.LENGTH_LONG)
                                            .show();
                                    return;
                                }

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<CoursesModel> call, Throwable t) {

                // Toast.makeText(LoginPage.this, "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}
