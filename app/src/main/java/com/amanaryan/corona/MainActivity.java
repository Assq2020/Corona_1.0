package com.amanaryan.corona;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.amanaryan.corona.newsbox.Newslist;
import com.amanaryan.translateapi.TranslateAPI;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.amanaryan.corona.Language.ChooseLanguage;

public class MainActivity extends AppCompatActivity {
    String healthcolor;
    ConstraintLayout home, tips;
    TextView homeInactive, homeActive, tipsInactive, tipsActive;
    ImageView profilebtn;
    CardView RestrtictedArea, Doctors, Foodshops,Assessment,emergency,news,suspect,contactus;
    TextView A, B, C, D, E, F, G, h;
    //Tips Activity
    CardView Wcorona, Symptoms, transmitted, prevent, Mask, Treatment, Travel, fakenews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emergency=findViewById(R.id.emergencyy);
        news=findViewById(R.id.news);
        suspect=findViewById(R.id.suspect);
        contactus=findViewById(R.id.contactus);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Emergency.class));
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Newslist.class));
                //Toast.makeText(MainActivity.this, "We are working on it", Toast.LENGTH_SHORT).show();
            }
        });

        suspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Are you sure?")
                        .setMessage("Be careful..! If you found blaming somebody then, authorities will take action on you. But don't worry if u are right just click OK and help us fight COVID-19")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Suspect.class));
                            }
                        }).setNegativeButton("CANCEL",null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Contactus.class));
                //Toast.makeText(MainActivity.this, "We are working on it", Toast.LENGTH_SHORT).show();
            }
        });



        Assessment=findViewById(R.id.Assessment);
        Assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.amanaryan.corona.Assessment.class));
            }
        });
        //Tips ActivityStart
        checkhealth();

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String date = sdf.format(new Date());
       // int endMONTH=(date.charAt(3)*10)+date.charAt(4);

     //   Toast.makeText(this, "hi "+endMONTH+"  "+date, Toast.LENGTH_LONG).show();
        Wcorona = findViewById(R.id.what_is_Coronavirus);
        Symptoms = findViewById(R.id.What_are_symptoms);
        transmitted = findViewById(R.id.How_it_is_transmitted);
        prevent = findViewById(R.id.How_to_prevent_it);
        Mask = findViewById(R.id.When_to_wear_mask);
        Treatment = findViewById(R.id.Is_ther_is_anyTreatment);
        Travel = findViewById(R.id.Information_for_travelers);
        fakenews = findViewById(R.id.Fake_News);
        final Intent iTips = new Intent(getApplicationContext(), tipsDescribe.class);
        Wcorona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "corona");
                startActivity(iTips);
            }
        });
        Symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "symptoms");
                startActivity(iTips);
            }
        });
        prevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "prevent");
                startActivity(iTips);
            }
        });
        transmitted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "transmitted");
                startActivity(iTips);
            }
        });
        Mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "mask");
                startActivity(iTips);
            }
        });
        Treatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "treatment");
                startActivity(iTips);
            }
        });
        Travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "travel");
                startActivity(iTips);
            }
        });
        fakenews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTips.putExtra("Tips", "fakenews");
                startActivity(iTips);
            }
        });

        ///Tips ACtivity End


        A = findViewById(R.id.DoctorsTXT);
        //  ChangeLanguage();
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.flipper);

        viewFlipper.setFlipInterval(3000);

        viewFlipper.setAutoStart(true);

        home = (ConstraintLayout) findViewById(R.id.homeid);
        tips = (ConstraintLayout) findViewById(R.id.constraintLayout);
        profilebtn = (ImageView) findViewById(R.id.profilebutton);
        tips.setVisibility(View.GONE);

        homeInactive = findViewById(R.id.homeinactive);
        homeActive = findViewById(R.id.homeactive);
        tipsInactive = findViewById(R.id.tipsinactive);
        tipsActive = findViewById(R.id.tipsactive);

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
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });


// GRID cardview buttons
        final String restrictedLink = "https://www.google.com/maps/d/u/0/viewer?mid=1I4dZH44NltkCEtIjMCm9QciaBCAXxHKq&ll=23.36857260546297%2C85.3152203881101&z=13";
        final String DoctorsLink = "https://www.google.com/maps/d/u/0/viewer?mid=1DkHZ1D-VlhejI4Er_Y7K6MLp1XKiS0eG&ll=23.368235782127368%2C85.25083094640343&z=16";
        final String FoodstoreLink = "https://www.google.com/maps/d/u/0/viewer?mid=1pyQCZCaoehmaRyhowRF1T_lAi2POO9MB&ll=23.381919000000014%2C85.29965149999998&z=17";

        RestrtictedArea = (CardView) findViewById(R.id.RestrictedAreaid);
        RestrtictedArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webView.class);
                intent.putExtra("link", restrictedLink);
                startActivity(intent);
            }
        });


        Doctors = (CardView) findViewById(R.id.doctorsId);
        Doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webView.class);
                intent.putExtra("link", DoctorsLink);
                startActivity(intent);
            }
        });


        Foodshops = (CardView) findViewById(R.id.foodshopId);
        Foodshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webView.class);
                intent.putExtra("link", FoodstoreLink);
                startActivity(intent);
            }
        });


    }

    private void checkhealth() {

        SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
     //   conn.execSQL("create table if not exists cardcolor(name varchar,age int,mobile int,aadhar varchar,address varchar,phealthissue varchar,ptraveldetail,color varchar,startdate varchar,enddate varchar);");
//0 to 9
        conn.execSQL("create table if not exists cardcolor(color varchar,percent varchar);");
//0 to 9
       // Cursor c= conn.rawQuery("select * from cardcolor where color= 'yellow' or color='red'",null);
                Cursor c= conn.rawQuery("select * from cardcolor" ,null);
        //
        if(c.moveToFirst()){
            healthcolor=c.getString(0);
//            String enddate=c.getString(9);
//            int endMONTH=(enddate.charAt(3)*10)+enddate.charAt(4);
//            int enddd=(enddate.charAt(0)*10)+enddate.charAt(1);
//            @SuppressLint("SimpleDateFormat")
//            SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
//            String date=sdf.format(new Date());
//            int todaymonth=(date.charAt(3)*10)+date.charAt(4);
//            int todaydd=(date.charAt(0)*10)+date.charAt(1);
//            if(endMONTH==todaymonth){
//            if(enddd<=todaydd){
//                recheck and update color of card
            }

         else{
//            intent to selfAssessment

        }





        //
//    private void ChangeLanguage() {
//
//        TranslateAPI translateAPI=new TranslateAPI(
//                com.amanaryan.translateapi.Language.ENGLISH, ChooseLanguage,"Your Text"
//        );
//        translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
//            @Override
//            public void onSuccess(String translatedText) {
//                A.setText(translatedText);
//            }
//
//            @Override
//            public void onFailure(String ErrorText) {
//                Toast.makeText(MainActivity.this, "Failed to Convert Lnaguage", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
// }


}}
