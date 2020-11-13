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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ansari.lifeshare.Common.LoginSignup.VerifyOTP;
import com.ansari.lifeshare.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView menuBack;
    Spinner spinnerBldGrp;
    DatePicker datePicker;

    //variables

    Button btnSignup;
    RadioGroup btnGender;

    //get data variables

    TextInputLayout username,password,confirmPassword,email,phoneNo,firstName,lastName,address;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //hooks for button
        btnSignup = findViewById(R.id.btnSignup);
        username =findViewById(R.id.username);
        email =  findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        btnGender = findViewById(R.id.btnGender);
        phoneNo = findViewById(R.id.phoneNo);
        datePicker = findViewById(R.id.age_picker);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        address = findViewById(R.id.address);

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

    public void callNextSignupScreen(View view){

        if ( !validateUsername() | !validateEmail() | !validatePassword() | !validateConfirmPassword() |
           !validateGender() | !validateAge() | !validatePhoneNumber() | !validateFirstName() | ! validateLastName() |!validateAddress() ) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
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
                "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

//        String letter =  "(?=.*[a-zA-Z])" ;

//        String whiteSpaces = "^" + "(?=\\S+$)" + "$";

//        String digit = "^" + "(?=.*[0-9])" + "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password is too weak!\n Password should contain letter,digit, \natleast 4 character, no white space");
            return false;
        }
//        else if (!val.matches(digit)) {
//            password.setError("Password should contain atleast 1 digit!");
//            return false;
//        }
//        else if (!val.matches(letter)) {
//            password.setError("Password should contain atleast 1 letter!");
//            return false;
//        }
//        else if (!val.matches(whiteSpaces)) {
//            password.setError("Password should not contain whiteSpaces!");
//            return false;
//        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        String val = confirmPassword.getEditText().getText().toString().trim();
        String val1 = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

//        String letter = "^"+"(?=.*[a-zA-Z])"+"$";
//
//        String whiteSpaces = "^" + "(?=\\S+$)"+"$";
//
//        String digit = "^" + "(?=.*[0-9])"+"$";


        if (val.isEmpty()) {
            confirmPassword.setError("Field can not be empty");
            return false;
        }

        else if (!val.matches(checkPassword)) {
            confirmPassword.setError("Password is too weak! \nPassword should contain letter,digit, \natleast 4 character, no white space");
            return false;
        }

//        else if (!val.matches(letter)) {
//            confirmPassword.setError("Password should contain atleast 1 letter!");
//            return false;
//        }else if (!val.matches(whiteSpaces)) {
//            confirmPassword.setError("Password should not contain whiteSpaces!");
//            return false;
//        } else if (!val.matches(digit)) {
//            confirmPassword.setError("Password should contain atleast 1 digit!");
//            return false;
//        }
        else if (val != val1){
            confirmPassword.setError("Password does not match");
            return false;
        }
        else {
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
        String checkspaces = "Aw{1,20}z";
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
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}