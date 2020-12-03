package com.ansari.lifeshare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ansari.lifeshare.Databases.SessionManager;

import java.util.HashMap;

public class retailer_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_dashboard);

        TextView textView = findViewById(R.id.textView20);

       SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> usersDetails = sessionManager.getUsersDetailFromSession();

        String fisrtName = usersDetails.get(SessionManager.KEY_FIRSTNAME);
        String lastName = usersDetails.get(SessionManager.KEY_LASTNAME);
        String email = usersDetails.get(SessionManager.KEY_EMAIL);
        String phoneNumber = usersDetails.get(SessionManager.KEY_PHONENUMBER);
        String password = usersDetails.get(SessionManager.KEY_PASSWORD);
        String username = usersDetails.get(SessionManager.KEY_USERNAME);
        String age = usersDetails.get(SessionManager.KEY_DATE);
        String gender = usersDetails.get(SessionManager.KEY_GENDER);
        String bloodgroup = usersDetails.get(SessionManager.KEY_BLOODGROUP);
        String address = usersDetails.get(SessionManager.KEY_ADDRESS);

        textView.setText(
                "First Name: " + fisrtName + "\n" +
                        "last Name: " + lastName + "\n" +
                        "Email: " + email + "\n" +
                        "Phone Number: " + phoneNumber + "\n" +
                        "Password: " + password + "\n" +
                        "Username: " + username + "\n" +
                        "Date of Birth: " + age + "\n" +
                        "Gender: " + gender + "\n"+
                        "bloodgroup: " + bloodgroup + "\n"+
                        "address: " + address + "\n"
        );
    }
}