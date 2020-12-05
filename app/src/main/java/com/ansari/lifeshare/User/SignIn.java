package com.ansari.lifeshare.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ansari.lifeshare.Common.LoginSignup.ForgetPassword;
import com.ansari.lifeshare.Databases.SessionManager;
import com.ansari.lifeshare.HelperClasses.CheckInternet;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.RetailerDashboard;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;

public class SignIn extends AppCompatActivity {

    ImageView menuBack;
    Button btnSignUp, btnForget;
    CountryCodePicker countryCodePicker;
    TextInputLayout phoneNumber, password;
    RelativeLayout progressbar;
    CheckBox rememberMe;
    TextInputEditText phoneNumberEditText, passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        menuBack = findViewById(R.id.menu_back);

        countryCodePicker = findViewById(R.id.signIn_country_code_picker);
        phoneNumber = findViewById(R.id.signIn_phoneNo);
        password = findViewById(R.id.signIn_Password);
        progressbar = findViewById(R.id.login_progress_bar);
        rememberMe = findViewById(R.id.remember_me);
        phoneNumberEditText = findViewById(R.id.E_signIn_phoneNo);
        passwordEditText = findViewById(R.id.E_signIn_Password);

        //Check weather phone number and password is already saved in Shared Preferences or not
        SessionManager sessionManager = new SessionManager(SignIn.this, SessionManager.SESSION_REMEMMBERME);
        if (sessionManager.checkRememberMe()) {
            HashMap<String, String> rememberMeDetails = sessionManager.getRemeberMeDetailsFromSession();
            phoneNumberEditText.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPHONENUMBER));
            passwordEditText.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD));
        }

        //button
        btnSignUp = findViewById(R.id.btnSignUp);
        btnForget = findViewById(R.id.forget_btn);

        menuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn.super.onBackPressed();
            }
        });
        signUp();
        forgetPassword();
    }

    private void forgetPassword() {
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, ForgetPassword.class);
                startActivity(intent);
            }
        });
    }

    private void signUp() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    public void letTheUserLoggedIn(View view) {

        //Check Internet Connection
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)) {
            showCustomDialog();
            return;
        }

        if (!validateFields()) {
            return;
        }

        progressbar.setVisibility(View.VISIBLE);
        
        //Get values from fields
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        final String _password = password.getEditText().getText().toString().trim();
        if (_phoneNumber.charAt(0) == '0') {
            _phoneNumber = _phoneNumber.substring(1);
        } //remove 0 at the start if entered by the user
        final String _completePhoneNumber = "+" + countryCodePicker.getFullNumber() + _phoneNumber;


        //Check Remember Me Button to create it's session
        if (rememberMe.isChecked()) {
            SessionManager sessionManager = new SessionManager(SignIn.this, SessionManager.SESSION_REMEMMBERME);
            sessionManager.createRememberMeSession(_phoneNumber, _password);
        }

        //Check weather User exists or not in database
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phone").equalTo(_completePhoneNumber);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //If Phone Number exists then get password
                if (dataSnapshot.exists()) {
                    phoneNumber.setError(null);
                    phoneNumber.setErrorEnabled(false);
                    String systemPassword = dataSnapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                    //if password exists and matches with users password then get other fields from database
                    if (systemPassword.equals(_password)) {
                        password.setError(null);
                        password.setErrorEnabled(false);

                        //Get users data from firebase database
                        String _fName = dataSnapshot.child(_completePhoneNumber).child("fname").getValue(String.class);
                        String _lName = dataSnapshot.child(_completePhoneNumber).child("lname").getValue(String.class);
                        String _email = dataSnapshot.child(_completePhoneNumber).child("email").getValue(String.class);
                        String _phoneNo = dataSnapshot.child(_completePhoneNumber).child("phone").getValue(String.class);
                        String _address = dataSnapshot.child(_completePhoneNumber).child("address").getValue(String.class);
                        String _password = dataSnapshot.child(_completePhoneNumber).child("password").getValue(String.class);
                        String _dob = dataSnapshot.child(_completePhoneNumber).child("dob").getValue(String.class);
                        String _gender = dataSnapshot.child(_completePhoneNumber).child("gender").getValue(String.class);
                        String _bloodgroup = dataSnapshot.child(_completePhoneNumber).child("bloodgroup").getValue(String.class);
//                        String _address = dataSnapshot.child(_completePhoneNumber).child("address").getValue(String.class);

                        Toast.makeText(SignIn.this, _fName+"\n" + _lName+"\n " +_email+"\n" +_phoneNo+"\n" +_password+"\n" +_dob+"\n" +_gender+"\n" +_address, Toast.LENGTH_SHORT).show();
                        
                        //Create a Session
                        SessionManager sessionManager = new SessionManager(SignIn.this,SessionManager.SESSION_USERSESSION);
                        sessionManager.createLoginSession(_fName,_lName, _address, _email, _phoneNo, _password, _dob, _gender,_address,_bloodgroup);

//                        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                        startActivity(new Intent(getApplicationContext(), RetailerDashboard.class));
                        finish();
                        progressbar.setVisibility(View.GONE);

                    } else {
                        progressbar.setVisibility(View.GONE);
                        password.setError("Password does not match!");
                    }
                } else {
                    progressbar.setVisibility(View.GONE);
                    phoneNumber.setError("No such user exist!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(SignIn.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                        finish();
                    }
                });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private boolean validateFields() {
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (_phoneNumber.isEmpty()) {
            phoneNumber.setError("Phone number can not be empty");
            phoneNumber.requestFocus();
            return false;
        } else if (_password.isEmpty()) {
            password.setError("Password can not be empty");
            password.requestFocus();
            return false;
        } else if (!_phoneNumber.matches(checkspaces)) {
            phoneNumber.setError("No White spaces are allowed!");
            return false;
        } else {
            phoneNumber.setError(null);
            password.setError(null);
            phoneNumber.setErrorEnabled(false);
            password.setErrorEnabled(false);
            return true;
        }
    }
}


