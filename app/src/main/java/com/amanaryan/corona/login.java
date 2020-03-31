package com.amanaryan.corona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {
ConstraintLayout phoneLy,otpLy;
Button otpBtn,loginBtn;
EditText phone,otp;

private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneLy = (ConstraintLayout) findViewById(R.id.phonelay);
        otpLy = (ConstraintLayout) findViewById(R.id.otplay);
        otpLy.setVisibility(View.GONE);
        otpBtn = findViewById(R.id.otpbtn);
//        loginBtn = findViewById(R.id.loginbtn);
//        phone = findViewById(R.id.phonId);
//        otp = findViewById(R.id.otp);

        mAuth = FirebaseAuth.getInstance();

        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(phone.getText().toString().isEmpty() && phone.getText().toString().length()==10){
//                    String phnumber="+91"+phone;
//                requestOtp(phnumber);
//                }else{
//                    phone.setError("Phone number is not Valid");}

                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    private void requestOtp(String phnumber) {
//    PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,120L,TimeUnit.SECONDS,this,mCallbacks);
    }

//    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks
}