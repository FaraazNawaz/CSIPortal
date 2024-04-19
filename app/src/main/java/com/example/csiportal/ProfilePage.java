package com.example.csiportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {


    // Using shared preferences as way to save user information on profile page
    private SharedPreferences sharedPreferences;

    // Edit text fields which are used by user to enter information for their profile page
    private EditText EnterNameField, EnterAgeField, EnterUniversityField, EnterUniversityCourseField, EnterCurrentModulesField, EnterCompletedModulesField;

    // Button to allow user to add and save information
    private Button AddButton;

    // Used to check if user can edit their profile page information or not
    private boolean EditUserDetails = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        //Set the title for the profile page and allow back button to be enabled to allow user to go back to home page
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Initialise shared preferences
        sharedPreferences = getPreferences(MODE_PRIVATE);

        // Initialise the edit text fields
        EnterNameField = findViewById(R.id.EnterNameField);
        EnterAgeField = findViewById(R.id.EnterAgeField);
        EnterUniversityField = findViewById(R.id.EnterUniversityField);
        EnterUniversityCourseField = findViewById(R.id.EnterUniversityCourseField);
        EnterCurrentModulesField = findViewById(R.id.EnterCurrentModulesField);
        EnterCompletedModulesField = findViewById(R.id.EnterCompletedModulesField);

        // Initialise the add and save button
        AddButton = findViewById(R.id.AddButton);

        // OnClick listener for user to click button to add or save information
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EditUserDetails) {

                    // Save user information to shared preferences
                    // Get the information from edit text fields
                    String enterNameField = EnterNameField.getText().toString();
                    String enterAgeField = EnterAgeField.getText().toString();
                    String enterUniversityField = EnterUniversityField.getText().toString();
                    String enterUniversityCourseField = EnterUniversityCourseField.getText().toString();
                    String enterCurrentModulesField = EnterCurrentModulesField.getText().toString();
                    String enterCompletedModulesField = EnterCompletedModulesField.getText().toString();

                    // Check if any field has text entered inside
                    if (!enterNameField.isEmpty() || !enterAgeField.isEmpty() || !enterUniversityField.isEmpty() || !enterUniversityCourseField.isEmpty() || !enterCurrentModulesField.isEmpty() || !enterCompletedModulesField.isEmpty()) {

                        // Save the information entered to shared preferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", enterNameField);
                        editor.putString("age", enterAgeField);
                        editor.putString("university", enterUniversityField);
                        editor.putString("course", enterUniversityCourseField);
                        editor.putString("currentModules", enterCurrentModulesField);
                        editor.putString("completedModules", enterCompletedModulesField);
                        editor.apply();

                        // Save the information that has been entered into text fields and update the profile page with details
                        Toast.makeText(ProfilePage.this, "Information updated", Toast.LENGTH_SHORT).show();

                        // Stop user from being able to edit the profile page information
                        editProfileInformation(false);
                    } else {

                        // Information will need to be added to at least one field to allow information to be stored to profile page
                        Toast.makeText(ProfilePage.this, "Add information before saving", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    // Allow user to edit information on profile page
                    editProfileInformation(true);
                }
            }
        });


        // Load the saved information if any information has been saved to profile page from shared preferences
        // Retrieve user information from shared preferences
        String enterNameField = sharedPreferences.getString("name", "");
        String enterAgeField = sharedPreferences.getString("age", "");
        String enterUniversityField = sharedPreferences.getString("university", "");
        String enterUniversityCourseField = sharedPreferences.getString("course", "");
        String enterCurrentModulesField = sharedPreferences.getString("currentModules", "");
        String enterCompletedModulesField = sharedPreferences.getString("completedModules", "");

        // Set the information from shared preferences to the edit text fields
        EnterNameField.setText(enterNameField);
        EnterAgeField.setText(enterAgeField);
        EnterUniversityField.setText(enterUniversityField);
        EnterUniversityCourseField.setText(enterUniversityCourseField);
        EnterCurrentModulesField.setText(enterCurrentModulesField);
        EnterCompletedModulesField.setText(enterCompletedModulesField);

        // Check if information is already in the edit text fields
        boolean information = !enterNameField.isEmpty() || !enterAgeField.isEmpty() || !enterUniversityField.isEmpty() || !enterUniversityCourseField.isEmpty() || !enterCurrentModulesField.isEmpty() || !enterCompletedModulesField.isEmpty();

        // Disable the edit text fields if information is already inside
        editProfileInformation(!information);

    }


    // Method to enable or disable the ability to edit information in profile page
    private void editProfileInformation(boolean editInformation) {

        // Enable or disable edit text fields
        // Edit information decides whether information can be edited or not
        EnterNameField.setEnabled(editInformation);
        EnterAgeField.setEnabled(editInformation);
        EnterUniversityField.setEnabled(editInformation);
        EnterUniversityCourseField.setEnabled(editInformation);
        EnterCurrentModulesField.setEnabled(editInformation);
        EnterCompletedModulesField.setEnabled(editInformation);

        // Change the button text based on edit information
        // If true, the user can edit information and set text to save, if false set text to add
        AddButton.setText(editInformation ? "Save" : "Add");

        // Set whether the user can edit profile information or not
        EditUserDetails = editInformation;
    }
}