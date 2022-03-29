package com.example.beingthere;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT=2000;

    //variables
    ImageView Image;
    TextView logoName, logoDesc;

    //Animation
    Animation sideAnim, bottomAnim;

    // Create a new event for the activity.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for the content view.
        setContentView(R.layout.splash_screen);

        //hooks
        Image = findViewById(R.id.imageView1);
        logoName = findViewById(R.id.textView1);
        logoDesc = findViewById(R.id.textView2);

        //Animation hooks
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations to elements
        Image.setAnimation(sideAnim);
        logoName.setAnimation(bottomAnim);
        logoDesc.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);


    }
}