package com.ansari.lifeshare.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.SignUp;

public class ForgetPassword extends AppCompatActivity {

    Button btnForgetNext;
    ImageView btnForgetBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        //next button
        btnForgetNext = findViewById(R.id.forget_password_next_btn);
        btnForgetBack = findViewById(R.id.forget_password_back_btn);

        callBackScreenFromForgetPassword();
        verifyPhoneNumber();

    }

    private void callBackScreenFromForgetPassword() {
        btnForgetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgetPassword.super.onBackPressed();
            }
        });
    }

    private void verifyPhoneNumber() {
        btnForgetNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassword.this, VerifyOTP.class);
                startActivity(intent);
            }
        });

    }
}