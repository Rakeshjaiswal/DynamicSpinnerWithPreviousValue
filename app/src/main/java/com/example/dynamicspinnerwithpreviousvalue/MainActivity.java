 package com.example.dynamicspinnerwithpreviousvalue;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private SharedPreferences prefs;
    private String prefName = "spinner_value";
    int id=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> list=new ArrayList<String>();
        list.add("rk 1");
        list.add("rk 2");
        list.add("rk 3");
        list.add("rk 4");
        list.add("rk 5");

        final Spinner sp=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);

        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val",0);
        sp.setSelection(id);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
        });
    }


}