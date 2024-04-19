package com.example.csiportal.quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class QuizDatabaseHelper extends SQLiteOpenHelper {

    // Database information
    // Name of database
    private static final String DATABASE_NAME = "CSIPortalQuiz.db";

    // Database version
    private static final int DATABASE_VERSION = 1;

    //Quiz modules table
    public static final String TABLE_QUIZ_MODULES = "quiz_modules";
    public static final String COLUMN_MODULE_ID = "module_id";
    public static final String COLUMN_MODULE_NAME = "module_name";


    //Quiz questions table
    public static final String TABLE_NAME = "quiz_questions";
    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUIZ_QUESTION = "question";
    public static final String COLUMN_QUIZ_ANSWER1 = "answer1";
    public static final String COLUMN_QUIZ_ANSWER2 = "answer2";
    public static final String COLUMN_QUIZ_ANSWER3 = "answer3";
    public static final String COLUMN_QUIZ_ANSWER4 = "answer4";
    public static final String COLUMN_QUIZ_CORRECT_ANSWER = "correct_answer";
    public static final String COLUMN_QUESTION_LEVEL = "question_level";
    public static final String COLUMN_QUIZ_MODULE_ID = "quiz_module_id";


    // Database instance
    private SQLiteDatabase db;


    // Constructor for quiz database helper
    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Method called when the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Set the database instance
        this.db = db;

        // SQL statement to create the quiz module table
        final String CREATE_QUIZ_MODULES_TABLE = "CREATE TABLE " +
                TABLE_QUIZ_MODULES + " (" +
                COLUMN_MODULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MODULE_NAME + " TEXT " +
                ")";

        // SQL statement to create the quiz questions table
        final String CREATE_QUIZ_QUESTIONS_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUIZ_QUESTION + " TEXT, " +
                COLUMN_QUIZ_ANSWER1 + " TEXT, " +
                COLUMN_QUIZ_ANSWER2 + " TEXT, " +
                COLUMN_QUIZ_ANSWER3 + " TEXT, " +
                COLUMN_QUIZ_ANSWER4 + " TEXT, " +
                COLUMN_QUIZ_CORRECT_ANSWER + " INTEGER, " +
                COLUMN_QUESTION_LEVEL + " TEXT, " +
                COLUMN_QUIZ_MODULE_ID + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_QUIZ_MODULE_ID + ") REFERENCES " +
                TABLE_QUIZ_MODULES + "(" + COLUMN_MODULE_ID + ")" + "ON DELETE CASCADE" +
                ")";


        // Create the quiz modules table
        db.execSQL(CREATE_QUIZ_MODULES_TABLE);
        // Create the quiz questions table
        db.execSQL(CREATE_QUIZ_QUESTIONS_TABLE);

        // Fill quiz module and quiz questions table with information
        fillQuizModuleTable();
        fillQuizQuestionsTable();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // Method to insert a quiz module into the database
    private void insertQuizModule(QuizModule module) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MODULE_NAME, module.getModule());

        // Insert the values into the quiz module table
        db.insert(TABLE_QUIZ_MODULES, null, values);

    }

    // Method to fill the quiz module table with modules
    private void fillQuizModuleTable() {
        // The name of the module being added to the table
        QuizModule module1 = new QuizModule("Software Project Management");
        // Insert the module into the database
        insertQuizModule(module1);
        QuizModule module2 = new QuizModule("Human Computer Interaction");
        insertQuizModule(module2);
        QuizModule module3 = new QuizModule("Information Security");
        insertQuizModule(module3);
        QuizModule module4 = new QuizModule("Mobile Design and Development");
        insertQuizModule(module4);
        QuizModule module5 = new QuizModule("Introduction to Artificial Intelligence");
        insertQuizModule(module5);

    }


    // Method to save questions to the database
    private void insertQuestion(QuizQuestion quizQuestion) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUIZ_QUESTION, quizQuestion.getQuizQuestion());
        values.put(COLUMN_QUIZ_ANSWER1, quizQuestion.getQuizAnswer1());
        values.put(COLUMN_QUIZ_ANSWER2, quizQuestion.getQuizAnswer2());
        values.put(COLUMN_QUIZ_ANSWER3, quizQuestion.getQuizAnswer3());
        values.put(COLUMN_QUIZ_ANSWER4, quizQuestion.getQuizAnswer4());
        values.put(COLUMN_QUIZ_CORRECT_ANSWER, quizQuestion.getQuizCorrectAnswer());
        values.put(COLUMN_QUESTION_LEVEL, quizQuestion.getQuestionLevel());
        values.put(COLUMN_QUIZ_MODULE_ID, quizQuestion.getModuleID());

        // Insert the values into the quiz questions table
        db.insert(TABLE_NAME, null, values);
    }


    // Method to fill the quiz questions table with questions
    private void fillQuizQuestionsTable() {
        // The question text, the question answer options, the correct answer, the quiz question mode and the module the question will belong to
        QuizQuestion q1 = new QuizQuestion(" Which of the following can describe a measurement?", " Value obtained on a particular scale", " CM", " MM", " Metres", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        // Insert the question into the database
        insertQuestion(q1);
        QuizQuestion q2 = new QuizQuestion("Which is an example of a measurement?", " Scales", " Elapsed time", " Volume", " Object", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q2);
        QuizQuestion q3 = new QuizQuestion("What may a measurement require?", " Ruler", " Timer", " Measurement Instrument", " Clock", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q3);
        QuizQuestion q4 = new QuizQuestion("Which of the following is an example of a direct measurement?", " Time", " Grams", " Length of object", " Length of source code", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q4);
        QuizQuestion q5 = new QuizQuestion(" How are indirect measurements calculated?", " From direct measurements", " From rulers", " From timed measurements", " From normal measurements", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q5);
        QuizQuestion q6 = new QuizQuestion("Which one of the following is an example of an indirect measurement?", " Working hours", " Programmer productivity", " Time spent fixing problem", " Size of code", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q6);
        QuizQuestion q7 = new QuizQuestion(" How can a measurement be valid?", " Inaccurate, Unreliable, Unmeaningful", " Measurement is correct", " Accurate, Reliable, Meaningful", " Reliable", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q7);
        QuizQuestion q8 = new QuizQuestion(" What do inaccurate measure do?", " Produces no estimates", " Produces good estimates", " Produces correct values", " Produces incorrect values", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q8);
        QuizQuestion q9 = new QuizQuestion(" How many scale types are there? ", "5", "2", "4", "3", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q9);
        QuizQuestion q10 = new QuizQuestion("Which measurement scale is used when assessing the programming languages used in a software project? The data includes: Python, Java, C++, Ruby, and PHP.", " Ordinal", " Nominal ", " Interval", " Ratio", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_1);
        insertQuestion(q10);
        QuizQuestion q11 = new QuizQuestion(" Which measurement scale is used when rating the quality of customer service on a scale of 1 to 5, with 1 being \"Poor\" and 5 being \"Excellent?", " Absolute", " Interval ", " Ordinal", " Nominal ", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q11);
        QuizQuestion q12 = new QuizQuestion("Which measurement scale is used when measuring the temperature in degrees Celsius, where 0°C represents freezing point?", " Ordinal", " Nominal", " Absolute", " Interval ", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q12);
        QuizQuestion q13 = new QuizQuestion(" Which measurement scale is used when measuring the time taken by a computer program to execute various tasks in seconds?", " Ratio", " Nominal", " Ordinal ", " Interval ", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q13);
        QuizQuestion q14 = new QuizQuestion(" Which measurement scale is used when counting the number of errors in a software code?", " Interval", " Ratio/ Absolute", " Ordinal ", " Ratio", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q14);
        QuizQuestion q15 = new QuizQuestion(" Which measurement scale is used when measuring outdoor temperatures in degrees Celsius for a week?", " Absolute", " Ordinal ", " Interval ", " Ratio", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q15);
        QuizQuestion q16 = new QuizQuestion(" What is estimation?", " A risk", " A prediction", " A educated guess", " Predicting an expected value for some attribute", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q16);
        QuizQuestion q17 = new QuizQuestion(" How is the uncertainty of estimation expressed?", " Probability", " Time", " Entity", " Size", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q17);
        QuizQuestion q18 = new QuizQuestion("What do we estimate?", " Time", " What we cannot measure.", " Predictions", " Measurements", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q18);
        QuizQuestion q19 = new QuizQuestion(" When is estimation mostly needed?", " Quick decisions", " Saving time", " Planning a project", " Spending money", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q19);
        QuizQuestion q20 = new QuizQuestion("Which of the following is a way to improve estimations?", " Don’t use past projects as examples", " Fast estimations", " Spend more time on estimates", " Decomposition", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_1);
        insertQuestion(q20);
        QuizQuestion q21 = new QuizQuestion("How many steps does Step Wise possess?", "10", "5", "7", "2", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q21);
        QuizQuestion q22 = new QuizQuestion("How many processes does PRINCE2 possess?", "2", "7", "3", "4", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q22);
        QuizQuestion q23 = new QuizQuestion(" What is the last step of PRINCE2?", " Initiating a project", " Starting up a project", " Closing the project", " Directing a project", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q23);
        QuizQuestion q24 = new QuizQuestion("What is the definition of risk?", " Time of event", " Estimation of bad event", " Known event that can hurt project", " Uncertain event that can have an impact on project", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q24);
        QuizQuestion q25 = new QuizQuestion(" What impact can risks have on a project?", " Positive or Negative", " No impact", " Only Negative ", " Only Positive", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q25);
        QuizQuestion q26 = new QuizQuestion("One main reason why risk planning not widely used?", " Not good to use", " Lack of awareness of approach", " Hard to perform", " Risks are not important", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q26);
        QuizQuestion q27 = new QuizQuestion(" What does PERT stand for?", " Process and Estimation Technique", " Process and Evaluation Technique", " Program and Evaluation Technique", " Program and Estimation Technique", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q27);
        QuizQuestion q28 = new QuizQuestion(" What are the two types of checkpoints to assess progress?", " Task driven and Time Driven", " Estimation- driven and Task Driven", " Estimation- driven and Time Driven", " Event- driven and Time Driven", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q28);
        QuizQuestion q29 = new QuizQuestion("Which one of following is a functionality sub-characteristic?", " Accuracy", " Changeability", " Time behaviour", " Fault tolerance", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q29);
        QuizQuestion q30 = new QuizQuestion("Which one of the following is a SCRUM event?", " Redecorate your wall", " Sprint planning", " Define done", " Weekly stand-up", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_1);
        insertQuestion(q30);

        QuizQuestion q31 = new QuizQuestion("Why do we need to understand users?", " Establish what users can and cannot be expected to do", "Help make more money", " Understand users feelings", " Get better understanding of their issues ", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q31);
        QuizQuestion q32 = new QuizQuestion("What is cognition?", " Physical process ", " What goes on inside our heads like thinking", " Sleeping", " What goes on inside our body", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q32);
        QuizQuestion q33 = new QuizQuestion("What are the number of modes of cognition according to Norman?", "3", "1", "2", "4", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q33);
        QuizQuestion q34 = new QuizQuestion("What is involved in interaction design?", " Not considering user needs", " A risk to designs", " A estimation of time", " A plan for development", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q34);
        QuizQuestion q35 = new QuizQuestion("What is the importance of involving users in design? ", " Realistic Expectations", " Gather money for design", " Ask them to make product", " Leaving decision to users", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q35);
        QuizQuestion q36 = new QuizQuestion(" Which is a core component of cognition?", " Sleeping", " Perception and Recognition", " Running", " Not planning ahead", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q36);
        QuizQuestion q37 = new QuizQuestion("What does UCD stand for?", " User Centred Decisions", " Usability Centred Design", " User Centred Design", " Usability Centred Development", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q37);
        QuizQuestion q38 = new QuizQuestion(" What is UCD?", " A method to gather information", " Philosophy", " Design process", " A philosophy as well as a design process", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q38);
        QuizQuestion q39 = new QuizQuestion(" What is the first stage in interaction design?", " Discovery phase", " Requirements phase", " Development phase", " Planning phase", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q39);
        QuizQuestion q40 = new QuizQuestion("What is one thing we learn from the discovery phase in interaction design?", " Bugs in code", " People who are involved with the work", " Design issues", " Testing problems", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_2);
        insertQuestion(q40);
        QuizQuestion q41 = new QuizQuestion("What is driving a car an example of?", " Experiential Cognition", " Ability", " Designing", " Cognition", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q41);
        QuizQuestion q42 = new QuizQuestion("What is designing an example of?", " Cognition", " Reflective Cognition", " Experiential Cognition", " Human Ability", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q42);
        QuizQuestion q43 = new QuizQuestion(" What is an example of a prototype?", " A finished product", " A nearly completed product", " A series of screen sketches", " A product that has no designs", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q43);
        QuizQuestion q44 = new QuizQuestion(" What is prototyping a good option?", " Do not need to involve users", " Lets designers make final design", " It is not a good idea to prototype", " Lets designers try out ideas", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q44);
        QuizQuestion q45 = new QuizQuestion("What does a full prototype contain?", " Complete functionality but not full performance", " Completed end product", " Complete functionality and full performance", " No functionality at all", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q45);
        QuizQuestion q46 = new QuizQuestion("What does a horizontal prototype contain?", " Lower level functionality and lower level details", " High level functionality but no lower level details", " High level functionality and high level details", " No functionality and no details", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q46);
        QuizQuestion q47 = new QuizQuestion("What does a vertical prototype contain?", " Low level details", " High and low level details", " High and low level functionality", " No functionality", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q47);
        QuizQuestion q48 = new QuizQuestion("What is a feature of low-fidelity prototyping?", " Expensive", " Fast and expensive", " Slow and cheap", " Cheap and fast", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q48);
        QuizQuestion q49 = new QuizQuestion(" Which statement is correct?", " Global prototypes are useful throughout the entire design process", " Global prototypes are not useful at all", " Global prototypes are only useful at the beginning", " Global prototypes are only useful at the end", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q49);
        QuizQuestion q50 = new QuizQuestion("What is knowledge elicitation?", " Time spent making a design", " Data gathering for informing a design", " How much knowledge user has", " Data gathering of materials", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_2);
        insertQuestion(q50);
        QuizQuestion q51 = new QuizQuestion("Which one of the following is correct regarding knowledge elicitation?", " Used to generate initial design idea", " Not used for anything design related", " Useful for planning stages", " Useful for testing product", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q51);
        QuizQuestion q52 = new QuizQuestion("Which is functional requirements identification a goal of?", " Evaluation", " Knowledge Elicitation", " Evaluation Elicitation", " Risk Analysis", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q52);
        QuizQuestion q53 = new QuizQuestion(" Which one of the following is a goal of evaluation?", " Testing of system", " Gathering requirements for system", " Usability of system", " Planning for system development", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q53);
        QuizQuestion q54 = new QuizQuestion("What does evaluation let us do?", " Gather requirements", " Design system for implementation", " Plan for system development", " Compare designs", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q54);
        QuizQuestion q55 = new QuizQuestion("What is memory a core component of?", " Cognition", " Attention", " Learning", " Reading", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q55);
        QuizQuestion q56 = new QuizQuestion(" What senses does attention involve?", " Auditory senses", " Auditory and Visual senses", " Visual senses", " Touch", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q56);
        QuizQuestion q57 = new QuizQuestion(" What does perception refer to?", " How information is lost", " How information is lost using our senses", " How information is acquired using our senses", " How information is gathered without our senses.", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q57);
        QuizQuestion q58 = new QuizQuestion(" What is the most dominant sense for sighted people?", "Hearing", " Touch", " Feel", " Vision ", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q58);
        QuizQuestion q59 = new QuizQuestion("Which of the following is one of the 4 basic interaction design activities?", " Identifying needs and establishing requirements", " Identifying money", " Gathering requirements ", " Planning for risk", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q59);
        QuizQuestion q60 = new QuizQuestion("What is conceptual design?", " Model describing user requirements", " Model describing what design should do, look like and behave", " Model showing risks of design", " Model describing what design should not do", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_2);
        insertQuestion(q60);

        QuizQuestion q61 = new QuizQuestion(" What is information security concerned with protecting?", " Computer-System Assets", " Time", " Staff", " Computer-System Costs", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q61);
        QuizQuestion q62 = new QuizQuestion(" What does Cryptography mean?", " Secret Spelling", "Secret Writing", " Secret Resources", " Special Writing", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q62);
        QuizQuestion q63 = new QuizQuestion(" What is Cryptography?", " The art and science of money", " The art and science of planning", " The art and science of concealing meaning", " The art and science of exposing meaning", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q63);
        QuizQuestion q64 = new QuizQuestion(" What one of the following is correct when talking about Cryptography?", " Weakest control tool against security threats", " Strongest planning tool against security threats", " Control tool used for tracking expenditure", " Strongest control tool against security threats", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q64);
        QuizQuestion q65 = new QuizQuestion(" What is encryption?", "Process of scrambling message so that it is not obvious", " Process of unscrambling message", " Process of hiding message forever", " Process of figuring out messages", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q65);
        QuizQuestion q66 = new QuizQuestion(" What is decryption?", " Process of hiding message forever", "  Process of unscrambling message ", "Process of identifying requirements", " Process of scrambling message to hide it.", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q66);
        QuizQuestion q67 = new QuizQuestion("What device can be used for encryption and decryption?", " Ruler", " Car", " Key", " Television", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q67);
        QuizQuestion q68 = new QuizQuestion("What is the meaning of a Cryptosystem?", " A system for only encryption", " A system for only decryption ", " A system for planning ", " A system for encryption and decryption", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q68);
        QuizQuestion q69 = new QuizQuestion(" Which one of the following statements is correct?", " A cryptosystem is a 5-tuple", " A cryptosystem is a 1-tuple", " A cryptosystem is a 3-tuple", " A cryptosystem is a 7-tuple", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q69);
        QuizQuestion q70 = new QuizQuestion("What does P stand for in a cryptosystem?", " Set of ciphertext units", " Set of plaintext units", " Set of keys", " Set of numbers", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_3);
        insertQuestion(q70);
        QuizQuestion q71 = new QuizQuestion("What does C stand for in a cryptosystem?", " Set of cipher text units", " Set of plaintext units", " Set of keys", " Set of numbers", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q71);
        QuizQuestion q72 = new QuizQuestion("What does K stand for in a cryptosystem?", " Set of cipher text units", " Set of keys", " Set of plaintext units ", " Set of numbers", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q72);
        QuizQuestion q73 = new QuizQuestion(" What does E stand for in a cryptosystem?", " C x K → P is the decryption function", " Set of numbers", "P x K → C is the encryption function", " Set of plaintext units", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q73);
        QuizQuestion q74 = new QuizQuestion("What does D stand for in a cryptosystem?", " Set of plaintext units", " P x K → C is the encryption function", " Set of keys", " C x K → P is the decryption function", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q74);
        QuizQuestion q75 = new QuizQuestion("What Cipher was said to have been first used by Julius Caesar?", " Caesar Cipher", " Encryption Cipher", "Decryption Cipher", " No Cipher", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q75);
        QuizQuestion q76 = new QuizQuestion("What is User Authentication?", " Identifying a user of a car", " Identifying a user of an IT system", " Identifying user requirements", " Identifying a user’s age", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q76);
        QuizQuestion q77 = new QuizQuestion(" What one of the following is an authentication mechanism characteristic?", " What the computer knows", " What the computer doesn’t know", " What the users knows", " What the user spends money on", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q77);
        QuizQuestion q78 = new QuizQuestion("What is a common way for users to prove their identity?", " Users Car", " ID", " Spending Money", " Username and Password", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q78);
        QuizQuestion q79 = new QuizQuestion(" What is a password?", " A sequence of characters", " A sequence of only numbers", " A sequence of only letters", " A way to destroy information", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q79);
        QuizQuestion q80 = new QuizQuestion("How can a security attack be prevented? ", " Keep authentication information exposed", " Keep authentication information secret", " Tell other people about person information", " It cannot be prevented ", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_3);
        insertQuestion(q80);
        QuizQuestion q81 = new QuizQuestion(" What is the problem when using passwords?", " People pick easy to guess passwords", " People pick hard to guess passwords", " People don’t set passwords", " Passwords are not secure", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q81);
        QuizQuestion q82 = new QuizQuestion(" What is the meaning of a program?", " Hardware asset of an information system", " Software asset of an information system", " Software and hardware asset", " Programming language", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q82);
        QuizQuestion q83 = new QuizQuestion(" Which one of the following is an example of a program?", " Hardware", " Car", " Software Application", " Pen", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q83);
        QuizQuestion q84 = new QuizQuestion(" Which one of the following statements is correct?", " Programs are not essential to information systems", " Programs are hardware", " Programs are not useful", " Programs are essential components of information systems", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q84);
        QuizQuestion q85 = new QuizQuestion(" What is an error?", " A mistake made by a human", " A well informed decision", " A correct decision made by a human", " A well justified decision", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q85);
        QuizQuestion q86 = new QuizQuestion("What is a fault?", " Correct Step or command in computer program", " Incorrect Step or command in computer program", " A well informed decision", " A correct command in a computer program", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q86);
        QuizQuestion q87 = new QuizQuestion(" What does improper validation refer to?", " Something checked for consistency or correctness", " A good decision that has been made", " Something not checked for consistency or correctness", " Something not checked for cost", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q87);
        QuizQuestion q88 = new QuizQuestion("What is malicious code?", " Code developed to fix issues", " Code developed to plan", " Code developed to work as intended", " Code developed to cause loss or harm", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q88);
        QuizQuestion q89 = new QuizQuestion("What are computer networks? ", " Sets of interconnected computers", " A single computer", " A set unconnected computers", " An internet connection", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q89);
        QuizQuestion q90 = new QuizQuestion("What does LAN stand for?", " Local Access Network ", " Local Area Network", " Limited Area Network", " Limited Access Network", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_3);
        insertQuestion(q90);

        QuizQuestion q91 = new QuizQuestion("Which one of the following statements is correct? ", "Mobile phones are truly personal devices", " Mobile phones are not personal devices", " Mobile phones make people feel scared", " Mobile phones are not used a lot", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q91);
        QuizQuestion q92 = new QuizQuestion("Which one of the following is a key reason for poor mobile design?", " Financial Long-Termism", " Financial Short-Termism", " Planning", " Risks", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q92);
        QuizQuestion q93 = new QuizQuestion(" Which one of the following is a key reason for poor mobile design?", " Product price is lower for better designs", " Product quality is more visible than price", " Product price is more visible than quality", " Product has many features", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q93);
        QuizQuestion q94 = new QuizQuestion(" Which one of the following is a key reason for poor mobile design?", " Risk planning", " Quality interaction design decreases production costs", " Less quality the better the production costs", " Quality interaction design increases production costs", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q94);
        QuizQuestion q95 = new QuizQuestion(" What does techno-fixation stand for?", " Emphasis on technology over purpose", " Emphasis on purpose over technology", " Emphasis on money over technology", " Emphasis on purpose over money", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q95);
        QuizQuestion q96 = new QuizQuestion(" Which one of the following is an impact of poor mobile design?", " Financial Impact", " Emotional Impact", " Environmental Impact", " None of these", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q96);
        QuizQuestion q97 = new QuizQuestion("Which one of the following is an impact of poor mobile design?", " Technological Impact", " Physical Impact", " Economical Impact", " None of these", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q97);
        QuizQuestion q98 = new QuizQuestion(" Which one of the following is an impact of poor mobile design?", " Technological Impact", " Physical Impact", " None of these", " Ethical Impact", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q98);
        QuizQuestion q99 = new QuizQuestion("What can spotting flaws at a late stage cause a developer?", " Cognitive Dissonance", " Happiness", " Money issues", " Cognitive tension", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q99);
        QuizQuestion q100 = new QuizQuestion(" What will we see without effective mobile design?", " Positive emotional impacts ", " Negative emotional impacts", " No impact at all", " Positive ethical impacts", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_4);
        insertQuestion(q100);
        QuizQuestion q101 = new QuizQuestion(" What is our motivation in mobile design?", " Discover things that people really want to do", " Spend more money on designs", " Spend a lot of time gathering requirements", " Spend less time with users", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q101);
        QuizQuestion q102 = new QuizQuestion(" What do we need to seek to produce in mobile design?", " Services that users don’t want to use", " Services that users want to use and spend money on", " Services that users will not spend money on", " Services that users will need to spend more money on", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q102);
        QuizQuestion q103 = new QuizQuestion("Which one of the following statements is correct? ", " Users never stop using devices", " Users never abandon apps", " User repeatedly abandon devices/apps", " Hard to use apps are best for users", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q103);
        QuizQuestion q104 = new QuizQuestion("What does usability refer to?", " The cost of a system", " The way you design a system", " The way you plan to use a system", " The way you control and operate the system", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q104);
        QuizQuestion q105 = new QuizQuestion(" Which one of the following is an example of a form of poor usability?", " Ease of use", " Difficulty of use", " Easy use of system", " Poorly designed system", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q105);
        QuizQuestion q106 = new QuizQuestion(" Which one of the following is an example of a form of poor usability?", " Easy use of system", " Fit-In-Context", " Fit-In-Content", " Poor Context", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q106);
        QuizQuestion q107 = new QuizQuestion("What is meant by ease of use?", " Whether the user can operate the device", " Whether the device or service is designed poorly", " Whether the device or service is usable in itself", " How much time it takes to use device", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q107);
        QuizQuestion q108 = new QuizQuestion(" What is meant by fit-in-context?", " How the device fits in users hands", " How hard the device is to use", " Whether the device works as intended", " Whether the device works in harmony with the things around it.", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q108);
        QuizQuestion q109 = new QuizQuestion(" What is meant by the identity of a product?", " The message the device sends to users and makes them feel", " The requirements of a device", " The design of a device", " The cost of a device", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q109);
        QuizQuestion q110 = new QuizQuestion(" Which of the following statements is correct?", " Mobile is only mobile phones", " Mobile are not only mobile phones", " Mobile is not about mobiles phones", " None of these", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_4);
        insertQuestion(q110);
        QuizQuestion q111 = new QuizQuestion("Which of the following is an example of a type of innovation?", " Increasingly sophisticated camera phones", " Price of phones", " Size of phones", " Less sophisticated camera phones", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q111);
        QuizQuestion q112 = new QuizQuestion("Which one of the following is an innovation strategy?", " Don’t take successful approaches on PC and use them for mobile", " Take approaches successful on PC and bring them to mobile", " Copy everything that PC does", " Take risky approaches and use them for mobiles", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q112);
        QuizQuestion q113 = new QuizQuestion(" What might help cut down on learning needed to use mobile devices?", " Give UI an unfamiliar look and feel", " Don’t look at user requirements.", " Give UI familiar look and feel", " Give UI a completely new design", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q113);
        QuizQuestion q114 = new QuizQuestion("Which of the following statements is correct?", " None of these", " Mobiles should be used to modify human behaviour", " Mobiles should not be used to augment human behaviour", " Mobiles should be used to augment human behaviour, not modify it", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q114);
        QuizQuestion q115 = new QuizQuestion("Which one of the following is true?", " Menus on small screens cause issues", " Menus on small screens do not cause issues", " Menus on small screens are perfect", " None of these.", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q115);
        QuizQuestion q116 = new QuizQuestion("What is the number of fundamental information activities?", "1", "2", "3", "4", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q116);
        QuizQuestion q117 = new QuizQuestion("Which one of the following is a fundamental information activity?", " Watching", " Reading", " Browsing", " None of these", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q117);
        QuizQuestion q118 = new QuizQuestion(" Which one of the following is a fundamental information activity?", " Typing", " Deleting", " None of these", " Searching", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q118);
        QuizQuestion q119 = new QuizQuestion("Which one of the following is a reason for evaluation?", " You will never second-guess how people see your designs", " Make more money", " Testing the design", " None of these", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q119);
        QuizQuestion q120 = new QuizQuestion("What type of results do interviews produce?", " Only Qualitative", " Typically qualitative", " Both Qualitative and quantitative", " None of these.", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_4);
        insertQuestion(q120);

        QuizQuestion q121 = new QuizQuestion("What is Artificial Intelligence?", " Design of computer system that exhibits human behaviour", " Design of good-looking computer system", " Design of low-cost computer system", " Design of computer system that acts like a computer", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q121);
        QuizQuestion q122 = new QuizQuestion(" Which one of the following is an example of how AI has transformed the IT industry? ", " Money", " Search Engine", " Time ", " None of these", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q122);
        QuizQuestion q123 = new QuizQuestion("Which one of the following is an example of how AI has transformed the IT industry?", " Better designs", " Increased Jobs", " Speech Recognition", " None of these", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q123);
        QuizQuestion q124 = new QuizQuestion("Which one of the following is an example of how AI has transformed the IT industry?", " Money", " More experience", " None of these", " Machine Translation", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q124);
        QuizQuestion q125 = new QuizQuestion("Which one of the following is an example of how AI has transformed the IT industry?", " Recommendation Systems", " Money", " More jobs", " None of these ", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q125);
        QuizQuestion q126 = new QuizQuestion(" What one of the following statements is correct about thinking humanly?", " Build a machine that does not think like a human", " Build a machine that thinks like a human", " Make humans think more like machines", " None of these", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q126);
        QuizQuestion q127 = new QuizQuestion("Which one of the following is a way a computer can convince an interrogator of its intelligence? ", " Not generate human language", " Not understand human language", " Understand and generate language", " None of these", 3, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q127);
        QuizQuestion q128 = new QuizQuestion("Which one of the following is a way a computer can convince an interrogator of its intelligence?", " None of these", " Speak english", " Don’t know about the world", " Know about the world ", 4, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q128);
        QuizQuestion q129 = new QuizQuestion(" Which one of the following is a way a computer can convince an interrogator of its intelligence?", " Reason about the world", " Not reason about the world", " Do not have any opinions", " None of these", 1, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q129);
        QuizQuestion q130 = new QuizQuestion(" Which one of the following is a way a computer can convince an interrogator of its intelligence?", " Don’t perform machine learning", " Learn about the dialogue and the interrogator", " Don’t act suspicious", " None of these", 2, QuizQuestion.QUESTION_LEVEL_1, QuizModule.MODULE_5);
        insertQuestion(q130);
        QuizQuestion q131 = new QuizQuestion(" Which one of the following is a way a computer can convince an interrogator of its intelligence?", " Combine all knowledge and reasoning instantaneously ", " Don’t act too smart", " Don’t combine knowledge and reasoning", " None of these", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q131);
        QuizQuestion q132 = new QuizQuestion("Which one of the following is an example of how an agent can be viewed as?", " Not perceiving its environment through sensors", " Perceiving its environment through sensors", " Viewed as a human", " None of these", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q132);
        QuizQuestion q133 = new QuizQuestion(" Which one of the following is an example of how an agent is anything that can be viewed as?", " Not acting upon that environment through actuators", " Not performing an action at all", " Acting upon that environment through actuators", " None of these", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q133);
        QuizQuestion q134 = new QuizQuestion("Which one of the following is correct about percept?", " None of these", " Agents perceptual input at set times", " Agents perceptual input at one time", " Agents perceptual input at any given time", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q134);
        QuizQuestion q135 = new QuizQuestion(" Which one of the following is correct about percept sequence?", " History of everything the agent has ever perceived ", " No history of anything the agent has ever perceived", " History of agents percept sequence for a given time", " None of these", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q135);
        QuizQuestion q136 = new QuizQuestion(" How many steps does an agents program cycle have?", "2", "3", "1", "4", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q136);
        QuizQuestion q137 = new QuizQuestion(" What are the steps in an agents program cycle?", " Perceive, Act Rationally and Think", " Think and Act Rationally", " Perceive, Think and Act Rationally", " Act Rationally and Think", 3, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q137);
        QuizQuestion q138 = new QuizQuestion("Which one of the following is an assumption that is true about an agent?", " No agent can perceive its own actions", " Some agents can perceive their own actions", " None of these", " Every agent can perceive its own actions", 4, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q138);
        QuizQuestion q139 = new QuizQuestion(" Which one of the following is a reason why simple reflex agents are limited?", " They cannot plan ahead", " They plan ahead too much", " They are too expensive", " None of these", 1, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q139);
        QuizQuestion q140 = new QuizQuestion("Which one of the following is a reason why simple reflex agents are limited? ", " They have too much knowledge of what their actions do", " They have no knowledge of what their actions do", " They cant perform well under pressure", " None of these", 2, QuizQuestion.QUESTION_LEVEL_2, QuizModule.MODULE_5);
        insertQuestion(q140);
        QuizQuestion q141 = new QuizQuestion(" How many steps are done by the intelligent agent to maximise the performance measure?", "5", "7", "2", "4", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q141);
        QuizQuestion q142 = new QuizQuestion("Which one of the following is step 1 performed by an intelligent agent to maximise the performance measure?", " Problem Formulation", " Goal Formulation", " Search", " Solution", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q142);
        QuizQuestion q143 = new QuizQuestion(" Which one of the following is step 2 performed by an intelligent agent to maximise the performance measure?", " Search", " Solution", " Problem Formulation", " Execution Phase", 3, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q143);
        QuizQuestion q144 = new QuizQuestion("Which one of the following is step 3 performed by an intelligent agent to maximise the performance measure?", " Execution Phase", " Search", " Solution", " Search ", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q144);
        QuizQuestion q145 = new QuizQuestion("Which one of the following is step 4 performed by an intelligent agent to maximise the performance measure?", " Solution", " Goal Formulation", " Problem Formulation", " Search", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q145);
        QuizQuestion q146 = new QuizQuestion("Which one of the following is step 5 performed by an intelligent agent to maximise the performance measure?", " Solution", " Execution Phase", " Search", " Goal Formulation", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q146);
        QuizQuestion q147 = new QuizQuestion(" How many uniformed search strategies are there?", "1", "2", "3", "4", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q147);
        QuizQuestion q148 = new QuizQuestion("What is Machine Learning?", " A computer learns how to improve from nothing", " A computer takes a long time to improve performance", " A computer can learn anything", " A computer automatically improves performance from experience", 4, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q148);
        QuizQuestion q149 = new QuizQuestion(" How many forms of machine learning are there?", "3", "7", "1", "4", 1, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q149);
        QuizQuestion q150 = new QuizQuestion("Which one of the following is a form of machine learning?", " Mistake Learning", " Reinforcement Learning", " Time Learning", " None of these.", 2, QuizQuestion.QUESTION_LEVEL_3, QuizModule.MODULE_5);
        insertQuestion(q150);

    }


    // Method to get all quiz modules from the database
    @SuppressLint("Range")
    public List<QuizModule> getQuizModules(){
        List<QuizModule> quizModuleList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_QUIZ_MODULES, null);

        // Iterate through cursor to populate the list with quiz modules
        if (cursor.moveToFirst()) {
            do {
                QuizModule module = new QuizModule();
                module.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_MODULE_ID)));
                module.setModule(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MODULE_NAME)));
                quizModuleList.add(module);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return quizModuleList;
    }

    // Method to retrieve specific quiz questions from the database
    @SuppressLint("Range")
    public List<QuizQuestion> getSpecificQuizQuestions(int moduleID, String questionLevel) {
        List<QuizQuestion> quizQuestionList = new ArrayList<>();
        db = getReadableDatabase();

        // Selection requirements for the query
        String select = COLUMN_QUIZ_MODULE_ID + " = ? " + " AND " + COLUMN_QUESTION_LEVEL + " = ? ";

        // Selection arguments for the query
        String[] selectArgs = new String[]{ String.valueOf(moduleID), questionLevel };

        // Perform the query and get cursor
        Cursor cursor = db.query(TABLE_NAME, null, select, selectArgs, null, null, null);

        // Iterate through cursor and populate list with specific quiz questions
        if (cursor.moveToFirst()) {
            do {
                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.setQuizQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_QUESTION)));
                quizQuestion.setQuizQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_QUESTION)));
                quizQuestion.setQuizAnswer1(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_ANSWER1)));
                quizQuestion.setQuizAnswer2(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_ANSWER2)));
                quizQuestion.setQuizAnswer3(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_ANSWER3)));
                quizQuestion.setQuizAnswer4(cursor.getString(cursor.getColumnIndex(COLUMN_QUIZ_ANSWER4)));
                quizQuestion.setQuizCorrectAnswer(cursor.getInt(cursor.getColumnIndex(COLUMN_QUIZ_CORRECT_ANSWER)));
                quizQuestion.setQuestionLevel(cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION_LEVEL)));
                quizQuestion.setModuleID(cursor.getInt(cursor.getColumnIndex(COLUMN_QUIZ_MODULE_ID)));

                // Add quiz question objects to question list
                quizQuestionList.add(quizQuestion);

            } while (cursor.moveToNext());
        }
        
        cursor.close();
        return quizQuestionList;
    }

}
