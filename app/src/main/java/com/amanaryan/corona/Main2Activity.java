package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button green,yellow;
ConstraintLayout healthStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        green=findViewById(R.id.green);
        yellow=findViewById(R.id.yellow);

        healthStatus=findViewById(R.id.healthStatustLayout);
        healthStatus.setBackgroundResource(R.drawable.profilecard );

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                healthStatus.setBackgroundResource(R.drawable.greencard);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                healthStatus.setBackgroundResource(R.drawable.yellowcard);
            }
        });
    }
}
