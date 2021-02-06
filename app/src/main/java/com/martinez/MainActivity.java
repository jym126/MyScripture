package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    //Method for the button save
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
}