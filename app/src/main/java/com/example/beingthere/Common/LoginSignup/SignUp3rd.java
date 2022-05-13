package com.example.beingthere.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;

import com.example.beingthere.Common.HomeScreen;
import com.example.beingthere.Databases.UserHelperClass;
import com.example.beingthere.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class SignUp3rd extends AppCompatActivity {

    //Variables
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    String fullname, username, email, date, gender, password, phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);

        //hooks of the variables
        scrollView = findViewById(R.id.signup_3rd_screen_scroll_view);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);

        fullname = getIntent().getStringExtra("fullName");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        date = getIntent().getStringExtra("date");
        gender = getIntent().getStringExtra("gender");
        password = getIntent().getStringExtra("password");

    }

    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void callSecondSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUp3rd.this, pairs);
            startActivity(intent, activityOptions.toBundle());
            finish();
        }

    }

    public void callHomeScreen(View view) {

        if (!validatePhoneNUmber()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), HomeScreen.class);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_next_button), "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            storeNewUserData();
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rd.this, pairs);
            startActivity(intent, options.toBundle());
        }
    }

    private void storeNewUserData() {

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        reference.setValue("First record!");
        //UserHelperClass addNewUser = new UserHelperClass(fullname,username,date,gender,email,password);

        //reference.setValue(addNewUser);
    }

    private boolean validatePhoneNUmber() {
        String val = phoneNumber.getEditText().getText().toString();
        if (val.isEmpty()) {
            String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
            String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;
            phoneNumber.setError("Field cannot be empty");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }
}

