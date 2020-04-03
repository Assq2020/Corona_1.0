package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amanaryan.translateapi.TranslateAPI;

public class Language extends AppCompatActivity {
    ConstraintLayout poster;
    static final int time = 5000;
    static final int time2 = 4500;
    static String pnumber;
    static String ChooseLanguage;
String yes="YES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        poster = findViewById(R.id.poster);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        poster.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                checklogin();
            }
        },time2);
    }


    private void checklogin() {


        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
        conn.execSQL("create table if not exists Login(user varchar,RegisteredPhNumber Int);");

        Cursor c = conn.rawQuery("select * from Login where user="+"'"+yes+"'"+"", null);
        if (c.moveToFirst()) {
            pnumber = c.getString(1);
            Toast.makeText(Language.this, " checked", Toast.LENGTH_LONG).show();

            Intent i = new Intent(Language.this, MainActivity.class);
            startActivity(i);

        } else {
            Toast.makeText(Language.this, " unchecked", Toast.LENGTH_LONG).show();

            Intent i = new Intent(Language.this,login.class);
            startActivity(i);


        }
    }


}

//
//    private void LoggedInNotCheck() {
//
//
//        SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
//        conn.execSQL("create table if not exists Login(user varchar,RegisteredPhNumber Int);");
//
//
//        Cursor c= conn.rawQuery("select * from Login where user='YES'",null);
//
//
//        if(c.moveToFirst()){
////static string phnumber
//            pnumber=c.getString(1);
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
//
//
//                }
//            },time);
//
//
//        }else{
////            if user is not logged in then
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//
//                    startActivity(new Intent(getApplicationContext(),login.class));
//
//
//                }
//            },time);
//        }
//
//
//
//
//    }

