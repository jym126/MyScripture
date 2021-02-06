package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Declaring variables for each componet
    private EditText book;
    private EditText chapter;
    private  EditText verse;
    private Button buton;
    //Just for debugging purpose tag for logcat
    private  static final String Tag = "Save button handler";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relating variables to component in xml layout
        book = findViewById(R.id.book);
        chapter = findViewById(R.id.chapter);
        verse = findViewById(R.id.verse);
        buton = findViewById(R.id.button);

    }
    //Method for the button Send
    public void Escritura(View view){
        //Creating variables to store the editText components data
        String bookData = book.getText().toString();
        String chapterData = chapter.getText().toString();
        String verseData = verse.getText().toString();

        //Log message to show in logcat during debugging
        Log.d(Tag, "About to create intent with John 3:16");

        //creating new Intent object to send data from this activity to screen activity
        Intent intent = new Intent(this, Screen.class);

        //sending data with the intent
        intent.putExtra("bookData", bookData);
        intent.putExtra("chapterData", chapterData);
        intent.putExtra("verseData", verseData);

        startActivity(intent);
    }

    public void Loading(View view){
        // Retrieving the value using its keys the file name
        // must be same in both saving and retrieving the data
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // The value will be default as empty string because for
        // the very first time when the app is opened, there is nothing to show
        String bookData = sh.getString("bookData1", "");
        String chapterData = sh.getString("chapterData1", "");
        String verseData = sh.getString("verseData1", "");


        // We can then use the data
        book.setText(bookData);
        chapter.setText(chapterData);
        verse.setText(verseData);
    }
}