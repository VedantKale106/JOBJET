package com.example.booker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StudentInfo extends AppCompatActivity {
    Button book;

    TextView tname;
    ImageView timage;
    TextView tage;
    TextView tskills;
    TextView trate;
    TextView tlocation;
    TextView tdesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        tname = findViewById(R.id.student_name);
        timage = findViewById(R.id.student_img);
        tage = findViewById(R.id.student_age);
        tskills = findViewById(R.id.student_skills);
        trate = findViewById(R.id.student_rate);
        tlocation = findViewById(R.id.student_location);
        tdesc = findViewById(R.id.student_description);
        book = findViewById(R.id.contact);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image",0);
        int age = intent.getIntExtra("age",0);
        int rate = intent.getIntExtra("rates",0);
        String skill = intent.getStringExtra("skill");
        String location = intent.getStringExtra("location");
        String description = intent.getStringExtra("Description");
        String phone = intent.getStringExtra("phone");
        tname.setText(name);
        timage.setImageResource(image);
        tage.setText(age+" Years");
        tskills.setText(skill);
        trate.setText(rate+" Rs/Hr");
        tlocation.setText(location);
        tdesc.setText(description);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(StudentInfo.this, "BC!!! Paise ahet ka !!!", Toast.LENGTH_SHORT).show();
                 String url = ("https://wa.me/+91"+phone+"?text=Hi "+name+", Would you like to work for me as a Freelancer ?");
                 Intent intent = new Intent(Intent.ACTION_VIEW);
                 intent.setData(Uri.parse(url));
                 startActivity(intent);

            }
        });






    }
}