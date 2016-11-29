package com.example.andrew.android_1_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String SAVED_DATE = "LabelText";
    private TextView label;
    private EditText edit;
    DateFormat df = new SimpleDateFormat("mm:ss");
    static int createdTimes = 0;


    public final static String EXTRA_MESSAGE = "example.andrew.android_1_project.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = (TextView) findViewById(R.id.main_text);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        label.setText(String.format(
                "Saved: %s, Loaded : %s",
                savedInstanceState.getString(SAVED_DATE),
                df.format(new Date()))
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"nightmare.quake@mail.ru"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Test android");
        email.putExtra(Intent.EXTRA_TEXT, "android/body");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_DATE, df.format(new Date()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUMED");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
