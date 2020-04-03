package com.amanaryan.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {
ConstraintLayout phoneLy,otpLy,progressbar;
Button otpBtn,loginBtn,MasterLogin;
EditText phone,otptext;
    String phnumber,sentcode;
    TextView Resendcode;
    //static ph number is user is already Logged in
    static String number;
    String yes="YES";
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressbar=findViewById(R.id.progressbarLayout);
        progressbar.setVisibility(View.GONE);
        phoneLy = (ConstraintLayout) findViewById(R.id.phonelay);
        otpLy=findViewById(R.id.Otplay);
        otpBtn = findViewById(R.id.Generateotpbtn);
        loginBtn=findViewById(R.id.Loginbtn);
        phone=findViewById(R.id.Phonenumberid);
        otptext=findViewById(R.id.otptext);
        Resendcode=findViewById(R.id.resendcodeText);
        mAuth = FirebaseAuth.getInstance();
        MasterLogin=findViewById(R.id.Master_Login);
//        phoneLy.setVisibility(View.GONE);
        Resendcode.setVisibility(View.GONE);
        otpLy.setVisibility(View.GONE);
        //Auto check weather the user is logged in or not
//        LoggedInNotCheck();

        Resendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resendcode.setVisibility(View.GONE);
                Toast.makeText(login.this, "Code Resending...", Toast.LENGTH_LONG).show();
                requestOtp(phnumber);

            }
        });


        //Master Login code
        MasterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        //Request otp to send
        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( phone.getText().toString().length()==10){
                     phnumber="+91"+phone.getText().toString();
                requestOtp(phnumber);
                    otpLy.setVisibility(View.VISIBLE);
                    phoneLy.setVisibility(View.GONE);
                    TwoMinTimerCheck();
                }else{
                    phone.setError("Phone number is not Valid");
                }

//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });

    }
//Time check
    private void TwoMinTimerCheck() {
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Resendcode.setVisibility(View.VISIBLE);
        }
    },20000);
    }
//
//    private void LoggedInNotCheck() {
//
//
//        SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
//        conn.execSQL("create table if not exists Login(user varchar,RegisteredPhNumber Int);");
//
//
//        Cursor c= conn.rawQuery("select * from Login where user='YES'",null);
//
//
//        if(c.moveToFirst()){
////static string phnumber
//            number=c.getString(1);
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//
//
//        }else{
////            if user is not logged in then
//            phoneLy.setVisibility(View.VISIBLE);
//        }
//
//
//
//
//    }

    private void verifySignInCode() {
        String codeFromUser=otptext.getText().toString();
    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(sentcode,codeFromUser);
  signInWithPhoneAuthCredential(credential);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //successfully signed in as code of user and sent code matched;

                            SQLiteDatabase conn=openOrCreateDatabase("db",MODE_PRIVATE,null);
                            conn.execSQL("create table if not exists Login(user varchar,RegisteredPhNumber Int);");

                            conn.execSQL("insert into Login values("+"'"+yes+"'"+","+"'"+phnumber+"'"+");");
                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),User_RegistrationForm.class).putExtra("phnumber",phnumber));

                        }else{
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){

                                Toast.makeText(login.this, "SignIn Failed!:  Invalid Otp", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
    }




    private void requestOtp(String phnumber) {
    PhoneAuthProvider.getInstance().verifyPhoneNumber(phnumber,120L,TimeUnit.SECONDS,this,mCallbacks);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            sentcode=s;

        }
    };
}