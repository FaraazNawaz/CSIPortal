package com.example.csiportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);


        // Handler to run task after the delay
        Handler handler = new Handler();

        // Post delayed will start the home page after a delay of 3 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(LoadingScreen.this, MainActivity.class));

                // finish the activity to stop going back to it after reaching the home page
                finish();

            }
            // delays the loading page from finishing until 3 seconds have passed
        }, 3000);
    }
}