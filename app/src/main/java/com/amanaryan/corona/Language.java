package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.amanaryan.translateapi.TranslateAPI;

public class Language extends AppCompatActivity {
ConstraintLayout poster;
    static final int time=5000;
    static final int time2=4500;
static String ChooseLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
poster=findViewById(R.id.poster);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
poster.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(),login.class));


            }
        },time);

    }

    private void godown() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },time2);

    }

}
