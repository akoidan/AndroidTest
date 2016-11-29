package com.example.andrew.android_1_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Andrew on 29/11/2016.
 */

public class SharPrefDemo extends AppCompatActivity {

    private EditText edit;
    private SharedPreferences.Editor editor;
    private  SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shar_pref);
        edit = (EditText) findViewById(R.id.edit_preferense);
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void saveTextToFile(View view) {
        String s = edit.getText().toString();
        editor.putString("value", s);
        editor.commit();
    }

    public void loadFromFile(View view) {
        String string = sharedPref.getString("value", "undefined");
        edit.setText(string);
    }


}
