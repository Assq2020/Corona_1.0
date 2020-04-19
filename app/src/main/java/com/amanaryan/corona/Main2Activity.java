package com.amanaryan.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

ConstraintLayout healthStatusCard;
String cardcolor;
TextView status,percentText,advice;
double percent;
   String namee,state,city;
    double latitude = 0;
    double longitude = 0;
    private LocationManager locationManager;
    private LocationListener locationListener, llocationListener;
    double userLatitude, userGpslati;
    double userLongitude, userGpslongi;
    private static final int My_permission_request_code = 1;
boolean gpsint_value;
    int healthstatus=0;
    TextView email,name,age,aadhar_no,mobile_no,address,phh,pth;
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
        name= findViewById(R.id.profile_name);
        age= findViewById(R.id.profile_age);
        aadhar_no= findViewById(R.id.profile_aadhar);
        mobile_no= findViewById(R.id.profile_mobile);
        address= findViewById(R.id.profile_add);
        phh= findViewById(R.id.profile_phh);
        pth= findViewById(R.id.profile_pth);
        email= findViewById(R.id.profile_email);
        requireddata();



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

            getGPSLocation();
        }
        else if(cardcolor.equals("Red")){
            healthStatusCard.setBackgroundResource(R.drawable.redcardd);
//            status.setText("You urgently need Medical Attention.It looks Like You get affected");
//            advice.setText("Wear Mask regularly and put tissue while sneezing, try for quarantine and do not touch your eyes,nose and mouth without sanetizing");
            getGPSLocation();
        }
    }


    public void getGPSLocation() {



        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userGpslongi = location.getLongitude();
                userGpslati = location.getLatitude();
                sendGPSLocation();

                Toast.makeText(Main2Activity.this, "GPS send", Toast.LENGTH_SHORT).show();

                Toast.makeText(Main2Activity.this, "GPS send" + userGpslati + " " + userGpslongi, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
//                Toast.makeText(MainActivity.this, "gps On", Toast.LENGTH_SHORT).show();
////
                gpsint_value=false;
            }

            @Override
            public void onProviderDisabled(String provider) {

                Toast.makeText(Main2Activity.this, "gps OFFFFFFFFF", Toast.LENGTH_SHORT).show();
                TurnonGps();
                gpsint_value=true;

            }
        };llocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userLongitude = location.getLongitude();
                userLatitude = location.getLatitude();

                Toast.makeText(Main2Activity.this, "NETWORK send", Toast.LENGTH_SHORT).show();
                Toast.makeText(Main2Activity.this, "NETWORK send"+userLongitude+" "+userLatitude, Toast.LENGTH_SHORT).show();

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

    private void requireddata() {

        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
        conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age varchar,sex varchar,mobile varchar,email varchar," +
                "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
                "cardcolor varchar,percentage varchar,dvist varchar,startdate int,enddate int,puredate varchar);");
//0 to 19

        Cursor c= conn.rawQuery("select * from detail",null);


        if(c.moveToFirst()){
            namee =c.getString(0);
            state = c.getString(7);
            city = c.getString(8);
            name.setText(c.getString(0));
            aadhar_no.setText(c.getString(1));

            age.setText(c.getString(2));
            mobile_no.setText(c.getString(4));

            email.setText(c.getString(5));
            phh.setText(c.getString(10));
            pth.setText(c.getString(11));
            address.setText(c.getString(9));

        }




    }


    public void configure() {


        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED){
            Toast.makeText(Main2Activity.this, "Permission", Toast.LENGTH_SHORT).show();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, llocationListener);

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
    private void sendGPSLocation() {
longitude=userGpslongi;
latitude=userGpslati;
upload();
    }


    private void sendNetworklocation() {
        if(gpsint_value){
longitude=userLongitude;
latitude=userLatitude;
upload();
        }

}

    private void upload() {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference("Data/"+state+"/"+city+"/"+cardcolor);

            final Savegps value = new Savegps(longitude,latitude);


            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    myRef.child(namee).child("Location").setValue(value);
                    Toast.makeText(Main2Activity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Main2Activity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            });


        }catch (Exception e){
            Toast.makeText(this,"NOt Uploaded :"+e,Toast.LENGTH_LONG).show();
        }

    }
}
