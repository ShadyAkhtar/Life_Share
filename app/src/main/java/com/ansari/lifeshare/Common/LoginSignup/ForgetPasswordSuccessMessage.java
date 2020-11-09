package com.ansari.lifeshare.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.SignIn;

public class ForgetPasswordSuccessMessage extends AppCompatActivity {

    Button successMessageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_success_message);

        //button
        successMessageButton = findViewById(R.id.success_message_btn);
        backToLogin();
    }

    private void backToLogin() {
        successMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordSuccessMessage.this, SignIn.class);
                startActivity(intent);
            }
        });
    }


}