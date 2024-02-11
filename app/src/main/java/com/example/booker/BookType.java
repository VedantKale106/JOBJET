package com.example.booker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class BookType extends AppCompatActivity {

    Button std_book;
    Button programming;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_type);
        std_book=findViewById(R.id.student);
        programming=findViewById(R.id.programming);



        std_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentBook = new Intent(BookType.this, StudentBook.class);
                startActivity(studentBook);
            }
        });
        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent programming = new Intent(BookType.this, Programming.class);
                startActivity(programming);
            }
        });





    }


}