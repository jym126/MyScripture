package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Screen extends AppCompatActivity {

    private TextView myScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);
        myScreen = (TextView)findViewById(R.id.screen1);

        String bookData = getIntent().getStringExtra("bookData");
        String chapterData = getIntent().getStringExtra("chapterData");
        String verseData = getIntent().getStringExtra("verseData");
        String data = "Your Scripture is ";

        myScreen.setText("This is your scripture \n" + bookData +" " + chapterData + ":" + verseData);
    }

    //Method for return button
    public void Returning(View view) {
        Intent returning = new Intent(Screen.this, MainActivity.class);
        startActivity(returning);

    }

}