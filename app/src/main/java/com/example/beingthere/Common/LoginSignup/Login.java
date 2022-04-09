package com.example.beingthere.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.beingthere.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);
    }

    public void callLoginScreen(View view){
        Intent intent = new Intent(getApplicationContext(),RetailerStartUpScreen.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View,String>(findViewById(R.id.login_back_button),"transition_login");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
        startActivity(intent, activityOptions.toBundle());

    }

    public void callSignUpFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), SignUp.class));
        finish();
    }

    public void callForgetPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.forgot_btn), "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
            startActivity(intent, options.toBundle());
        }
    }

}