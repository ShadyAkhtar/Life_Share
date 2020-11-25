package com.ansari.lifeshare;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class demo extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    String fname, lname, dob, gender, bloodgroup, phone, email, address, username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        tv1 = findViewById(R.id.textView100);
        tv2 = findViewById(R.id.textView101);
        tv3 = findViewById(R.id.textView102);
        tv4 = findViewById(R.id.textView103);
        tv5 = findViewById(R.id.textView104);
        tv6 = findViewById(R.id.textView105);
        tv7 = findViewById(R.id.textView106);
        tv8 = findViewById(R.id.textView107);
        tv9 = findViewById(R.id.textView108);
        tv10 = findViewById(R.id.textView109);

        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        dob = getIntent().getStringExtra("dob");
        gender = getIntent().getStringExtra("gender");
        bloodgroup = getIntent().getStringExtra("bloodgroup");
        phone = getIntent().getStringExtra("phone");
        email = getIntent().getStringExtra("email");
        address = getIntent().getStringExtra("address");
        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");

        tv1.setText(fname);
        tv2.setText(lname);
        tv3.setText(dob);
        tv4.setText(gender);
        tv5.setText(bloodgroup);
        tv6.setText(phone);
        tv7.setText(email);
        tv8.setText(address);
        tv9.setText(username);
        tv10.setText(password);

    }
}