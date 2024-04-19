package com.example.csiportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csiportal.learn.Unit1;
import com.example.csiportal.learn.Unit2;
import com.example.csiportal.learn.Unit3;
import com.example.csiportal.learn.Unit4;
import com.example.csiportal.learn.Unit5;

public class LearnPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_page);

        //Set the title for the learn page and allow back button to be enabled to go back to the home page
        getSupportActionBar().setTitle("Learn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // 5 buttons on the learn page to go to different university modules the users can learn from
        Button unit1Button = findViewById(R.id.unit1Button);
        Button unit2Button = findViewById(R.id.unit2Button);
        Button unit3Button = findViewById(R.id.unit3Button);
        Button unit4Button = findViewById(R.id.unit4Button);
        Button unit5Button = findViewById(R.id.unit5Button);


        //OnClick listener for button to open software project management page when button is clicked
        unit1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnPage.this, Unit1.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open human computer interaction page when button is clicked
        unit2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnPage.this, Unit2.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open information security page when button is clicked
        unit3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnPage.this, Unit3.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open mobile design and development page when button is clicked
        unit4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnPage.this, Unit4.class);
                startActivity(intent);
            }
        });

        //OnClick listener for button to open introduction to artificial intelligence page when button is clicked
        unit5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnPage.this, Unit5.class);
                startActivity(intent);
            }
        });

    }
}