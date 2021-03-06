package com.amanaryan.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Assessment extends AppCompatActivity {
    String health_card;
    String percentt;
double percent;

    String cardcolor;
    String namee =" No ";
    String aadharr = " No ";
    String age = " No ";
    String sex = " No ";
    String mobile = " No ";
    String emaill = " No ";
    String occupation = " No ";
    String state = " No ";
    String city = " No ";
    String addresss = " No ";
    String healthhistory = " No ";
    String travelhistory = " No ";
    String latitude = "";
    String longitude = "";
    String dvisit = "";
    String startdate = "";
    String enddate = "";
    String puredate = "";



    private EditText editText1;
    private Button start,button1,button2,button3,button4,button5,button6,button7,submit;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7;
    //    private RadioButton radioBut2,radioBut3;
    private RadioGroup radiodg2,radiodg3;
    //    private CheckBox checkb4a,checkb4b,checkb4c,checkb4d,checkb4e,checkb4f;
//    private CheckBox checkb5a,checkb5b,checkb5c,checkb5d,checkb5e,checkb5f;
//    private CheckBox checkb6a,checkb6b,checkb6c,checkb6d,checkb6e;
//    private CheckBox checkb7a,checkb7b,checkb7c,checkb7d,checkb7e,checkb7f,checkb7g;
    public int point=0;
    public int agee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

//sqldb se start or end date update kro 0 se


        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdfD=new SimpleDateFormat("dd");
        int date= Integer.parseInt(sdfD.format(new Date()));

        Toast.makeText(this, "Today's date :"+date, Toast.LENGTH_SHORT).show();




        //Assigning values
        editText1 = (EditText)findViewById(R.id.age);
        start = (Button)findViewById(R.id.startt);
        button1 = (Button)findViewById(R.id.q1ok);
        button2 = (Button)findViewById(R.id.q2ok);
        button3 = (Button)findViewById(R.id.q3ok);
        button4 = (Button)findViewById(R.id.q4ok);
        button5 = (Button)findViewById(R.id.q5ok);
        button6 = (Button)findViewById(R.id.q6ok);
        button7 = (Button)findViewById(R.id.q7ok);
        submit = (Button)findViewById(R.id.submitok);
        radiodg2 = (RadioGroup)findViewById(R.id.radio2);
        radiodg3 = (RadioGroup)findViewById(R.id.radio3);
//        checkb4a = (CheckBox)findViewById(R.id.cbq4a);
//        checkb4b = (CheckBox)findViewById(R.id.cbq4b);
//        checkb4c = (CheckBox)findViewById(R.id.cbq4c);
//        checkb4d = (CheckBox)findViewById(R.id.cbq4d);
//        checkb4e = (CheckBox)findViewById(R.id.cbq4e);
//        checkb4f = (CheckBox)findViewById(R.id.cbq4f);
//        checkb5a = (CheckBox)findViewById(R.id.cbq5a);
//        checkb5b = (CheckBox)findViewById(R.id.cbq5b);
//        checkb5c = (CheckBox)findViewById(R.id.cbq5c);
//        checkb5d = (CheckBox)findViewById(R.id.cbq5d);
//        checkb5e = (CheckBox)findViewById(R.id.cbq5e);
//        checkb5f = (CheckBox)findViewById(R.id.cbq5f);
//        checkb6a = (CheckBox)findViewById(R.id.cbq6a);
//        checkb6b = (CheckBox)findViewById(R.id.cbq6b);
//        checkb6c = (CheckBox)findViewById(R.id.cbq6c);
//        checkb6d = (CheckBox)findViewById(R.id.cbq6d);
//        checkb6e = (CheckBox)findViewById(R.id.cbq6e);
//        checkb7a = (CheckBox)findViewById(R.id.cbq7a);
//        checkb7b = (CheckBox)findViewById(R.id.cbq7b);
//        checkb7c = (CheckBox)findViewById(R.id.cbq7c);
//        checkb7d = (CheckBox)findViewById(R.id.cbq7d);
//        checkb7e = (CheckBox)findViewById(R.id.cbq7e);
//        checkb7f = (CheckBox)findViewById(R.id.cbq7f);
//        checkb7g = (CheckBox)findViewById(R.id.cbq7g);
        linearLayout1 = (LinearLayout)findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout)findViewById(R.id.ll2);
        linearLayout3 = (LinearLayout)findViewById(R.id.ll3);
        linearLayout4 = (LinearLayout)findViewById(R.id.ll4);
        linearLayout5 = (LinearLayout)findViewById(R.id.ll5);
        linearLayout6 = (LinearLayout)findViewById(R.id.ll6);
        linearLayout7 = (LinearLayout)findViewById(R.id.ll7);

        final String age =editText1.getText().toString();
        if ( null != age) {
            agee = Integer.parseInt(age);
        }

        //onclick listener to all next buttons
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.GONE);
                linearLayout1.setVisibility(View.VISIBLE);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.VISIBLE);
                if(agee<=30){
                    point++;
                }else if(agee>=31 && agee<60){
                    point+=2;
                }else{
                    point+=3;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.VISIBLE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setVisibility(View.GONE);
                linearLayout5.setVisibility(View.VISIBLE);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.VISIBLE);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.setVisibility(View.GONE);
                linearLayout7.setVisibility(View.VISIBLE);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button7.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                linearLayout4.setVisibility(View.GONE);
                linearLayout5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.GONE);
                linearLayout7.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                if (point<=5){
                    health_card="Green";
                    percent= point*6.5;
updatecolor();
                    Toast.makeText(Assessment.this, "You Are Completely Safe", Toast.LENGTH_LONG).show();

                }else if(point>5 && point<=11){

                    health_card="Yellow";
                    percent= point*6.5;
                    Toast.makeText(Assessment.this, "You Are At Low Risk", Toast.LENGTH_LONG).show();
sendlocation();
                }else{
                    health_card="Red";
                    percent= point*6.5;
                    Toast.makeText(Assessment.this, "You Are At High Risk", Toast.LENGTH_LONG).show();
                    sendlocation();
                }






























            }
        });


    }

    private void updatecolor() {
        SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
        conn.execSQL("create table if not exists cardcolor(color varchar,percent varchar);");

        Cursor c= conn.rawQuery("select * from cardcolor",null);


        if(c.moveToFirst()){


            conn.execSQL("UPDATE  cardcolor  SET color="+"'"+health_card+"'"+",percent="+"'"+percent+"'"+"");
            Toast.makeText(Assessment.this, " Updated", Toast.LENGTH_SHORT).show();


        }else{
            //  conn.execSQL("create table if not exists cardcolor(name varchar,age int,mobile int,aadhar varchar,address varchar,phealthissue varchar,ptraveldetail,color varchar,startdate varchar,enddate varchar);");
//0 to 9

            conn.execSQL("insert into cardcolor values("+"'"+health_card+"'"+","+"'"+percent+"'"+");");
            Toast.makeText(Assessment.this, " Data Saved", Toast.LENGTH_SHORT).show();

        }


    }

    public void rb4(View view) {
        int radio4Id = radiodg2.getCheckedRadioButtonId();
        switch (radio4Id){
            case R.id.radio2a:
                point++;
                break;
            case R.id.radio2b:
                point++;
                break;
            case R.id.radio2c:
                point++;
                break;
        }
    }

    public void rb5(View view) {
        int radio5Id = radiodg3.getCheckedRadioButtonId();
        switch (radio5Id){
            case R.id.radio3a:
                point++;
                break;
            case R.id.radio3b:
                point+=2;
                break;
            case R.id.radio3c:
                point+=3;
                break;
        }
    }


    public void cb4(View view) {
        boolean checked4 = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbq4a:
                if(checked4)
                    point++;
                break;
            case R.id.cbq4b:
                if(checked4)
                    point++;
                break;
            case R.id.cbq4c:
                if(checked4)
                    point++;
                break;
            case R.id.cbq4d:
                if(checked4)
                    point++;
                break;
            case R.id.cbq4e:
                if(checked4)
                    point++;
                break;
        }
    }

    public void cb5(View view) {
        boolean checked5 = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbq5a:
                if(checked5)
                    point+=2;
                break;
            case R.id.cbq5b:
                if(checked5)
                    point+=2;
                break;
            case R.id.cbq5c:
                if(checked5)
                    point+=2;
                break;
            case R.id.cbq5d:
                if(checked5)
                    point+=2;
                break;
            case R.id.cbq5e:
                if(checked5)
                    point+=2;
                break;
        }
    }
    public void cb6(View view) {
        boolean checked6 = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbq6a:
                if(checked6)
                    point+=2;
                break;
            case R.id.cbq6b:
                if(checked6)
                    point+=2;
                break;
            case R.id.cbq6c:
                if(checked6)
                    point+=3;
                break;
            case R.id.cbq6d:
                if(checked6)
                    point+=3;
                break;
        }
    }
    public void cb7(View view) {
        boolean checked7 = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbq7a:
                if(checked7)
                    point+=2;
                break;
            case R.id.cbq7b:
                if(checked7)
                    point+=2;
                break;
            case R.id.cbq7c:
                if(checked7)
                    point+=2;
                break;
            case R.id.cbq7d:
                if(checked7)
                    point+=2;
                break;
            case R.id.cbq7e:
                if(checked7)
                    point+=2;
                break;
            case R.id.cbq7f:
                if(checked7)
                    point+=2;
                break;
        }
    }


    private void sendlocation() {
        updatecolor();

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdfD = new SimpleDateFormat("dd");
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        final int ddate =0;// Integer.parseInt(sdf.format(new Date()));
        final int sdate = Integer.parseInt(sdfD.format(new Date()));
        int endddate=sdate+14;
        if(endddate>30){endddate=endddate-30;}
        SQLiteDatabase conn = openOrCreateDatabase("db", MODE_PRIVATE, null);
        conn.execSQL("create table if not exists detail(name varchar,aadhar varchar,age varchar,sex varchar,mobile varchar,email varchar," +
                "occupation varchar,state varchar,city varchar,address varchar,healthhistory varchar,travelhistory varchar,latitude varchar,longitude varchar," +
                "cardcolor varchar,percentage varchar,dvist varchar,startdate int,enddate int,puredate varchar);");
//0 to 19

        conn.execSQL("UPDATE  detail  SET cardcolor="+"'"+health_card+"'"+",percentage="+"'"+percent+"'"+",startdate="+"'"+sdate+"'"+",enddate="+"'"+endddate+"'"+",puredate="+"'"+ddate+"'"+"");

        Cursor c= conn.rawQuery("select * from detail",null);


        if(c.moveToFirst()){
            cardcolor=c.getString(14);
            percentt= c.getDouble(15)+"";
            namee =c.getString(0);
            aadharr = c.getString(1);
            age = c.getString(2);
            sex = c.getString(3);
            mobile = c.getString(4);
            emaill = c.getString(5);
            occupation = c.getString(6);
            state = c.getString(7);
            city = c.getString(8);
            addresss = c.getString(9);
            healthhistory = c.getString(10);
            travelhistory = c.getString(11);
            latitude = // gps
                    longitude = //gps
                            dvisit = c.getString(16);
            startdate =sdate+"";
            enddate = endddate+"";
            puredate = ddate+"";

upload();
        }



    }
    private void upload() {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference("Data/"+state+"/"+city+"/"+cardcolor);

            final Save value = new Save(namee,aadharr,age,sex,mobile,emaill,occupation,state,city,addresss,healthhistory,travelhistory,latitude,longitude,
                    cardcolor,percentt,dvisit,startdate,enddate,puredate);


            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    myRef.child(namee).child("Data").setValue(value);
                    Toast.makeText(Assessment.this, "Uploaded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Assessment.this, "Error", Toast.LENGTH_SHORT).show();

                }
            });


        }catch (Exception e){
            Toast.makeText(this,"NOt Uploaded :"+e,Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));

    }


}
