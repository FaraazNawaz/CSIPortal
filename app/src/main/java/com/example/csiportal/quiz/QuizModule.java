package com.example.csiportal.quiz;

// Represents module for quiz
public class QuizModule {

    // Constants which represent the five module ids
    public static final int MODULE_1 = 1, MODULE_2 = 2, MODULE_3 = 3, MODULE_4 = 4, MODULE_5 = 5;

    // Field for quiz module id
    private int id;

    // Field for quiz module name
    private String module;


    // Empty constructor to allow the creation of quiz module objects without parameters
    public QuizModule() {
        // Empty constructor
    }

    // Constructor to initialise quiz module using module name
    public QuizModule(String module) {

        this.module = module;
    }


    // Getter and Setter methods to get and set module id and name
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getModule() {return module;}

    public void setModule(String module) {this.module = module;}


    // Returns module name
    @Override
    public String toString() {
        return getModule();
    }
}
