package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.amanaryan.corona.newsbox.Newslist;

public class Suspect extends AppCompatActivity {
    private EditText name,age,address,relation,phone_no,other_mode,doubt;
    private RadioGroup gender;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspect);
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        address = (EditText)findViewById(R.id.address);
        relation = (EditText)findViewById(R.id.relation);
        phone_no = (EditText)findViewById(R.id.phoneno);
        other_mode = (EditText)findViewById(R.id.other_mode);
        doubt = (EditText)findViewById(R.id.doubt);
        gender = (RadioGroup)findViewById(R.id.gender);
        submit = (Button)findViewById(R.id.submit);
//        new notification();
//        //setting Onclick listener to submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Suspect.this, "DATA SAVED    Thanks for your help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });


    }
}
