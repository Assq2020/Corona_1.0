package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
//        addNOtification();


    }

    public void addNOtification() {
        NotificationCompat.Builder builder=
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.iconn)
                .setContentTitle("Notification aaya aaya aaaya")
                .setContentText("Intent to self Assesment ");
        Intent notification=new Intent(this,Assessment.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,notification,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
