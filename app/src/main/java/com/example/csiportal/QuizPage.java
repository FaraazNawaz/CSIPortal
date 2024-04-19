package com.example.csiportal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.csiportal.quiz.Quiz;
import com.example.csiportal.quiz.QuizDatabaseHelper;
import com.example.csiportal.quiz.QuizModule;
import com.example.csiportal.quiz.QuizQuestion;

import java.util.List;

public class QuizPage extends AppCompatActivity {

    // Request code for starting quiz activity
    private static final int REQUEST_CODE = 1;

    // Keys used to pass information to quiz activity from quiz page
    // Keys to pass module id to quiz activity, pass module name to quiz activity, pass quiz question level to quiz activity
    public static final String QUIZ_QUESTIONS_MODULE_ID = "quizQuestionsModuleId", QUIZ_QUESTIONS_MODULE_NAME = "quizQuestionsModuleName", QUIZ_QUESTIONS_LEVEL = "quizQuestionsLevel";


    // Keys used for shared preferences
    public static final String SHARED_PREFERENCES = "sharedPreferences", QUIZ_HIGHSCORE = "quizHighscore";

    // The variable to store users best quiz score
    private int highscore;

    // Text to see the users best quiz score
    private TextView QuizHighScore;

    // Spinner to select university module to get quiz questions for, spinner to select mode for get quiz questions for
    private Spinner QuizQuestionModuleSpinner, QuizQuestionLevelSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_page);

        //Set the title for the quiz page and allow back button to be enabled to go back to the home page
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Initialise text to see users best quiz score
        QuizHighScore = findViewById(R.id.QuizHighScore);
        // Initialise spinner to select mode to get quiz questions for
        QuizQuestionModuleSpinner = findViewById(R.id.QuizQuestionModuleSpinner);
        // Initialise spinner to select university module to get quiz questions for
        QuizQuestionLevelSpinner = findViewById(R.id.QuizQuestionLevelSpinner);


        // Load and show the high score from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        highscore = sharedPreferences.getInt(QUIZ_HIGHSCORE, 0);
        QuizHighScore.setText("Best Quiz Score: " + highscore);

        // Get quiz question modules from database
        QuizDatabaseHelper databaseHelper = new QuizDatabaseHelper(this);
        List<QuizModule> module = databaseHelper.getQuizModules();

        // Set up the adapter for the quiz module spinner
        ArrayAdapter<QuizModule> adapterQuizModule = new ArrayAdapter<>(this, R.layout.spinner_topic, module);

        // Set the layout for how the list of modules will look like
        adapterQuizModule.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        QuizQuestionModuleSpinner.setAdapter(adapterQuizModule);


        // Quiz questions levels to choose from before starting quiz
        String[] quizQuestionLevel = QuizQuestion.getAllQuestionLevels();

        // Set up adapter for the quiz question level spinner
        ArrayAdapter<String> adapterQuestionLevel  = new ArrayAdapter<String>(this, R.layout.spinner_topic, quizQuestionLevel);

        // Set the layout for how the list of modes will look like
        adapterQuestionLevel.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        QuizQuestionLevelSpinner.setAdapter(adapterQuestionLevel);


        // Button on the quiz page to begin quiz
        Button beginQuizButton = findViewById(R.id.BeginQuizButton);

        //OnClick listener for begin button to start the quiz
        beginQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Retrieve chosen module, module id, module name and question mode
                QuizModule chosenModule = (QuizModule) QuizQuestionModuleSpinner.getSelectedItem();
                int moduleID = chosenModule.getId();
                String quizModuleName = chosenModule.getModule();
                String questionLevel = QuizQuestionLevelSpinner.getSelectedItem().toString();

                // Start the quiz and pass module id, module name and question level information to quiz activity
                Intent intent = new Intent(QuizPage.this, Quiz.class);
                intent.putExtra(QUIZ_QUESTIONS_MODULE_ID, moduleID);
                intent.putExtra(QUIZ_QUESTIONS_MODULE_NAME, quizModuleName);
                intent.putExtra(QUIZ_QUESTIONS_LEVEL, questionLevel);

                // Begin quiz activity with the request code for starting quiz activity
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if result is from the quiz activity
        if (requestCode == REQUEST_CODE) {

            // Check if quiz was completed successfully
            if (resultCode == RESULT_OK) {

                // Get the quiz score from the quiz result
                int quizScore = data.getIntExtra(Quiz.POINTS, 0);

                // Update quiz best score if new score is higher than previous high score
                if (quizScore > highscore) {

                    // Update the quiz best score
                    highscore = quizScore;
                    // Update the quiz best score text
                    QuizHighScore.setText("Best Quiz Score: " + highscore);

                    // Save the new high score in shared preferences
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(QUIZ_HIGHSCORE, highscore);
                    editor.apply();
                }
            }
        }
    }
}