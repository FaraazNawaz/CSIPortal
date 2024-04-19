package com.example.csiportal.quiz;

// Represents quiz question
public class QuizQuestion {

    // The levels for the quiz questions
    public static final String QUESTION_LEVEL_1 = "Easy", QUESTION_LEVEL_2 = "Medium", QUESTION_LEVEL_3 = "Hard";


    // Id for the quiz question, the correct quiz question answer, the id of the university module the quiz question belongs to
    private int id, quizCorrectAnswer, moduleID;

    // The quiz question user will answer, the quiz question level
    private String quizQuestion, questionLevel;

    // The numbers of options available for the user to select an answer from
    private String quizAnswer1, quizAnswer2, quizAnswer3, quizAnswer4;



    // Empty constructor to allow the creation of quiz question objects without parameters
    public QuizQuestion() {
        // Empty constructor
    }

    // Constructor to initialise quiz question
    public QuizQuestion(String quizQuestion, String quizAnswer1, String quizAnswer2, String quizAnswer3, String quizAnswer4, int quizCorrectAnswer, String questionLevel, int moduleID) {
        this.quizQuestion = quizQuestion;
        this.quizAnswer1 = quizAnswer1;
        this.quizAnswer2 = quizAnswer2;
        this.quizAnswer3 = quizAnswer3;
        this.quizAnswer4 = quizAnswer4;
        this.quizCorrectAnswer = quizCorrectAnswer;
        this.questionLevel = questionLevel;
        this.moduleID = moduleID;
    }


    // Getter and Setter methods for all quiz question fields
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizAnswer1() {
        return quizAnswer1;
    }

    public void setQuizAnswer1(String quizAnswer1) {
        this.quizAnswer1 = quizAnswer1;
    }

    public String getQuizAnswer2() {
        return quizAnswer2;
    }

    public void setQuizAnswer2(String quizAnswer2) {
        this.quizAnswer2 = quizAnswer2;
    }

    public String getQuizAnswer3() {
        return quizAnswer3;
    }

    public void setQuizAnswer3(String quizAnswer3) {
        this.quizAnswer3 = quizAnswer3;
    }

    public String getQuizAnswer4() {
        return quizAnswer4;
    }

    public void setQuizAnswer4(String quizAnswer4) {
        this.quizAnswer4 = quizAnswer4;
    }

    public int getQuizCorrectAnswer() {
        return quizCorrectAnswer;
    }

    public void setQuizCorrectAnswer(int quizCorrectAnswer) {this.quizCorrectAnswer = quizCorrectAnswer;}

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }


   // Method to get all question levels
    public static String[] getAllQuestionLevels() {

        // Return an array of strings of all question levels.
        return new String[] { QUESTION_LEVEL_1, QUESTION_LEVEL_2, QUESTION_LEVEL_3 };
    }
}
