package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Screen extends AppCompatActivity {

    private TextView myScreen;
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
        String bookData = getIntent().getStringExtra("bookData");
        String chapterData = getIntent().getStringExtra("chapterData");
        String verseData = getIntent().getStringExtra("verseData");

        //Sending customized and variables data to the textView (screen)
        myScreen.setText("This is your scripture \n" + bookData +" " + chapterData + ":" + verseData);
    }

    //Method for return to main activity button
    public void Returning(View view) {
        Intent returning = new Intent(Screen.this, MainActivity.class);
        startActivity(returning);

    }

}