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
import com.ansari.lifeshare.Common.Database.UserHelperClass;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class DonorRegisteration extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String _fname, _lname, _dob, _gender, _phoneNo, _q1, _q2, _q3, _q4, _q5, _q6;
    String bloodgroup="";
    DatePicker datePicker;
    CountryCodePicker countryCodePicker;
    Spinner spinnerBldGrp;

    TextInputLayout  phoneNo, firstName, lastName;
    RadioButton selectedRadioButton;
    RadioGroup btnGender,btnQuest1,btnQuest2,btnQuest3,btnQuest4,btnQuest5,btnQuest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registeration);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        datePicker = findViewById(R.id.age_picker);
        btnGender = findViewById(R.id.btnGender);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNo = findViewById(R.id.phoneNo);
        btnQuest1 = findViewById(R.id.btnQuest1);
        btnQuest2 = findViewById(R.id.btnQuest2);
        btnQuest3 = findViewById(R.id.btnQuest3);
        btnQuest4 = findViewById(R.id.btnQuest4);
        btnQuest5 = findViewById(R.id.btnQuest5);
        btnQuest6 = findViewById(R.id.btnQuest6);



        String _fName = firstName.getEditText().getText().toString().trim();
        String _lName = lastName.getEditText().getText().toString().trim();
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phoneNo.getEditText().getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        final String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;


        int _dobday = datePicker.getDayOfMonth();
        int _dobmonth = datePicker.getMonth() + 1;
        int _dobyear = datePicker.getYear();
        String _dob = Integer.toString(_dobday) + "-" + Integer.toString(_dobmonth) + "-" + Integer.toString(_dobyear);
        selectedRadioButton  = (RadioButton)findViewById(btnGender.getCheckedRadioButtonId());
        //get RadioButton text
        String _gender = selectedRadioButton.getText().toString();

        spinnerBldGrp = findViewById(R.id.spinner_bld_grp);
        selectedRadioButton  = (RadioButton)findViewById(btnQuest1.getCheckedRadioButtonId());
        //get RadioButton text
        String _q1 = selectedRadioButton.getText().toString();


        selectedRadioButton  = (RadioButton)findViewById(btnQuest2.getCheckedRadioButtonId());
        //get RadioButton text
        String _q2 = selectedRadioButton.getText().toString();


        selectedRadioButton  = (RadioButton)findViewById(btnQuest3.getCheckedRadioButtonId());
        //get RadioButton text
        String _q3 = selectedRadioButton.getText().toString();

        selectedRadioButton  = (RadioButton)findViewById(btnQuest4.getCheckedRadioButtonId());
        //get RadioButton text
        String _q4 = selectedRadioButton.getText().toString();


        selectedRadioButton  = (RadioButton)findViewById(btnQuest5.getCheckedRadioButtonId());
        //get RadioButton text
        String _q5 = selectedRadioButton.getText().toString();

        selectedRadioButton  = (RadioButton)findViewById(btnQuest6.getCheckedRadioButtonId());
        //get RadioButton text
        String _q6 = selectedRadioButton.getText().toString();



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBldGrp.setAdapter(adapter);
        spinnerBldGrp.setOnItemSelectedListener(this);


    }

    public void storeNewDonorData(View view) {

        FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootnode.getReference("Donors");

        DonorHelperClass newUser = new DonorHelperClass(_fname, _lname, _dob, _gender, bloodgroup, _phoneNo, _q1, _q2, _q3, _q4, _q5, _q6);
        reference.child(_phoneNo).setValue(newUser);
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
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