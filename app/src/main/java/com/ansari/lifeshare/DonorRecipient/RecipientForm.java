package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ansari.lifeshare.R;

public class RecipientForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String bloodgroup="";

    Spinner spinnerBldGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_form);
        spinnerBldGrp = findViewById(R.id.spinner_bld_grp);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBldGrp.setAdapter(adapter);
        spinnerBldGrp.setOnItemSelectedListener(this);
    }

    public void goToSearchDonors(View view) {
        Intent intent = new Intent(RecipientForm.this,SearchDonor.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        bloodgroup = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), bloodgroup, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}