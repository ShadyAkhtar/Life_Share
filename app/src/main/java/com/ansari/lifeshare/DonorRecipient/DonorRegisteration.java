package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ansari.lifeshare.Common.Database.DonorHelperClass;
import com.ansari.lifeshare.Common.Database.UserHelperClass;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.UserDashboard;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonorRegisteration extends AppCompatActivity {

    String fname, lname, dob, gender, bloodgroup, phone, quest1, quest2, quest3, quest4, quest5, quest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registeration);


        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        bloodgroup = getIntent().getStringExtra("bloodgroup");
        phone = getIntent().getStringExtra("phone");
        quest1 = getIntent().getStringExtra("quest1");
        quest2 = getIntent().getStringExtra("quest2");
        quest3 = getIntent().getStringExtra("quest3");
        quest4 = getIntent().getStringExtra("quest4");
        quest5 = getIntent().getStringExtra("quest5");
        quest6 = getIntent().getStringExtra("quest6");


    }

    public void storeNewDonorData(View view) {

        FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootnode.getReference("Donors");

        DonorHelperClass newUser = new DonorHelperClass(fname, lname, dob, gender, bloodgroup, phone, quest1, quest2, quest3, quest4, quest5, quest6);
        reference.child(phone).setValue(newUser);
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
    }
}