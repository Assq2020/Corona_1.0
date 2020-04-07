package com.amanaryan.corona;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class notification extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    protected void onStart() {

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

        super.onStart();

    }
}
