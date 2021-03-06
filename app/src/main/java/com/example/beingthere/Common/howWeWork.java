package com.example.beingthere.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.beingthere.Common.LoginSignup.RetailerStartUpScreen;
import com.example.beingthere.R;

public class howWeWork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_we_work);
    }

    public void callRetailerStartUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.retailer_startup_back_button), "transition_back_arrow_btn");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(howWeWork.this, pairs);
        startActivity(intent, activityOptions.toBundle());
        finish();

    }


    public void callbackRetailerStartUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.back), "transition_back_btn");

        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(howWeWork.this, pairs);
        startActivity(intent, activityOptions.toBundle());
        finish();

    }
}