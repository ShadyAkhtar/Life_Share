package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ansari.lifeshare.Common.Database.DonorHelperClass;
import com.ansari.lifeshare.Common.Database.RecipientHelperClass;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class RecipientForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String pname,hospName,illnessDesc ,dob, gender, phoneNo;
    String bloodgroup="";
    DatePicker datePicker;
    CountryCodePicker countryCodePicker;
    RadioGroup btnGender;
    RadioButton selectedRadioButton;
    Spinner spinnerBldGrp;

    TextInputLayout phone, patientName,description,hosoital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_form);

        patientName = findViewById(R.id.PatientName);
        datePicker = findViewById(R.id.age_picker);
        btnGender = findViewById(R.id.btnGender);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phone = findViewById(R.id.phoneNo);
        spinnerBldGrp = findViewById(R.id.spinner_bld_grp);
        description = findViewById(R.id.illness_desc);
        hosoital = findViewById(R.id.hospital_name);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBldGrp.setAdapter(adapter);
        spinnerBldGrp.setOnItemSelectedListener(this);
    }
    public void storeNewDonorData(View view) {
        pname = patientName.getEditText().getText().toString().trim();
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phone.getEditText().getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;


        int _dobday = datePicker.getDayOfMonth();
        int _dobmonth = datePicker.getMonth() + 1;
        int _dobyear = datePicker.getYear();
        dob = Integer.toString(_dobday) + "-" + Integer.toString(_dobmonth) + "-" + Integer.toString(_dobyear);
        selectedRadioButton = (RadioButton) findViewById(btnGender.getCheckedRadioButtonId());
        //get RadioButton text
        gender = selectedRadioButton.getText().toString();
        illnessDesc = description.getEditText().getText().toString().trim();
        hospName = hosoital.getEditText().getText().toString().trim();

        newDonorData();
    }

    private void newDonorData() {

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Donors");

        RecipientHelperClass newUser = new RecipientHelperClass(pname,dob, gender,  phoneNo,illnessDesc,hospName );
        reference.child(phoneNo).setValue(newUser);
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
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