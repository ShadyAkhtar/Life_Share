package com.ansari.lifeshare.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ansari.lifeshare.R;

public class SignIn extends AppCompatActivity {

    ImageView menuBack;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        menuBack = findViewById(R.id.menu_back);

        //button
        btnSignUp = findViewById(R.id.btnSignUp);

        menuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn.super.onBackPressed();
            }
        });
        signUp();

    }

    private void signUp() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}