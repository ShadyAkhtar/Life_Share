package com.ansari.lifeshare.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ansari.lifeshare.R;

public class SetNewPassword extends AppCompatActivity {

    Button setNewPasswordBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        //button
        setNewPasswordBtn = findViewById(R.id.set_new_password_btn);
        setNewPasswordBtn();

    }

    private void setNewPasswordBtn() {
        setNewPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetNewPassword.this, ForgetPasswordSuccessMessage.class);
                startActivity(intent);
            }
        });
    }
}