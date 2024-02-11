package com.example.booker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Programming extends AppCompatActivity {
    ListView listView;
    //DATA START
    static int count = 8 ;
    public String names[] = { "Vedant Kale", "Shubham Kathole",
            "Prathamesh Dudhale", "Gaurav Jagtap",
            "Aaditesh Kadu", "Rohan Kadam",
            "Tejas Borhade", "Ayush Kashid",
            "Krishna Nepthe","Aditya Joshi","Yash Dongare","Sandesh Katkar","Nayan Keote","Satyam Karn","Harshal Ingale" ,"Vishwajeet Shinde", "Maheshwar Kadbane","Parth Sarap"};
    public int images[]
            ={R.drawable.vedantkale , R.drawable.shubhamkathole ,
            R.drawable.prathameshdudhale ,R.drawable.gauravjagtap ,R.drawable.aadikadu ,R.drawable.rohan ,R.drawable.tejasboradhe ,R.drawable.ayushkashid ,R.drawable.krishnanepthe, R.drawable.adityajoshi,R.drawable.nopic,R.drawable.sandeshkatkar,R.drawable.nayankeote,R.drawable.satyamkarn,R.drawable.harshalingale,R.drawable.nopic,R.drawable.maheshkadbane,R.drawable.parthsarap};
    public int rates[] = { 200, 350,
            325, 500,
            400, 350,
            250, 300,
            300,250,350,250,300 ,275,250,300,350,69};
    public String skills[] = { "Android Studio, Editing", "Flutter, Web Development, Android Studio",
            "C, C++, Web Development, Badminton", "C++,Rust,SQL,DSA,MERN,Leadership,Arduino,Remote Sensing,BlogWriting",
            "Figma, Flutter, Android Studio", "Java, DSA, Basic Programming",
            "C, C++, Python, OOP, DSA", "Football, Kabbadi, Athletics",
            "C, C++, DSA, Java, Mathematics" ,"Photography, Basics of Programming, DSA","SQL,Flutter,Figma,Cybersecurity,React,Hacking","Dancing , Driving, Mathematics","C, c++, DSA, Java","Coding , Rapping, Videography","Cricket, C++, Java, DSA","Cricket, Volleyball, DSA, C++, Java, Electronics","Kabbadi, Video Editing, Photoshop","Marketing, Strategist, Leadership, Web development"};
    public String location[] = { "Junnar", "Akola",
            "Latur", "Jalgaon",
            "Pune", "Washim",
            "Junnar", "Nashik",
            "Tuljapur" ,"Parbhani","pune","Nagar","Yavatmal","Nepal","Pune","Sangli","Latur","Dapoli"};
    public String Description[] = { "Hi, I am Vedant Kale", "Hi, I am Shubham Kathole",
            "Hi, I am Prathamesh Dudhale", "Hi, I am Gaurav Jagtap",
            "Hi, I am Aaditesh Kadu", "Hi, I am Rohan Kadam",
            "Hi, I am Tejas Borhade", "Hi, I am Ayush Kashid",
            "Hi, I am Krishna Nepthe","Hi, I am Aditya Joshi!!" ,"Hi, I am Yash Dongare","Hi, I am Sandesh Katkar","Hi, I am Nayan Keote","Hi, I am Satyam Karn","Hi, I am Harshal Ingale","Hi, I am Vishwajeet Shinde","Hi, I am Mahesh Kadbane","Hi, I am DODO"};

    public int age[] = { 19, 20,
            20, 19,
            20, 19,
            19, 19,
            20 ,21,19,19,20,22,19,20,20,21};

    public String  phone[]={"8421204009","9423782588","7755972996","8983884819","8956662307","9322463943","7387899624","8805116108","9579286223","9975794145","8421204009","8605486178","8261014717","7292970227","7057535197","8421204009","8421204009","9373936017"};
    //DATA END

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_book);
        //LISTVIEW START
        listView = findViewById(R.id.listView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(Programming.this,names , images,rates);
        listView.setAdapter(customBaseAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected_student = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(Programming.this , StudentInfo.class);
                intent.putExtra("name" , names[position]);
                intent.putExtra("skill" , skills[position]);
                intent.putExtra("location" , location[position]);
                intent.putExtra("age" , age[position]);
                intent.putExtra("rates",rates[position]);
                intent.putExtra("image",images[position]);
                intent.putExtra("Description" , Description[position]);
                intent.putExtra("phone",phone[position]);
                startActivity(intent);
            }
        });

        //LISTVIEW END



}
}
