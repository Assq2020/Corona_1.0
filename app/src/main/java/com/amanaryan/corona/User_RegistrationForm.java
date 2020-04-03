package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class User_RegistrationForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__registration_form);

        String mobileNumber=getIntent().getExtras().getString("phnumber");
//create db in cardcolor
        //by default start end pure date 0 se initialise hohga



        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

public void create_User_DB(){
    String name="";
    int aadhar=0;
    int age=0;
    String sex="";
    int mobile=0;
    String email="";
    String occupation="";
    String state="";
    String city="";
    String address="";
    String healthhistory="";
    String travelhistory="";
    String latitude="";
    String longitude="";
    String cardcolor="";
    String percentage="";
    String dvisit="";
    String startdate="";
    String enddate="";
    String puredate="";


    SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
    conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age int,sex varchar,mobile int,email varchar," +
            "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
            "cardcolr varchar,percentage varchar,dvist varchar,startdate varchar,enddate varchar,puredate varchar);");
//0 to 19


        conn.execSQL("insert into detail values("+"'"+name+"'"+","+"'"+aadhar+"'"+","+"'"+age+"'"+","+"'"+sex+"'"+","+"'"+mobile+"'"+","+"'"+sex+"'"+","+"'"+sex+"'"+","+"'"+sex+"'"+","+"'"+sex+"'"+");");
        Toast.makeText(User_RegistrationForm.this, " Data Saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));



}

}
