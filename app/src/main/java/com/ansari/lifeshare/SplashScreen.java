package com.ansari.lifeshare;

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

    private static int SPLASH_TIMER = 5000;
    Animation sideAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(layout.splash_screen);

        ImageView appImage = findViewById(id.appIcon);
        TextView appName = findViewById(id.appName);

        sideAnim = AnimationUtils.loadAnimation(this, side_anim);

        appImage.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable(){
        public void run(){
            Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
        }
        },SPLASH_TIMER);
    }
}