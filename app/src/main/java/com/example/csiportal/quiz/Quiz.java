package com.example.csiportal.quiz;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csiportal.QuizPage;
import com.example.csiportal.R;


import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Quiz extends AppCompatActivity {

    // Key for passing quiz points to quiz page for the high score
    public static final String POINTS = "points";

    // Constant for countdown timer time which is in milliseconds
    private static final long COUNTDOWN_TIMER = 30050;

    //Quiz layout elements
    private TextView QuizPoints, QuizQuestionNumber, QuizQuestionModule, QuizQuestionLevel, QuizCountdownTimer, QuizQuestion;
    private RadioGroup QuizRadioGroup;
    private RadioButton QuizRadioButton1, QuizRadioButton2, QuizRadioButton3, QuizRadioButton4;
    private Button QuizConfirmAnswer;

    // Original text color state list for radio buttons for questions and countdown timer
    private ColorStateList originalTextColorQRB, originalTextColorCT;

    // List to hold quiz questions
    private List<QuizQuestion> quizQuestionList;

    // Counter to keep track what question is being shown, the total number of quiz questions in the quiz, quiz score the user got at the end of quiz
    private int quizQuestionCounter, totalQuizQuestion, quizScore;

    // The current quiz question being shown
    private QuizQuestion currentQuizQuestion;

    // Check whether the question has been answered
    private boolean quizQuestionAnswered;

    // Count down timer in the quiz
    private CountDownTimer countDownTimer;

    // Count down time remaining
    private long countDownTimeLeft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        //Set the title for the page where quiz takes place and allow back button to be enabled to go back to the quiz page
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialise quiz layout elements
        QuizPoints = findViewById(R.id.QuizPoints);
        QuizQuestionNumber = findViewById(R.id.QuizQuestionNumber);
        QuizQuestionModule = findViewById(R.id.QuizQuestionModule);
        QuizQuestionLevel = findViewById(R.id.QuizQuestionLevel);
        QuizCountdownTimer = findViewById(R.id.QuizCountdownTimer);
        QuizQuestion = findViewById(R.id.QuizQuestion);
        QuizRadioGroup = findViewById(R.id.QuizRadioGroup);
        QuizRadioButton1 = findViewById(R.id.QuizRadioButton1);
        QuizRadioButton2 = findViewById(R.id.QuizRadioButton2);
        QuizRadioButton3 = findViewById(R.id.QuizRadioButton3);
        QuizRadioButton4 = findViewById(R.id.QuizRadioButton4);
        QuizConfirmAnswer = findViewById(R.id.QuizConfirmAnswer);

        // Get module id, module name and question level from intent
        Intent intent = getIntent();
        int moduleID = intent.getIntExtra(QuizPage.QUIZ_QUESTIONS_MODULE_ID, 0);
        String quizModuleName = intent.getStringExtra(QuizPage.QUIZ_QUESTIONS_MODULE_NAME);
        String questionLevel = intent.getStringExtra(QuizPage.QUIZ_QUESTIONS_LEVEL);

        // Set module name and question mode information on the quiz screen
        QuizQuestionModule.setText("Module: " + quizModuleName);
        QuizQuestionLevel.setText("Mode: " + questionLevel);

        // Get quiz questions from the database
        QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
        quizQuestionList = quizDatabaseHelper.getSpecificQuizQuestions(moduleID, questionLevel);


        // Save original text color on radio buttons and timer
        originalTextColorQRB = QuizRadioButton1.getTextColors();
        originalTextColorCT = QuizCountdownTimer.getTextColors();

        // Initialise quiz variables
        totalQuizQuestion = quizQuestionList.size();

        // Shuffle quiz questions to make them random
        Collections.shuffle(quizQuestionList);


        // Show the first quiz question
        showQuizQuestion();


        // OnClickListener to see if confirm answer button has been clicked
        QuizConfirmAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if question has not been answered and check if any radio buttons are selected
                if (!quizQuestionAnswered) {
                    if (QuizRadioButton1.isChecked() || QuizRadioButton2.isChecked() || QuizRadioButton3.isChecked() || QuizRadioButton4.isChecked()){
                        // If there is a button selected, check the answer
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz.this, "Select an answer to the question to confirm", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // If question has been answered, move to the next question
                    showQuizQuestion();
                }
            }
        });

    }

    // Method to display the next quiz question
    private void showQuizQuestion(){
        // Reset the text color of radio buttons to original color
        QuizRadioButton1.setTextColor(originalTextColorQRB);
        QuizRadioButton2.setTextColor(originalTextColorQRB);
        QuizRadioButton3.setTextColor(originalTextColorQRB);
        QuizRadioButton4.setTextColor(originalTextColorQRB);
        // When new question appears, all radio buttons will be unselected
        QuizRadioGroup.clearCheck();

        if (quizQuestionCounter < totalQuizQuestion) {
            // Display the next quiz question
            currentQuizQuestion = quizQuestionList.get(quizQuestionCounter);
            QuizQuestion.setText(currentQuizQuestion.getQuizQuestion());
            QuizRadioButton1.setText(currentQuizQuestion.getQuizAnswer1());
            QuizRadioButton2.setText(currentQuizQuestion.getQuizAnswer2());
            QuizRadioButton3.setText(currentQuizQuestion.getQuizAnswer3());
            QuizRadioButton4.setText(currentQuizQuestion.getQuizAnswer4());

            // Update the quiz question counter and layout elements
            quizQuestionCounter++;
            QuizQuestionNumber.setText("Question: " + quizQuestionCounter + "/" + totalQuizQuestion);
            quizQuestionAnswered = false;
            QuizConfirmAnswer.setText("Confirm");

            // Restart the count down timer and start it for the next quiz question
            countDownTimeLeft = COUNTDOWN_TIMER;

            // Start the countdown timer for quiz questions
            countDownTimer = new CountDownTimer(countDownTimeLeft, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    countDownTimeLeft = millisUntilFinished;

                    // update countdown timer
                    int minutes = (int) (countDownTimeLeft / 1000) / 60;
                    int seconds = (int) (countDownTimeLeft / 1000) % 60;

                    // Format the time and update countdown timer text
                    String countDownTimerFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                    QuizCountdownTimer.setText(countDownTimerFormat);

                    // Change text color to red if timer is less than 10 seconds
                    if (countDownTimeLeft < 10000) {
                        QuizCountdownTimer.setTextColor(Color.RED);
                    } else {
                        QuizCountdownTimer.setTextColor(originalTextColorCT);
                    }

                }

                @Override
                public void onFinish() {
                    countDownTimeLeft = 0;
                    // update countdown timer
                    int minutes = (int) (countDownTimeLeft / 1000) / 60;
                    int seconds = (int) (countDownTimeLeft / 1000) % 60;

                    // Format the time and update countdown timer text
                    String countDownTimerFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                    QuizCountdownTimer.setText(countDownTimerFormat);

                    // Change text color to red if timer is less than 10 seconds
                    if (countDownTimeLeft < 10000) {
                        QuizCountdownTimer.setTextColor(Color.RED);
                    } else {
                        QuizCountdownTimer.setTextColor(originalTextColorCT);
                    }

                    // If the time has finished, check the correct answer automatically
                    checkAnswer();
                }
            }.start();

        } else {

            // If all quiz questions have been answered, complete the quiz and return with quiz result to quiz page activity
            Intent quizPointsIntent = new Intent();
            quizPointsIntent.putExtra(POINTS, quizScore);
            setResult(RESULT_OK, quizPointsIntent);
            finish();
        }
    }


    // Method to check answer with the correct answer
    private void checkAnswer(){
        // The question has been answered
        quizQuestionAnswered = true;
        // Stop the countdown timer
        countDownTimer.cancel();

        // Get the index of selected radio button
        RadioButton selectedRadioButton = findViewById(QuizRadioGroup.getCheckedRadioButtonId());
        int radioButtonNumber = QuizRadioGroup.indexOfChild(selectedRadioButton) + 1;

        // Check if selected answer is correct and update the score in quiz
        if (radioButtonNumber == currentQuizQuestion.getQuizCorrectAnswer()){
            quizScore++;
            QuizPoints.setText("Points: " + quizScore);
        }

        // Show the correct answer
        // Set the text color to red for all radio buttons
        QuizRadioButton1.setTextColor(Color.RED);
        QuizRadioButton2.setTextColor(Color.RED);
        QuizRadioButton3.setTextColor(Color.RED);
        QuizRadioButton4.setTextColor(Color.RED);

        // Set the text color to green for the correct answer using switch statement
        switch (currentQuizQuestion.getQuizCorrectAnswer()) {

            case 1:
                QuizRadioButton1.setTextColor(Color.GREEN);
                QuizQuestion.setText("Answer 1 was the correct answer");
                break;
            case 2:
                QuizRadioButton2.setTextColor(Color.GREEN);
                QuizQuestion.setText("Answer 2 was the correct answer");
                break;
            case 3:
                QuizRadioButton3.setTextColor(Color.GREEN);
                QuizQuestion.setText("Answer 3 was the correct answer");
                break;
            case 4:
                QuizRadioButton4.setTextColor(Color.GREEN);
                QuizQuestion.setText("Answer 4 was the correct answer");
                break;

        }
        // Update the confirm answer button text based on the quiz progress made
        if (quizQuestionCounter < totalQuizQuestion) {
            QuizConfirmAnswer.setText("Next Question");
        } else {

            // All questions have been answered and the user can finish the quiz
            QuizConfirmAnswer.setText("Finish Quiz");
        }
    }
}