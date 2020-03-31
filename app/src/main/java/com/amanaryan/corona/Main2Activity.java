package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

ConstraintLayout healthStatusCard;
String cardcolor;
TextView status,percentText,advice;
double percent;
    int healthstatus=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        advice=findViewById(R.id.advice);
        setContentView(R.layout.activity_main2);
status=findViewById(R.id.cardstatusText);
percentText=findViewById(R.id.Textpercent);
        healthStatusCard=findViewById(R.id.healthStatustLayout);
        healthStatusCard.setBackgroundResource(R.drawable.profilecard );
        healthStatusCard.setBackgroundResource(R.drawable.greencard);
        check_cardFunction();





    }

    @SuppressLint("SetTextI18n")
    private void check_cardFunction() {

        SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
        conn.execSQL("create table if not exists cardcolor(color varchar,percent varchar);");

        Cursor c= conn.rawQuery("select * from cardcolor",null);


        if(c.moveToFirst()){
            cardcolor=c.getString(0);
            percent= c.getDouble(1);
        updatecolor();

        }else{
            Toast.makeText(this, "Perform SelfAssessment Test to check your status", Toast.LENGTH_LONG).show();
        }

    }

    @SuppressLint("SetTextI18n")
    private void updatecolor() {
        percentText.setText(percent+"%");
        if(cardcolor.equals("Green")){

            healthStatusCard.setBackgroundResource(R.drawable.greencard);
//            status.setText("Good to see you healthy");
//            advice.setText("Wear Mask and wash your hands for min 20sec.");
        }

        else if(cardcolor.equals("Yellow")){

            healthStatusCard.setBackgroundResource(R.drawable.yellowcard);
//            status.setText("It seems you may get affected ,PLease Take care of yourself");
//            advice.setText("Wear Mask and put tissue while sneezing, try for social distancing and do not touch your eyes,nose and mouth without sanetizing");
            sendlocation();
        }
        else if(cardcolor.equals("Red")){
            healthStatusCard.setBackgroundResource(R.drawable.redcardd);
//            status.setText("You urgently need Medical Attention.It looks Like You get affected");
//            advice.setText("Wear Mask regularly and put tissue while sneezing, try for quarantine and do not touch your eyes,nose and mouth without sanetizing");
            sendlocation();
        }
    }

    private void sendlocation() {


        Toast.makeText(this, "sending your location", Toast.LENGTH_SHORT).show();
    }
}
