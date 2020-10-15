package com.ansari.lifeshare.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ansari.lifeshare.LearnAboutBlood;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.SignIn;
import com.ansari.lifeshare.SignUp;
import com.google.android.material.navigation.NavigationView;

import static com.ansari.lifeshare.R.*;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_user_dashboard);

        //menu
        drawerLayout = findViewById(id.drawer_layout);
        navigationView = findViewById(id.navigation_view);
        menuIcon = findViewById(id.menu_icon);

        navigationView.setItemIconTintList(null);

        navigationDrawer();

    }

    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(id.nav_home);

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
            case id.nav_home:
                break;

            case id.nav_signin:
                Intent intent = new Intent(UserDashboard.this, SignIn.class);
                startActivity(intent);
                break;

            case id.nav_signup:

                Intent intent1 = new Intent(UserDashboard.this, SignUp.class);
                startActivity(intent1);
//                menu.findItem(id.nav_signup).setVisible(false);
                break;

            case id.nav_info:
                Intent intent2 = new Intent(UserDashboard.this, LearnAboutBlood.class);
                startActivity(intent2);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}