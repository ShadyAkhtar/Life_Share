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

import com.ansari.lifeshare.User.UserDashboard;
import com.google.android.material.navigation.NavigationView;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class LearnAboutBlood extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_about_blood);

        //menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationView.setItemIconTintList(null);

        navigationDrawer();

        ExpandableTextView expand_process_info = findViewById(R.id.expand_process_info);

// IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expand_process_info.setText(getString(R.string.process_info));

        ExpandableTextView expand_after_donating_info = findViewById(R.id.expand_after_donating_info);
        expand_after_donating_info.setText(getString(R.string.after_donating_info));

        ExpandableTextView expand_hurt_info = findViewById(R.id.expand_hurt_info);
        expand_hurt_info.setText(getString(R.string.hurt_info));

         ExpandableTextView expand_time_info = findViewById(R.id.expand_time_info);
        expand_time_info.setText(getString(R.string.time_info));

         ExpandableTextView expand_often_info = findViewById(R.id.expand_often_info);
        expand_often_info.setText(getString(R.string.often_info));

        ExpandableTextView expand_who_can_info = findViewById(R.id.expand_who_can_info);
        expand_who_can_info.setText(getString(R.string.who_can_info));

        ExpandableTextView expand_eligibility_info = findViewById(R.id.expand_eligibility_info);
        expand_eligibility_info.setText(getString(R.string.eligibility_info));




    }

    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_info);

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
                Intent intent_home = new Intent(LearnAboutBlood.this, UserDashboard.class);
                startActivity(intent_home);
                break;

            case R.id.nav_signin:
                Intent intent_signin = new Intent(LearnAboutBlood.this, SignIn.class);
                startActivity(intent_signin);
                break;

            case R.id.nav_signup:

                Intent intent_signup = new Intent(LearnAboutBlood.this, SignUp.class);
                startActivity(intent_signup);
//                menu.findItem(id.nav_signup).setVisible(false);
                break;

            case R.id.nav_info:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}