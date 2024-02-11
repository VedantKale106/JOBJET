package com.example.booker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddFreelancer extends AppCompatActivity {

    EditText username ;
    EditText fullname ;
    EditText skill ;
    EditText location ;
    EditText age ;
    EditText phone ;
    EditText rate ;
    EditText description ;
    Button add ;
    Button view ;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_freelancer);
        username = findViewById(R.id.user);
        fullname = findViewById(R.id.name);
        skill = findViewById(R.id.skill);
        location = findViewById(R.id.location);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        rate = findViewById(R.id.rate);
        description = findViewById(R.id.description);
        add = findViewById(R.id.addfree);
        view = findViewById(R.id.show);
        database = new Database(AddFreelancer.this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iuser = username.getText().toString();
                String iname = fullname.getText().toString();
                String iskill = skill.getText().toString();
                String ilocation = location.getText().toString();
                //int iage = Integer.parseInt(age.getText().toString());
                //int iphone = Integer.parseInt(phone.getText().toString());
                int iage , iphone , irate;
                try
                {
                    iage= Integer.parseInt(age.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                    iage=0;
                }
                try
                {
                    irate= Integer.parseInt(rate.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                    irate=0;
                }
                try
                {
                    iphone= Integer.parseInt(phone.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                    iphone=0;
                }
                String idescription = description.getText().toString();
                Freelancer free = new Freelancer(iuser , iname, iskill, ilocation,iage , iphone, idescription ,irate);

                if (iuser.isEmpty() && iname.isEmpty() && iskill.isEmpty() && ilocation.isEmpty() && idescription.isEmpty()){
                    Toast.makeText(AddFreelancer.this, "Please, Enter all the data", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddFreelancer.this, "Freelancer Created", Toast.LENGTH_SHORT).show();
                    database.addFreelancer(free);
                    username.setText("");
                    fullname.setText("");
                    skill.setText("");
                    location.setText("");
                    age.setText("");
                    rate.setText("");
                    phone.setText("");
                    description.setText("");
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFreelancer.this , Display.class);
                startActivity(intent);
            }
        });




    }
}