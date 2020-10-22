package com.ansari.lifeshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ansari.lifeshare.Common.LearnAboutBlood;
import com.ansari.lifeshare.User.SignIn;
import com.ansari.lifeshare.User.SignUp;
import com.ansari.lifeshare.User.UserDashboard;
import com.google.android.material.navigation.NavigationView;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class BloodCompatibility extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_compatibility);

        //menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationView.setItemIconTintList(null);

        navigationDrawer();

    }

    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_compatibility);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent_home = new Intent(BloodCompatibility.this, UserDashboard.class);
                startActivity(intent_home);
                break;

            case R.id.nav_signin:
                Intent intent_signin = new Intent(BloodCompatibility.this, SignIn.class);
                startActivity(intent_signin);
                break;

            case R.id.nav_signup:

                Intent intent_signup = new Intent(BloodCompatibility.this, SignUp.class);
                startActivity(intent_signup);
//                menu.findItem(id.nav_signup).setVisible(false);
                break;

            case R.id.nav_info:

                Intent intent_info = new Intent(BloodCompatibility.this, LearnAboutBlood.class);
                startActivity(intent_info);
                break;

            case R.id.nav_compatibility:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}