package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout home,tips;
    TextView homeInactive,homeActive,tipsInactive,tipsActive;
    ImageView profilebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFlipper viewFlipper=(ViewFlipper)findViewById(R.id.flipper);

        viewFlipper.setFlipInterval(3500);

        viewFlipper.setAutoStart(true);

        home=(ConstraintLayout)findViewById(R.id.homeid);
        tips=(ConstraintLayout)findViewById(R.id.constraintLayout);
profilebtn=(ImageView)findViewById(R.id.profilebutton);
        tips.setVisibility(View.GONE);

        homeInactive=findViewById(R.id.homeinactive);
        homeActive=findViewById(R.id.homeactive);
        tipsInactive=findViewById(R.id.tipsinactive);
        tipsActive=findViewById(R.id.tipsactive);

        homeInactive.setVisibility(View.GONE);
        tipsActive.setVisibility(View.GONE);

        homeInactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActive.setVisibility(View.VISIBLE);
                homeInactive.setVisibility(View.GONE);
                tipsInactive.setVisibility(View.VISIBLE);
                tipsActive.setVisibility(View.GONE);
                home.setVisibility(View.VISIBLE);
            tips.setVisibility(View.GONE);
            }
        });
        tipsInactive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActive.setVisibility(View.GONE);
                homeInactive.setVisibility(View.VISIBLE);
                tipsInactive.setVisibility(View.GONE);
                tipsActive.setVisibility(View.VISIBLE);
                home.setVisibility(View.GONE);
                tips.setVisibility(View.VISIBLE);

            }
        });

profilebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }
});
    }
}
