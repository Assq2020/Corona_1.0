package com.amanaryan.corona;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


//public class Datareadjavafile extends Main2Activity {
//    public String readName() {
//        String Name=null;
//        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
//        conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age varchar,sex varchar,mobile varchar,email varchar," +
//                "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
//                "cardcolor varchar,percentage varchar,dvist varchar,startdate int,enddate int,puredate varchar);");
////0 to 19
//
//        Cursor c = conn.rawQuery("select * from detail", null);
//
//
//        if (c.moveToFirst()) {
//            Name = c.getString(0);
//
//        }
//        return(Name) ;
//    }
//}