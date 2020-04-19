package com.amanaryan.corona;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Service extends JobService {
    private boolean jobcancled=false;
    private boolean checkgps=true;
    LocationListener llocationListener;
    LocationManager locationManager ;
    LocationListener locationListener;
    double userLatitude,userGpslati;
    double userLongitude,userGpslongi;

        @Override
    public boolean onStartJob(JobParameters params) {
        backgroundWork(params);
        return true;
    }

    private void backgroundWork( final JobParameters params) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            getGPSLocation();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
    }

//    private void getlocation() {
//
//    //location uthana h and firebase me send krna h
//        Toast.makeText(Service.this, "B ayga ayga", Toast.LENGTH_LONG).show();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(Service.this, "Background aaya aaya aaya aaya", Toast.LENGTH_LONG).show();
//            }
//        },3000);
//
//    }

    @Override
    public boolean onStopJob(JobParameters params) {
        jobcancled=true;
        return true;
    }






    public void getGPSLocation() {
// new Aboutus().toast();


        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userGpslongi = location.getLongitude();
                userGpslati = location.getLatitude();
                sendGPSLocation();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
//                Toast.makeText(MainActivity.this, "gps On", Toast.LENGTH_SHORT).show();
////
  checkgps=true;
            }

            @Override
            public void onProviderDisabled(String provider) {
checkgps=false;

            }
        };
         llocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                userGpslongi = location.getLongitude();
                userGpslati = location.getLatitude();


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



            return;
        }
        if(checkgps){

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,locationListener);

        }else{locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,3000,0,llocationListener);
        }

        }



    private void sendGPSLocation()  {
//        firebase
System.out.println("Gps chnage");

    }

    private void sendNetworklocation(){

        System.out.println("Network chnage");

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this).setContentTitle("Gps h ye").setContentText("your location sended");

        Intent noti=new Intent(this,MainActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,noti,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
        }
}
