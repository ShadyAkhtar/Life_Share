package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ansari.lifeshare.R;

public class RecipientForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_form);
    }

    public void goToSearchDonors(View view) {
        Intent intent = new Intent(RecipientForm.this,SearchDonor.class);
        startActivity(intent);
    }
}