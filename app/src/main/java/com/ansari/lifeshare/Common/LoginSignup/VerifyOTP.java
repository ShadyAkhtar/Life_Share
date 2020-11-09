package com.ansari.lifeshare.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ansari.lifeshare.R;

public class VerifyOTP extends AppCompatActivity {
    Button btnVerifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);


        //button
        btnVerifyCode = findViewById(R.id.btnVerifyCode);
        callNextScreenFromOTP();
    }

    private void callNextScreenFromOTP() {
        btnVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerifyOTP.this, SetNewPassword.class);
                startActivity(intent);
            }
        });
    }

}