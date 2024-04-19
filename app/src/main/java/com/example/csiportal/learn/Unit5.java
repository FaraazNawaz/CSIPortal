package com.example.csiportal.learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.csiportal.R;
import com.example.csiportal.fragments.Unit2TopicsFragment;
import com.example.csiportal.fragments.Unit5TopicsFragment;

public class Unit5 extends AppCompatActivity {

    private Spinner Unit5topics;
    private TextView Unit5TopicInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit5);

        // Set the title to introduction to artificial intelligence and allow the back button to be enabled to go back to learn page
        getSupportActionBar().setTitle("Introduction to Artificial Intelligence");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initialize the spinner and the text view
        //Spinner
        Unit5topics = findViewById(R.id.Unit5topics);
        //Text view
        Unit5TopicInformation = findViewById(R.id.Unit5TopicInformation);

        // Set up array adapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unit5topics, R.layout.spinner_topic);

        // Set the layout for how the list of topics will look like
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Unit5topics.setAdapter(adapter);


        // Set up item selected listener for the spinner
        Unit5topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItem, int position, long id) {

                // Handle clicked topic in the spinner list
                String selectedTopic = parent.getItemAtPosition(position).toString();

                // Set information for the clicked topic
                unit5TopicInformation(selectedTopic);

                // Replace current fragment with the clicked topic
                replaceFragment(Unit5TopicsFragment.newInstance(position + 1));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing if nothing is clicked but topic 1 will always be selected
            }
        });
    }

    //Method to replace fragment in fragment container
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Unit5fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Method to set information in text view using the selected topic from spinner
    private void unit5TopicInformation(String clickedTopic) {

        // Information set for each selected topic from spinner using switch statement
        String content;
        switch (clickedTopic) {

            // The first topic is selected from the spinner
            case "Introduction to AI":
                content = "<u><b><h1><font color=\"#000000\"> AI has transformed the IT industry</font></h1></b></u>" +
                        "<h4><font color=\"000000\">– Search Engine" + "<br></br>" +
                        "<br>– Speech Recognition</br>" + "<br></br>" +
                        "<br>– Machine Translation</br>" + "<br></br>" +
                        "<br>– Recommendation systems</br>" + "<br></br>" +
                        "<br>• AI is transforming other industries</br>" + "<br></br>" +
                        "<br>– Automotive</br>" + "<br></br>" +
                        "<br>– Transportation</br>" + "<br></br>" +
                        "<br>– Healthcare</br>" + "<br></br>" +
                        "<br>– Finance</br>" + "<br></br>" +
                        "<br>– Services: Insurance, Law, HR, Travel, Media, …</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">What is Artificial Intelligence?</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• AI is the part of computer science concerned with design of computer systems that exhibit human intelligence (From the Concise Oxford Dictionary)" + "<br></br>" +
                        "<br>• We associate intelligence with the ability to Perceive, Reason, Choose, Act, Achieve goals, Learn, Reflect, Communicate, Collaborate, Organize</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Thinking Humanly</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• To build a machine that thinks like a human" + "<br></br>" +
                        "<br>• A cognitive modeling approach </br>" + "<br></br>" +
                        "<br>• First we need to know how we think, e.g.,</br>" + "<br></br>" +
                        "<br>– through introspection (thinking about how we do it – unscientific)</br>" + "<br></br>" +
                        "<br>– through psychological experiments (proper science)</br>" + "<br></br>" +
                        "<br>• Once we have sufficient information about the working of minds it becomes easy to implement it as a computer program. </br>" + "<br></br>" +
                        "<br>• If the computer’s input-output behavior matches corresponding human behavior than it would be the evidence that some of the program’s mechanism could also be working operating in humans.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Acting Humanly</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• To convince the interrogator of its intelligence, the computer must" + "<br></br>" +
                        "<br>• understand and generate language (Natural language processing)</br>" + "<br></br>" +
                        "<br>• know about the world (knowledge representation)</br>" + "<br></br>" +
                        "<br>• reason about the world (automated reasoning)</br>" + "<br></br>" +
                        "<br>• learn about the dialogue and the interrogator (machine learning)</br>" + "<br></br>" +
                        "<br>• combine all this knowledge and reasoning instantaneously</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Thinking Rationally</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• How to build programs that represent the “right thinking” to create intelligent machines." + "<br></br>" +
                        "<br>• This “right thinking” is defined in coding using logic or laws of thought. </br>" + "<br></br>" +
                        "<br>• Borrows from Aristotle's right thinking - Greek philosophers </br>" + "<br></br>" +
                        "<br>• Example: All computers use energy. Using energy always generates heat.</br>" + "<br></br>" +
                        "<br>Therefore, all computers generate heat.</br>" + "<br></br>" +
                        "<br>• Formal logic was developed in the late nineteenth century.</br>" + "<br></br>" +
                        "<br>– Precise notation to describe reasoning which gives us the tools to solve any logical problem</br>" + "<br></br>" +
                        "<br>• This was the first step toward enabling computer programs to reason logically</br></font></h4>";
                break;

            // The second topic is selected from the spinner
            case "Introduction to Intelligence Agents":
                content = "<u><b><h1><font color=\"#000000\">Agents and environments</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• An agent is anything that can be viewed as" + "<br></br>" +
                        "<br>– perceiving its environment through sensors and</br>" + "<br></br>" +
                        "<br>– acting upon that environment through actuators</br>" + "<br></br>" +
                        "<br>• Percept: agent’s perceptual input at any given instant</br>" + "<br></br>" +
                        "<br>• Percept sequence: complete history of everything the agent has ever perceived</br>" + "<br></br>" +
                        "<br>• An agent’s choice of action at any given instant can depend on the entire percept sequence observed to date.</br>" + "<br></br>" +
                        "<br>• An agent program runs in cycles of: (1)perceive, (2)think, and (3)act rationally</br>" + "<br></br>" +
                        "<br>• Assumption: Every agent can perceive its own actions (but not always the effects)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\"> Human agent:</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">– eyes, ears, and other organs for sensors;" + "<br></br>" +
                        "<br>– hands, legs, mouth, and other body parts for actuators</br>" + "<br></br>" +
                        "<br>• Robotic agent:</br>" + "<br></br>" +
                        "<br>– cameras and infrared range finders for sensors;</br>" + "<br></br>" +
                        "<br>– various motors for actuators</br>" + "<br></br>" +
                        "<br>• A software agent:</br>" + "<br></br>" +
                        "<br>– Keystrokes, file contents, received network packages as sensors</br>" + "<br></br>" +
                        "<br>– Displays on the screen, files, sent network packets as actuators</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Rational Agents</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Rational Agent: “For each possible percept sequence, a rational agent should select an action that is expected to maximize its performance measure, given the evidence provided by the percept sequence and whatever built-in knowledge the agent has.”" + "<br></br>" +
                        "<br>• Agent precepts → Action sequences → Environmental changes </br>" + "<br></br>" +
                        "<br>– If the sequence of states that changes the environment is desirable, then the agent did it’s job.</br>" + "<br></br>" +
                        "<br>• This can be measured using a metric called performance measure</br>" + "<br></br>" +
                        "<br>• Performance measure: An objective criterion for success of an agent's behavior</br>" + "<br></br>" +
                        "<br>• How do we measure the performance of the vacuum cleaner intelligent agent?</br>" + "<br></br>" +
                        "<br>– E.g. the amount of dirt cleaned within a certain time</br>" + "<br></br>" +
                        "<br>– E.g. how clean the floor is</br>" + "<br></br>" +
                        "<br>– E.g. the amount of dirt cleaned per unit of electricity used</br>" + "<br></br>" +
                        "<br>• Performance measures should be based on:</br>" + "<br></br>" +
                        "<br>– what is wanted in the environment </br>" + "<br></br>" +
                        "<br>– how You think the agent should act”</br></font></h4>" + "<br></br>" +

                        "<br><u><b><h1><font color=\"#000000\">Rationality</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\"What is rational at a given time depends on:" +
                        "<br>• What is rational at a given time depends on:</br>" + "<br></br>" +
                        "<br>– The performance measure</br>" + "<br></br>" +
                        "<br>– What the agent knows</br>" + "<br></br>" +
                        "<br>– The actions that the agent can perform</br>" + "<br></br>" +
                        "<br>– What the agent has observed (through its sensors)</br>" + "<br></br>" +
                        "<br>• Rationality ≠ omniscience</br>" + "<br></br>" +
                        "<br>– An omniscient agent knows the actual state of the world</br>" + "<br></br>" +
                        "<br>– Rational agent don’t know in advance what the outcome will be</br>" + "<br></br>" +
                        "<br>• Rationality ≠ clairvoyance</br>" + "<br></br>" +
                        "<br>– A clairvoyant agent knows the actual effects of its actions</br>" + "<br></br>" +
                        "<br>• Rationality ≠ perfection</br>" + "<br></br>" +
                        "<br>– Rational agent aren’t always perfect (don’t lead to desirable outcome</br></font></h4>";
                break;

            // The third topic is selected from the spinner
            case "Solving Problems by Searching":
                content = "<u><b><h1><font color=\"#000000\">Problem Solving Agents</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Simple reflex agents are limited because" + "<br></br>" +
                        "<br>– They cannot plan ahead. </br>" + "<br></br>" +
                        "<br>– They also have no knowledge of what their actions do nor of what they are trying to achieve.</br>" + "<br></br>" +
                        "<br>• Problem solving agent is one kind of goal-based agent, where the agent decides what do by finding sequences of actions that lead to desirable states.</br>" + "<br></br>" +
                        "<br>• If the agent understood the definition of problem, it is relatively straight forward to construct a search process for finding solutions</br>" + "<br></br>" +
                        "<br>• Problem solving agent should be an intelligent agent to maximize the performance measure</br>" + "<br></br>" +
                        "<br>• The sequence of steps done by the intelligent agent to maximize the performance measure: </br>" + "<br></br>" +
                        "<br>1. Goal formulation - based on the current situation and the agent‘s performance measure, is the first step of problem solving. </br>" + "<br></br>" +
                        "<br>2. Problem formulation - is the process of deciding what actions and states to consider, given a goal. </br>" + "<br></br>" +
                        "<br>3. Search - An agent with several immediate options of unknown value can decide what to do by first examining different possible sequence of actions that lead to states of known value, and then choosing in best sequence.</br>" + "<br></br>" +
                        "<br>4. Solution - a search algorithm takes a problem as input and returns a solution in the form of an action sequence. </br>" + "<br></br>" +
                        "<br>5. Execution phase - Once a solution is found, the actions it recommends can be carried out.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">How do we evaluate a search algorithm</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• A strategy is defined by picking the order of node expansion" + "<br></br>" +
                        "<br>• Strategies are evaluated along the following dimensions:</br>" + "<br></br>" +
                        "<br>– completeness—doesit alwaysfind a solution if one exists? v" + "<br></br>" +
                        "<br>– time complexity—numberof nodesgenerated/expanded</br>" + "<br></br>" +
                        "<br>– space complexity—maximum number of nodesin memory </br>" + "<br></br>" +
                        "<br>– optimality—doesit alwaysfind a least-cost solution?</br>" + "<br></br>" +
                        "<br>• Time and space complexity aremeasured in terms of </br>" + "<br></br>" +
                        "<br>– b—maximum branching factor of the search tree</br>" + "<br></br>" +
                        "<br>– d—depth of the least-cost solution</br>" + "<br></br>" +
                        "<br>– m—maximum depth of the state space (may be ∞)</br></font></h4>" + "<br></br>" +

                        "<br><u><b><h1><font color=\"#000000\">Search Strategies</font></h1></b></u><br>" +
                        "<h4><font color=\"000000\">• Uninformed (or blind) search strategies have no information about the number of steps or the path cost from the current state to the goal." +
                        "<br>– In a route finding problem, given several choices of cities to go to next, uniformed search strategies have no way to prefer any particular choices.</br>" + "<br></br>" +
                        "<br>• Informed (or heuristic) search strategies use considerations to prefer choices.</br>" + "<br></br>" +
                        "<br>– For example, in the route finding problem with a map, if a choice is in the direction of the goal city, prefer it.</br>" + "<br></br>" +
                        "<br>– Uninformed search is less effective than heuristic search, however it is still important because there are many problems for which information used to make informed choices is not available.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Uniformed search strategies</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">– Breadth-first search (BFS)" + "<br></br>" +
                        "<br>– Depth-first search (DFS)</br>" + "<br></br>" +
                        "<br>– Depth-limited search</br>" + "<br></br>" +
                        "<br>– Iterative deepening search</br></font></h4>";
                break;

            // The fourth topic is selected from the spinner
            case "Python Programming for AI":
                content = "<u><b><h1><font color=\"#000000\">Why Python for AI? </font></h1></b></u>" +
                        "<h4><font color=\"000000\">Python programming language gains a huge popularity for AI programming and the reasons are as follows:" + "<br></br>" +
                        "<br>• Simple syntax & less coding </br>" + "<br></br>" +
                        "<br>• Inbuilt libraries for AI projects: For example, NumPy, SciPy, matplotlib, nltk, SimpleAI are some the important inbuilt libraries of Python. </br>" + "<br></br>" +
                        "<br>• Scikit-learn which is a tool for machine learning.</br>" + "<br></br>" +
                        "<br>• Open source: This makes it widely popular in the community. </br>" + "<br></br>" +
                        "<br>• Can be used for broad range of programming:</br>" + "<br></br>" +
                        "<br>• Fast development:</br>" + "<br></br>" +
                        "<br>– concise, intuitive syntax</br>" + "<br></br>" +
                        "<br>– whitespace delimited</br>" + "<br></br>" +
                        "<br>– garbage collected,</br>" + "<br></br>" +
                        "<br>• Various built-in types: lists, dictionaries, sets</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">The structure of a Python program</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Code blocks are defined by their indentations" + "<br></br>" +
                        "<br>• → Indentation is a requirement in Python!</br>" + "<br></br>" +
                        "<br>• Structures that introduce blocks end with a colon “:”</br>" + "<br></br>" +
                        "<br>• Comments</br>" + "<br></br>" +
                        "<br>• The # character has a special meaning in Python.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data Structures: Python Lists</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Related to Ja va or C arrays, BUT more powerful" + "<br></br>" +
                        "<br>• List items do not need to have the same type</br>" + "<br></br>" +
                        "<br>• Lists can grow dynamically</br>" + "<br></br>" +
                        "<br>• Lists are ordered</br>" + "<br></br>" +
                        "<br>• Lists are mutable and elements can be accessed by their index</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data Structures: Tuples</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• A tuple is a sequence of comma separated values" + "<br></br>" +
                        "<br>• Values can have different types</br>" + "<br></br>" +
                        "<br>• Tuples are immutable</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data Structures: Dictionaries</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Dictionaries are collections of (key,value) pairs" + "<br></br>" +
                        "<br>• Each key must be unique, since values are obtainable via the key</br>" + "<br></br>" +
                        "<br>• Dictionaries are unordered</br>" + "<br></br>" +
                        "<br>• Dictionaries are not sequence types like strings, lists or tuples</br>" + "<br></br>" +
                        "<br>• Keys must be immutable, values can be of arbitrary type</br>" + "<br></br>" +
                        "<br>• The types of keys, resp. values, must not be consistent</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data Structures: Sets</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Sets are basically dictionaries that only consist of keys without values." + "<br></br>" +
                        "<br>• Like sets in the mathematical meaning, only unique elements are considered</br></font></h4>";
                break;

            // The fifth topic is selected from the spinner
            case "Machine Learning":
                content = "<u><b><h1><font color=\"#000000\">What is Machine Learning?</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• A branch of artificial intelligence (AI) in which a computer automatically improves performance from experience</font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Machine Learning (ML) vs. Conventional Computing</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Conventional computer programs or algorithms perform tedious tasks faster and more accurately than humans (addition, subtraction, spellchecking)" + "<br></br>" +
                        "<br>• Machine learning algorithms perform tasks that are difficult or infeasible to do via conventional computer algorithms (grammar checking, interpreting speech, image recognition)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Machine Learning Applications</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Self-driving cars" + "<br></br>" +
                        "<br>• Game playing</br>" + "<br></br>" +
                        "<br>• Face recognition</br>" + "<br></br>" +
                        "<br>• Fingerprint recognition</br>" + "<br></br>" +
                        "<br>• Traffic sign recognition</br>" + "<br></br>" +
                        "<br>• Automated trading</br>" + "<br></br>" +
                        "<br>• E-mail spam filtering</br>" + "<br></br>" +
                        "<br>• Gesture recognition</br>" + "<br></br>" +
                        "<br>• Speech recognition</br>" + "<br></br>" +
                        "<br>• Handwriting recogn</br>" + "<br></br>" +
                        "<br>• Radar analysis</br>" + "<br></br>" +
                        "<br>• Resource management</br>" + "<br></br>" +
                        "<br>• Brain simulation</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ML For Fraud Prevention</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Anomaly detection (unusual purchases, unusual locations)" + "<br></br>" +
                        "<br>• Historical purchase data (data mining)</br>" + "<br></br>" +
                        "<br>• Pattern extraction from past purchase data sets</br>" + "<br></br>" +
                        "<br>• Integrates user profile data (age, sex, job)</br>" + "<br></br>" +
                        "<br>• Highly personalized</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Forms of Learning</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Machine Learning Algorithms can be divided into three categories according to their purpose and the main categories are the following:" + "<br></br>" +
                        "<br>Supervised Learning - Task Driven</br>" + "<br></br>" +
                        "<br>Unsupervised Learning – Data Driven</br>" + "<br></br>" +
                        "<br>Reinforcement Learning – Learn from Mistakes</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Diverse Machine Learning Terminology</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Training set - a dataset used to find potentially predictive relationships that will be used to create a model." + "<br></br>" +
                        "<br>• Test set - a data set, separate from the training set but with the same structure, used to measure and benchmark the performance of various models.</br>" + "<br></br>" +
                        "<br>• Model - mathematical representation of a real world process; a predictive model forecasts a future outcome based on past behaviors</br>" + "<br></br>" +
                        "<br>• Training - the process of creating a model from the training data. The data is fed into the training algorithm, which learns a representation for the problem and produces a model. Also called “learning.”</br>" + "<br></br>" +
                        "<br>• Target - dependent variable; it is the output of the model or the variable you wish to predict. </br>" + "<br></br>" +
                        "<br>• Classification: a prediction method that assigns each data point to a predefined category, e.g., a type of operating system.</br>" + "<br></br>" +
                        "<br>• Regression: predicting a numerical/continuous label</br></font></h4>";
                break;

            // The sixth topic is selected from the spinner
            case "Knowledge Representation":
                content = "<u><b><h1><font color=\"#000000\">Knowledge</font></h1></b></u>" +
                        "<h4><font color=\"000000\">Knowledge-based agents: Agents that reason by operating on internal representations of knowledge" + "<br></br>" +
                        "<br>What do we mean by reasoning?</br>" + "<br></br>" +
                        "<br>A simple example:</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Rule: If it didn't rain, Harry visited Hagrid today. </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Facts:" + "<br></br>" +
                        "<br>• Harry visited Hagrid or Dumbledore today, but not both.</br>" + "<br></br>" +
                        "<br>• Harry visited Dumbledore today.</br>" + "<br></br>" +
                        "<br>Our Conclusions:</br>" + "<br></br>" +
                        "<br>• Harry did not visit Hagrid today.</br>" + "<br></br>" +
                        "<br>• It rained today</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Logic</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Sentence: an assertion about the world in a knowledge representation language" + "<br></br>" +
                        "<br>• Propositional Logic: A branch of logic which studies the logical relationships between propositions</br>" + "<br></br>" +
                        "<br>• Propositional Symbols: P, Q, R, …</br>" + "<br></br>" +
                        "<br>• Logical Connectives:</br>" + "<br></br>" +
                        "<br>¬ (not) </br>" + "<br></br>" +
                        "<br>∧ (and) </br>" + "<br></br>" +
                        "<br>∨ (or)</br>" + "<br></br>" +
                        "<br>→ (implication) </br>" + "<br></br>" +
                        "<br>↔ (biconditional)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Model</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Model: assignment of a truth value to every propositional symbol (a \"possible world\")" + "<br></br>" +
                        "<br>• Example:</br>" + "<br></br>" +
                        "<br>P: It is raining</br>" + "<br></br>" +
                        "<br>Q: It is a Wednesday.</br>" + "<br></br>" +
                        "<br>Sample model: {p: True, Q: False}</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Knowledge Base</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Knowledge base: A set of sentences known by a knowledge-based agent" + "<br></br>" +
                        "<br>• Example: </br>" + "<br></br>" +
                        "<br>Knowledge base= {Today is Tuesday, This lecture is for the AI module, There is going to be at least one question from this topic in the exam}</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Inference Rule: Modus Ponens</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">If it is raining, then Alex is inside." + "<br></br>" +
                        "<br>It is raining.</br>" + "<br></br>" +
                        "<br>Alex is inside.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Forward Chaining Algorithm</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• The idea is simple: Start with the sentences in the knowledge base and add new sentences by applying Modus Ponens, until the final goal is reached or no further inferences can be made." + "<br></br>" +
                        "<br>• This algorithm is useful in systems with</br>" + "<br></br>" +
                        "<br>• A knowledge base containing accumulated experience, and </br>" + "<br></br>" +
                        "<br>• An inference or rules engine -- a set of rules for applying the knowledge base to each particular situation</br>" + "<br></br>" +
                        "<br>• Such systems are known as expert systems</br></font></h4>";
                break;
            default:
                content = "";
                break;
        }

        // Update the text view with the information using html formatting
        Unit5TopicInformation.setText(HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }
}