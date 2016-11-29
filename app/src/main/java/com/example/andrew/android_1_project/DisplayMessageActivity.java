package com.example.andrew.android_1_project;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(R.string.pass_intent_msg);
        TextView textView2 = new TextView(this);
        textView2.setTextSize(55);
        textView2.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getActionBar();
//            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        layout.addView(textView);
        layout.addView(textView2);


    }
}
