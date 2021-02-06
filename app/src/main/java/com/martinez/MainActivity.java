package com.martinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText book;
    private EditText chapter;
    private  EditText verse;
    private Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book = (EditText)findViewById(R.id.book);
        chapter = (EditText)findViewById(R.id.chapter);
        verse = (EditText)findViewById(R.id.verse);
        buton = (Button)findViewById(R.id.button);

    }
    //Method for the button save
    public void Escritura(View view){
        String bookData = book.getText().toString();
        String chapterData = chapter.getText().toString();
        String verseData = verse.getText().toString();

        Intent intent = new Intent(this, Screen.class);
        intent.putExtra("bookData", bookData);
        intent.putExtra("chapterData", chapterData);
        intent.putExtra("verseData", verseData);

        startActivity(intent);


    }
}