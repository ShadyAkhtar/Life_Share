package com.ansari.lifeshare.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ansari.lifeshare.User.UserDashboard;

import static com.ansari.lifeshare.R.*;
import static com.ansari.lifeshare.R.anim.*;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;
    Animation sideAnim, bottomAnim, sideLeftAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.splash_screen);

        //animation
        ImageView appImage = findViewById(id.appIcon);
        TextView appName = findViewById(id.appName);
        TextView appTag = findViewById(id.appTag);

        sideAnim = AnimationUtils.loadAnimation(this, side_anim);
        sideLeftAnim   = AnimationUtils.loadAnimation(this, left_side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, bottom_anim);

        appImage.setAnimation(sideAnim);
        appName.setAnimation(sideLeftAnim);
        appTag.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable(){
        public void run(){
            Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                    finish();
        }
        },SPLASH_TIMER);
    }
}