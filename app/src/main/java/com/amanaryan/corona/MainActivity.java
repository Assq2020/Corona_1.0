package com.amanaryan.corona;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.amanaryan.corona.newsbox.Newslist;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.amanaryan.corona.Language.ChooseLanguage;

public class MainActivity extends AppCompatActivity {
    String healthcolor;
    ConstraintLayout home, tips;
    TextView homeInactive, homeActive, tipsInactive, tipsActive;
    ImageView profilebtn;
    CardView RestrtictedArea, Doctors, Foodshops, Assessment, emergency, news, suspect, contactus;
    TextView A, B, C, D, E, F, G, h;
    //Tips Activity
    CardView Wcorona, Symptoms, transmitted, prevent, Mask, Treatment, Travel, fakenews;
    private LocationManager locationManager;
    private LocationListener locationListener,llocationListener;
    double userLatitude,userGpslati;
    double userLongitude,userGpslongi;
    private static final int My_permission_request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emergency = findViewById(R.id.emergencyy);
        news = findViewById(R.id.news);
        suspect = findViewById(R.id.suspect);
        contactus = findViewById(R.id.contactus);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmergencySection.class));
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    startActivity(new Intent(getApplicationContext(), Newslist.class));        }
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
                alertDialog.show();
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Contactus.class));
            }
        });


        Assessment = findViewById(R.id.Assessment);
        final int enddate=20,startdate=8;
        //end date sqldb se niklna h start date v

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdfD=new SimpleDateFormat("dd");
        final int date= Integer.parseInt(sdfD.format(new Date()));
        Assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(date==enddate || date<startdate|| enddate<date ){
                    startActivity(new Intent(getApplicationContext(), com.amanaryan.corona.Assessment.class));}else{
                   int sub= enddate-date;
                    Toast.makeText(MainActivity.this, "You can Access this after "+sub+" Days", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Tips ActivityStart
        checkhealth();

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

    @SuppressLint("ShowToast")
    private void checkhealth() {

        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
        //   conn.execSQL("create table if not exists cardcolor(name varchar,age int,mobile int,aadhar varchar,address varchar,phealthissue varchar,ptraveldetail,color varchar,startdate varchar,enddate varchar);");
//0 to 9
        conn.execSQL("create table if not exists cardcolor(color varchar,percent varchar);");
//0 to 9
        // Cursor c= conn.rawQuery("select * from cardcolor where color= 'yellow' or color='red'",null);
        Cursor c = conn.rawQuery("select * from cardcolor", null);
        //
        if (c.moveToFirst()) {
            healthcolor = c.getString(0);
//            String enddate=c.getString(9);
//            int endMONTH=(enddate.charAt(3)*10)+enddate.charAt(4);
//            int enddd=(enddate.charAt(0)*10)+enddate.charAt(1);



//            int todaymonth=(date.charAt(3)*10)+date.charAt(4);
//            int todaydd=(date.charAt(0)*10)+date.charAt(1);
//            if(endMONTH==todaymonth){
//            if(enddd<=todaydd){
//                recheck and update color of card
if (healthcolor.equals("Yellow") || healthcolor.equals("Red")){


    getGPSLocation();
}

        } else {
            please_move_selfAssingment();
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


    }

    public void getGPSLocation() {
// new Aboutus().toast();


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userGpslongi= location.getLongitude();
                userGpslati= location.getLatitude();
                sendGPSLocation();

                Toast.makeText(MainActivity.this, "GPS send", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "GPS send"+userGpslati+" "+userGpslongi, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
//                Toast.makeText(MainActivity.this, "gps On", Toast.LENGTH_SHORT).show();
////
            }

            @Override
            public void onProviderDisabled(String provider) {

                Toast.makeText(MainActivity.this, "gps OFFFFFFFFF", Toast.LENGTH_SHORT).show();
                TurnonGps();

            }
        };llocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userLongitude = location.getLongitude();
                userLatitude = location.getLatitude();

                Toast.makeText(MainActivity.this, "NETWORK send", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "NETWORK send"+userLongitude+" "+userLatitude, Toast.LENGTH_SHORT).show();

                sendNetworklocation();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        };
        configure();

       //end of sendGPS method
    }


    public void configure() {


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this, "Permission", Toast.LENGTH_SHORT).show();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,3000,0,llocationListener);
    }


    public void TurnonGps() {
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.customtoastLayoutId));

        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        toast.show();

    }
    public void please_move_selfAssingment(){
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.self_toast,(ViewGroup)findViewById(R.id.plsselfassesment));

        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        toast.show();


    }

    private void sendGPSLocation() {

    }

    private void sendNetworklocation() {
    }

}


