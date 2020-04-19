package com.amanaryan.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.amanaryan.corona.newsbox.Newslist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Suspect extends AppCompatActivity {
    private EditText name,age,address,relation,phone_no,other_mode,doubt;
    private RadioGroup gender;
    private Button submit;
String nname="NO ",aage="NO ",aaddress="NO ",rrealtion="NO ",pphone="NO ",oother="NO ",ddoubt="NO ",uname="NO ",ustate="NO ",ucity="NO ",uph="NO ";
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
        requireddata();

//        //setting Onclick listener to submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nname=name.getText().toString();
                aage=age.getText().toString();
                aaddress=address.getText().toString();
                rrealtion=relation.getText().toString();
                pphone=phone_no.getText().toString();
                oother=other_mode.getText().toString();
                ddoubt=doubt.getText().toString();
                upload();

                Toast.makeText(Suspect.this, "DATA SAVED    Thanks for your help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });


    }

    private void requireddata() {




            SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
            conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age varchar,sex varchar,mobile varchar,email varchar," +
                    "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
                    "cardcolor varchar,percentage varchar,dvist varchar,startdate int,enddate int,puredate varchar);");
//0 to 19

            Cursor c= conn.rawQuery("select * from detail",null);


            if(c.moveToFirst()){
                uname =c.getString(0);
                ustate = c.getString(7);
                ucity = c.getString(8);
    uph=c.getString(4);
            }




        }

    private void upload() {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference("Suspect/"+ustate+"/"+ucity+"/"+uname);

            final Savesuspect value = new Savesuspect(nname,aage,aaddress,rrealtion,pphone,oother,ddoubt,uname,uph);


            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    myRef.child(nname).setValue(value);
                    Toast.makeText(Suspect.this, "Uploaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Suspect.this, "Error", Toast.LENGTH_SHORT).show();

                }
            });


        }catch (Exception e){
            Toast.makeText(this,"NOt Uploaded :"+e,Toast.LENGTH_LONG).show();
        }
        Toast.makeText(Suspect.this, "DATA SAVED    Thanks for your help", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

}
