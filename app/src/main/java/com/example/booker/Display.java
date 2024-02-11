package com.example.booker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    private ArrayList<Freelancer> freelancers;
    private Database database;
    private FreeAdapter freeAdapter;
    private RecyclerView freelancerv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        freelancers = new ArrayList<>();
        database = new Database(Display.this);

        // getting our course array 
        // list from db handler class.
        freelancers = database.readFreelancers();

        // on below line passing our array list to our adapter class.
        freeAdapter = new FreeAdapter(freelancers, Display.this);
        freelancerv = findViewById(R.id.freelancerss);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Display.this, RecyclerView.VERTICAL, false);
        freelancerv.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        freelancerv.setAdapter(freeAdapter);
    }
}