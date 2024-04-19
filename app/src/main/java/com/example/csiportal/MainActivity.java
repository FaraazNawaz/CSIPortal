package com.example.csiportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the title for the home page
        getSupportActionBar().setTitle("Home");

        // Buttons on the home page to go to 4 sections of the application
        Button learnButton = findViewById(R.id.learnButton);
        Button quizButton = findViewById(R.id.quizButton);
        Button supportButton = findViewById(R.id.supportButton);
        Button profileButton = findViewById(R.id.profileButton);


        //OnClick listener for button to open learn page when button is clicked
        learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnPage.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open quiz page when button is clicked
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizPage.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open support page when button is clicked
        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SupportPage.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open profile page when button is clicked
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilePage.class);
                startActivity(intent);
            }
        });


    }
}