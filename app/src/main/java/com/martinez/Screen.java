package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen extends AppCompatActivity {

    private TextView myScreen;
    private Button saveButton;
    private String bookData;
    private String chapterData;
    private String verseData;
    //Just for debugging purpose tag for logcat
    private  static final String Tag = "Receiving intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);
        myScreen = findViewById(R.id.screen1);

        //Log message to show in logcat during debugging
        Log.d(Tag, "Received intent with John 3:16");

        //Receiving data with intent
        bookData = getIntent().getStringExtra("bookData");
        chapterData = getIntent().getStringExtra("chapterData");
        verseData = getIntent().getStringExtra("verseData");

        //Sending customized and variables data to the textView (screen)
        myScreen.setText("This is your scripture \n" + bookData +" " + chapterData + ":" + verseData);
    }

    public void Saving(View view) {

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit1 = sharedPreferences.edit();
        SharedPreferences.Editor myEdit2 = sharedPreferences.edit();
        SharedPreferences.Editor myEdit3 = sharedPreferences.edit();
        // write all the data entered by the user in SharedPreference and apply
        myEdit1.putString("bookData1", bookData);
        myEdit2.putString("chapterData1", chapterData);
        myEdit3.putString("verseData1", verseData);

        myEdit1.apply();
        myEdit2.apply();
        myEdit3.apply();

    }


    //Method for return to main activity button
    public void Returning(View view) {
        Intent returning = new Intent(Screen.this, MainActivity.class);
        startActivity(returning);

    }

}