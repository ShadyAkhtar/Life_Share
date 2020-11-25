package com.ansari.lifeshare.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ansari.lifeshare.Common.LoginSignup.VerifyOTP;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.demo;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

import java.util.Calendar;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView menuBack;
    Spinner spinnerBldGrp;
    DatePicker datePicker;
    CountryCodePicker countryCodePicker;
    //variables

    Button btnSignup;
    RadioButton selectedRadioButton;
    RadioGroup btnGender;
    String _bloodgroup = "";

    //get data variables

    TextInputLayout username, password, confirmPassword, email, phoneNo, firstName, lastName, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //hooks for button
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        datePicker = findViewById(R.id.age_picker);
        btnGender = findViewById(R.id.btnGender);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNo = findViewById(R.id.phoneNo);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        btnSignup = findViewById(R.id.btnSignup);


        menuBack = findViewById(R.id.menu_back);

        spinnerBldGrp = findViewById(R.id.spinner_bld_grp);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBldGrp.setAdapter(adapter);
        spinnerBldGrp.setOnItemSelectedListener(this);

        menuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp.super.onBackPressed();
            }
        });
    }

    public void callNextSignupScreen(View view) {

        if (!validateUsername() | !validateEmail() | !validatePassword() | !validateConfirmPassword() |
                !validateGender() | !validateAge() | !validatePhoneNumber() | !validateFirstName() | !validateLastName() | !validateAddress()) {
            return;
        }

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

        String _email = email.getEditText().getText().toString().trim();
        String _address = address.getEditText().getText().toString().trim();
        String _username = username.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        int _dobday = datePicker.getDayOfMonth();
        int _dobmonth = datePicker.getMonth() + 1;
        int _dobyear = datePicker.getYear();
        String _dob = Integer.toString(_dobday) + "-" + Integer.toString(_dobmonth) + "-" + Integer.toString(_dobyear);
        selectedRadioButton  = (RadioButton)findViewById(btnGender.getCheckedRadioButtonId());
        //get RadioButton text
        String _gender = selectedRadioButton.getText().toString();
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
//        Intent intent = new Intent(getApplicationContext(), demo.class);


        intent.putExtra("fname",_fName);
        intent.putExtra("lname",_lName);
        intent.putExtra("dob",_dob);
        intent.putExtra("gender",_gender);
        intent.putExtra("bloodgroup",_bloodgroup);
        intent.putExtra("phone",_phoneNo);
        intent.putExtra("email",_email);
        intent.putExtra("address",_address);
        intent.putExtra("username",_username);
        intent.putExtra("password",_password);
        startActivity(intent);
    }

    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            username.setError("No White spaces are allowed!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
//                "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
                // "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        Pattern digit = Pattern.compile("[0-9]");
        Pattern letter = Pattern.compile("[A-Za-z]");
        Pattern whiteSpaces = Pattern.compile("\\s");

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain atleast 4 character");
            return false;
        } else if (!letter.matcher(val).find()) {
            password.setError("Password should contain atleast 1 letter!");
            return false;
        } else if (whiteSpaces.matcher(val).find()) {
            password.setError("Password should not contain whiteSpaces!");
            return false;
        } else if (!digit.matcher(val).find()) {
            password.setError("Password should contain atleast 1 digit!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String val = confirmPassword.getEditText().getText().toString().trim();
        String val1 = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
//                "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
//                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
//                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";


//        String letter = "^"+"(?=.*[a-zA-Z])"+"$";
//
//        String whiteSpaces = "^" + "(?=\\S+$)"+"$";
//
        Pattern digit = Pattern.compile("[0-9]");
        Pattern letter = Pattern.compile("[A-Za-z]");
        Pattern whiteSpaces = Pattern.compile("\\s");


        if (val.isEmpty()) {
            confirmPassword.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
//            confirmPassword.setError("Password is too weak! \nPassword should contain letter,digit, \natleast 4 character, no white space");
            confirmPassword.setError("Password should contain atleast 4 character");
            return false;
        } else if (!letter.matcher(val1).find()) {
            confirmPassword.setError("Password should contain atleast 1 letter!");
            return false;
        } else if (whiteSpaces.matcher(val1).find()) {
            confirmPassword.setError("Password should not contain whiteSpaces!");
            return false;
        } else if (!digit.matcher(val1).find()) {
            confirmPassword.setError("Password should contain atleast 1 digit!");
            return false;
        } else if (!val.equals(val1)) {
            confirmPassword.setError("Password does not match");
            return false;
        } else {
            confirmPassword.setError(null);
            confirmPassword.setErrorEnabled(false);
            return true;
        }

//        if(val != val1)
//        {
//            confirmPassword.setError("Entered password does not match");
//            return false;
//        }
    }

    private boolean validateGender() {
        if (btnGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    private boolean validatePhoneNumber() {
        String val = phoneNo.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            phoneNo.setError("Enter valid phone number");
            return false;
        } else if (!val.matches(checkspaces)) {
            phoneNo.setError("No White spaces are allowed!");
            return false;
        } else {
            phoneNo.setError(null);
            phoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateFirstName() {
        String val = firstName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            firstName.setError("Field can not be empty");
            return false;
        } else {
            firstName.setError(null);
            firstName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateLastName() {
        String val = lastName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            lastName.setError("Field can not be empty");
            return false;
        } else {
            lastName.setError(null);
            lastName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateAddress() {
        String val = address.getEditText().getText().toString().trim();
//        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            address.setError("Field can not be empty");
            return false;
//        } else if (val.length() > 20) {
//            username.setError("Username is too large!");
//            return false;
//        } else if (!val.matches(checkspaces)) {
//            username.setError("No White spaces are allowed!");
//            return false;
        } else {
            address.setError(null);
            address.setErrorEnabled(false);
            return true;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        _bloodgroup = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), _bloodgroup, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}