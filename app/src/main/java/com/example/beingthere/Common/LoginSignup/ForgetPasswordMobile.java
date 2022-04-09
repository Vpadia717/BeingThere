package com.example.beingthere.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.beingthere.R;

public class ForgetPasswordMobile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_mobile);
    }

    public void callForgetPasswordMethodCheckScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.close_btn), "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPasswordMobile.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        }
    }

    public void callNewPasswordScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SetNewPassword.class);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.mobile_code_next), "transition_OTP_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPasswordMobile.this, pairs);
            startActivity(intent, options.toBundle());
        }
    }
}