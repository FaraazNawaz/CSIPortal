package com.example.csiportal.learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.csiportal.R;
import com.example.csiportal.fragments.Unit1TopicsFragment;

public class Unit1 extends AppCompatActivity {

    // The spinner variable for selecting topics from dropdown menu
    private Spinner Unit1topics;

    // Text view variable for showing information about topic selected from spinner
    private TextView Unit1TopicInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit1);

        // Set the title to software project management and allow the back button to be enabled to go back to learn page
        getSupportActionBar().setTitle("Software Project Management");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initialize the spinner and the text view
        //Spinner
        Unit1topics = findViewById(R.id.Unit1topics);
        //Text view
        Unit1TopicInformation = findViewById(R.id.Unit1TopicInformation);


        // Set up array adapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unit1topics, R.layout.spinner_topic);

        // Set the layout for how the list of topics will look like
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Unit1topics.setAdapter(adapter);


        // Set up item selected listener for the spinner
        Unit1topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItem, int position, long id) {

                // Handle clicked topic in the spinner list
                String selectedTopic = parent.getItemAtPosition(position).toString();

                // Set information for the clicked topic
                unit1TopicInformation(selectedTopic);

                // Replace current fragment with the clicked topic
                replaceFragment(Unit1TopicsFragment.newInstance(position + 1));
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
        fragmentTransaction.replace(R.id.Unit1fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    //Method to set information in text view using the selected topic from spinner
    private void unit1TopicInformation(String clickedTopic) {

        // Information set for each selected topic from spinner using switch statement
        String content;
        switch (clickedTopic) {

            // The first topic is selected from the spinner
            case "Measurement, Estimation and Data Analysis":
                content = "<u><b><h1><font color=\"#000000\">What is Measurement?</font></h1></b></u>" +
                        "<h4><font color=\"#000000\">• Measurement is the process of assigning a value to some attribute of an entity, where the value is obtained on a particular scale" + "<br></br>" +
                        "<br>– E.g., elapsed time of the testing phase of a software package.</br>" + "<br></br>" +
                        "<br>• Measurement may require a measurement instrument and may be carried out by a measurer</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Direct Measurement</font></h1></b></u></br>" +
                        "<h4><font color=\"#000000\">• An attribute of an entity measured without the need to measure another attribute/entity: – e.g., length of a physical object" + "<br></br>" +
                        "<br>• Typical direct measurements in software project management </br>" + "<br></br>" +
                        "<br>– Length of source code</br>" + "<br></br>" +
                        "<br>– Duration of testing process </br>" + "<br></br>" +
                        "<br>– Number of defects discovered during the testing process </br>" + "<br></br>" +
                        "<br>– Time spent by developers on a project</br>”</font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Indirect Measurement</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• An indirect measurement is one that is calculated from direct measurements" + "<br></br>" +
                        "<br>• Consider the formula A = a*X + b*Y (where a and b are constants):</br>" + "<br></br>" +
                        "<br>– The units of X and Y must be the same, and they are the units of A</br>" + "<br></br>" +
                        "<br>– We can’t add inches and centimetres or subtract hours from minutes</br>" + "<br></br>" +
                        "<br>• Some typical indirect measurements in software project management</br>" + "<br></br>" +
                        "<br>– Programmer productivity = LoC / developer months of effort</br>" + "<br></br>" +
                        "<br>– Module defect density = number of defects / module size</br>" + "<br></br>" +
                        "<br>– System spoilage = effort spent fixing defects / total project effort</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Measurement Validity </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• A measurement is valid if it is:" + "<br></br>" +
                        "<br>– Accurate - measures the true value of the attribute</br>" + "<br></br>" +
                        "<br>– Reliable - repeated measurements give similar values</br>" + "<br></br>" +
                        "<br>– Meaningful - measures the underlying concept we are trying to understand</br>" + "<br></br>" +
                        "<br>• When a measure is inaccurate, it yields incorrect values, so it must be disregarded the as it does not reflect the true state of the object.</br>" +"<br></br>" +
                        "<br>• Unreliable measures produce inconsistent results for the same object, often influenced by external factors or disturbances.</br>" + "<br></br>" +
                        "<br>• Some measures lack meaningful connections to the intended concept or are ill-suited for the task at hand (e.g., measuring intelligence through head circumference).</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Measurement accuracy</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Accuracy is important, but needs to be tempered by context</br>" + "<br></br>" +
                        "<br>• ‘Acceptability’ of accuracy varies …</br>" + "<br></br>" +
                        "<br>– Byte count of size (expect 100% accuracy)</br>" + "<br></br>" +
                        "<br>– Method count of size (within ± 10%?)</br>" + "<br></br>" +
                        "<br>– Avoid pointless (or numerically irrelevant) precision:</br>" + "<br></br>" +
                        "<br>• 0.6 ± 0.1</br>" + "<br></br>" +
                        "<br>• 0.64 ± 0.02</br>" + "<br></br>" +
                        "<br>• Timeliness may be more important</br>" + "<br></br>" +
                        "<br>– Example: an approximate measurement of the number of defects in a software application may tell if the application is ready to be released to customers</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Scale types</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Scales are classified based NOT only on the points that make them up but also on the (empirical relations of the) attribute being measured</br>" + "<br></br>" +
                        "<br>• The type of a scale determines the admissible relations and operations applicable to measurements on that scale</br>" + "<br></br>" +
                        "<br>• Five types of scales – in increasing order of richness:</br>" + "<br></br>" +
                        "<br>– Nominal</br>" + "<br></br>" +
                        "<br>– Ordinal</br>" + "<br></br>" +
                        "<br>– Interval</br>" + "<br></br>" +
                        "<br>– Ratio</br>" + "<br></br>" +
                        "<br>– Absolute</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">What is estimation?</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Estimation is the process of predicting an expected value for some attribute (whose value is not known)</br>" + "<br></br>" +
                        "<br>• The uncertainty is expressed in terms of probabilities</br>" + "<br></br>" +
                        "<br>• Estimates are forecasts or predictions: we estimate what we cannot measure</br>" + "<br></br>" +
                        "<br>– the entity whose attribute we estimate may not exist yet or is not sufficiently mature to be measured accurately– not because we don’t understand what we are trying to measure.</br>" + "<br></br>" +
                        "<br>• Estimation is closely linked to measurement because estimates are based (explicitly or implicitly) on data obtained from measurement)</br>" + "<br></br>" +
                        "<br>• Representational validity and scale types are still just as relevant</br>" + "<br></br>" +
                        "<br>• The most common use of estimation in software projects is resource prediction</br>" + "<br></br>" +
                        "<br>• When needed?</br>" + "<br></br>" +
                        "<br>– determining if a project proposal is feasible resource-wise</br>" + "<br></br>" +
                        "<br>– bidding for a contract</br>" + "<br></br>" +
                        "<br>– planning a project: predicting cost and duration, etc</br>" + "<br></br>" +
                        "<br>– tracking resource expenditure during a project</br>" + "<br></br>" +
                        "<br>If estimates are poor, the resulting losses can take a company out of business</br>" + "<br></br>" +
                        "<br>Improved estimates</br>" + "<br></br>" +
                        "<br>• Ways to improve on an expert judgement:</br>" + "<br></br>" +
                        "<br>– Group estimation (the Delphi method)</br>" + "<br></br>" +
                        "<br>– Task decomposition</br>" + "<br></br>" +
                        "<br>– Analogy</br>" + "<br></br>" +
                        "<br>– Formal modelling</br></font></h4>";
                break;

            // The second topic is selected from the spinner
            case "Software Project Planning":
                content = "<u><b><h1><font color=\"#000000\">Success factors for project management</font></h1></b></u>" +
                        "<h4><font color=\"000000\">1. Agree on all project goals" + "<br></br>" +
                        "<br>2. Develop clearly defined plans with assigned responsibilities and accountabilities</br>" + "<br></br>" +
                        "<br>3. Manage the project scope effectively </br>" + "<br></br>" +
                        "<br>4. Cultivate constant effective communication</br>" + "<br></br>" +
                        "<br>5. Make sure you have management support</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Step Wise- an overview</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Step 1: identify project objectives" + "<br></br>" +
                        "<br>• 1.1 Identify objectives and measures of effectiveness</br>" + "<br></br>" +
                        "<br>• 1.2 Establish a project authority</br>" + "<br></br>" +
                        "<br>• 1.3 Identify all stakeholders in the project and their interests</br>" + "<br></br>" +
                        "<br>• 1.4 Modify objectives in the light of stakeholder analysis</br>" + "<br></br>" +
                        "<br>• 1.5 Establish methods of communication with all parties</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 2: identify project infrastructure</br>" + "<br></br>" +
                        "<br>• 2.1 Establish link between project and any strategic plan </br>" + "<br></br>" +
                        "<br>• 2.2 Identify installation standards and procedures </br>" + "<br></br>" +
                        "<br>• 2.3. Identify project team organization</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 3: analyse project characteristics</br>" + "<br></br>" +
                        "<br>• 3.1 Distinguish the project as either objective or product-based.</br>" + "<br></br>" +
                        "<br>• 3.2 Analyse other project characteristics (e.g., quality-based)</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 3: analyse project characteristics</br>" + "<br></br>" +
                        "<br>• 3.3 Identify high level project risks </br>" + "<br></br>" +
                        "<br>• 3.4 Consider user requirements concerning implementation</br>" + "<br></br>" +
                        "<br>• 3.5 Select development methodology and life-cycle approach: </br>" + "<br></br>" +
                        "<br>• 3.6 Review overall resource estimates</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 4: identify project and activities</br>" + "<br></br>" +
                        "<br>• 4.1 Identify and describe project products</br>" + "<br></br>" +
                        "<br>• 4.2 Document generic product flows </br>" + "<br></br>" +
                        "<br>• 4.3 Recognize product instances </br>" + "<br></br>" +
                        "<br>• 4.4 Produce ideal activity network </br>" + "<br></br>" +
                        "<br>• 4.5 Add stages & checkpoints/milestones" + "<br></br>" + "<br></br>" +
                        "<br>Step 5: estimate effort for each activity </br>" + "<br></br>" +
                        "<br>• 5.1 Carry out bottom-up estimates </br>" + "<br></br>" +
                        "<br>• 5.2. Revise plan to create controllable activities" + "<br></br>" + "<br></br>" +
                        "<br>Step 6: identify activity risks</br>" + "<br></br>" +
                        "<br>• 6.1. Identify and quantify risks for activities </br>" + "<br></br>" +
                        "<br>• 6.2. Plan risk reduction and contingency measures" + "<br></br>" + "<br></br>" +
                        "<br>Step 7: allocate resources</br>" + "<br></br>" +
                        "<br>• 7.1 Identify and allocate resources to activities </br>" + "<br></br>" +
                        "<br>• 7.2 Revise plans and estimates to take into account resource constraints</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 8: review/ publicise plan</br>" + "<br></br>" +
                        "<br>• 8.1 Review quality aspects of project plan </br>" + "<br></br>" +
                        "<br>• 8.2 Document plan and obtain agreement</br>" + "<br></br>" + "<br></br>" +
                        "<br>Step 9 & 10</br>" + "<br></br>" +
                        "<br>• Step 9: execute plan </br>" + "<br></br>" +
                        "<br>• Step 10: lower-level planning </br>" + "<br></br>" +
                        "<br>• Detailed plans are required and feasible for the current activities </br>" + "<br></br>" +
                        "<br>• Detailed plans for later project stages are often not possible</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">PRINCE2 processes</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Directing a Project covers activities by the Project Board" + "<br></br>" +
                        "<br>• Starting up a Project comprises activities concerned with reaching a position where detailed project planning can begin </br>" + "<br></br>" +
                        "<br>• Initiating the Project refers to activities associated with producing an overall plan for the project</br>" + "<br></br>" +
                        "<br>• Controlling a Stage includes the activities carried out by the project manager once a stage has been authorised </br>" + "<br></br>" +
                        "<br>• Managing Product Delivery covers activities that involve communication between the project manager and team managers</br>" + "<br></br>" +
                        "<br>• Managing Stage Boundaries includes activities associated with the creation of next stage plans & updates to overall project plan </br>" + "<br></br>" +
                        "<br>• Closing the Project includes end-of-project activities</br></font></h4>";
                break;

            // The third topic is selected from the spinner
            case "Software Project Risk Management":
                content = "<u><b><h1><font color=\"#000000\">Definition of Risk</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• The chance of exposure to the adverse consequences of future events (PRINCE2)" + "<br></br>" +
                        "<br>• An uncertain event or condition that, if it occurs, has a positive or negative effect on a project’s objectives</br>" + "<br></br>" +
                        "<br>• Risks relate to possible future problems, not current ones</br>" + "<br></br>" +
                        "<br>• Risks involve a possible cause and its effect(s)</br>" + "<br></br>" +
                        "<br>• Risks can be negative or positive</br>" + "<br></br>" +
                        "<br>Why is risk planning not widely used?</br>" + "<br></br>" +
                        "<br>• Lack of awareness of the approach </br>" + "<br></br>" +
                        "<br>• Unwillingness to spend additional time and resources on risk management</br>" + "<br></br>" +
                        "<br>• Development managers may want projects to go ahead and do not want project sponsors to be deterred by consideration of possible failure</br>" + "<br></br>" +
                        "<br>• If successful, you might not experience any tangible benefit, in spite of there being a cost associated with its use (which is actually a risk)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Project Risk Management</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Project Risk Management includes the processes concerned with identifying, analysing, and responding to project risk" + "<br></br>" +
                        "<br>• It aims at:</br>" + "<br></br>" +
                        "<br>– maximizing the results of positive events</br>" + "<br></br>" +
                        "<br>– minimizing the consequences of adverse events</br>" + "<br></br>" +
                        "<br>• Risks factors: </br>" + "<br></br>" +
                        "<br>– Project size </br>" + "<br></br>" +
                        "<br>– Complexity</br>" + "<br></br>" +
                        "<br>– Speed of implementation</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">A Risk Management Framework</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">The planning for risk includes four steps:" + "<br></br>" +
                        "<br>1. Risk identification – what risks might we find? </br>" + "<br></br>" +
                        "<br>2. Risk analysis and prioritisation – which are the most serious risks?</br>" + "<br></br>" +
                        "<br>3. Risk planning – what are we going to do about them? </br>" + "<br></br>" +
                        "<br>4. Risk monitoring – what is the current state of the risk?</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Risk Identification</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">The most serious effects of risk are:" + "<br></br>" +
                        "<br>• Failure to keep within the cost estimate</br>" + "<br></br>" +
                        "<br>• Failure to achieve the required completion date</br>" + "<br></br>" +
                        "<br>• Failure to achieve the required quality and operational requirements</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">How to deal with risks</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Risk acceptance – when the cost of avoiding the risk is (estimated to be) greater than the actual cost of the damage that might be inflicted" + "<br></br>" +
                        "<br>• Risk avoidance – avoid the cause associated with the risk – e.g., buying an off-the shelf application avoids the risk associated with developing the application (such as poor estimates of effort)</br>" + "<br></br>" +
                        "<br>• Risk reduction – actions are taken to reduce the likelihood of the risk – e.g., prototyping ought to reduce the risk of incorrect requirements; or offer generous bonuses on project completion to reduce likelihood that staff may leave during project</br>" + "<br></br>" +
                        "<br>How to deal with risks</br>" + "<br></br>" +
                        "<br>• Risk transfer – the risk is transferred to another person or organisation – e.g., the risk of incorrect development estimates can be transferred by negotiating a fixed price contract with an outside software supplier </br>" + "<br></br>" +
                        "<br>• Risk mitigation/contingency measures – actions are taken to reduce the impact if the risk does occur – need to monitor progress of project activities to identify occurrence of causes of risk – e.g., backups can be taken to allow rapid recovery in the case of data corruption</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">PERT</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Program Evaluation and Review Technique" + "<br></br>" +
                        "<br>• Used to determine the expected time for project activities based on a combination of optimistic, pessimistic and expected durations</br>" + "<br></br>" +
                        "<br>• Can be used to calculate the probability of project overrun</br>" + "<br></br>" +
                        "<br>• Requires an understanding of critical path analysis</br></font></h4>";
                break;

            // The fourth topic is selected from the spinner
            case "Project Management and Control":
                content = "<u><b><h1><font color=\"#000000\">Assessing progress</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• A checkpoint is a point in the project where progress is checked" + "<br></br>" +
                        "<br>• Two types of checkpoint:</br>" + "<br></br>" +
                        "<br>– Event-driven: check takes place when a particular event has been achieved (e.g., at the end of project stages in PRINCE2)</br>" + "<br></br>" +
                        "<br>– Time driven: date of the check is pre-determined (e.g., between sprints in Scrum)</br>" + "<br></br>" +
                        "<br>• Checkpoints ensure that intermediate products are compatible. They support project monitoring</br>" + "<br></br>" +
                        "<br>Collecting progress details: challenges</br>" + "<br></br>" +
                        "<br>• Dealing with partial completions is a problem.</br>" + "<br></br>" +
                        "<br>• Estimates are affected by the 99% completion syndrome – developer reports that the task is 25%, 50% and 75% complete at the end of weeks 1, 2 and 3, respectively</br>" + "<br></br>" +
                        "<br>– however, at the end of week 4 it is reported that the task is 99% complete </br>" + "<br></br>" +
                        "<br>• Possible solutions are based on objective verification of sub-task completion: </br>" + "<br></br>" +
                        "<br>– control of products, not activities </br>" + "<br></br>" +
                        "<br>– subdivide into multiple sub-activities that each generates a product</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Cost Monitoring</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Cost monitoring is an important component of project control in itself, but also as an indicator of the effort that has gone into the project:" + "<br></br>" +
                        "<br>– A project could be late because the staff originally committed have not been deployed </br>" + "<br></br>" +
                        "<br>– in this case the project will be behind time but under budget </br>" + "<br></br>" +
                        "<br>– A project could be on time but only because additional resources have been added and so be over budget </br>" + "<br></br>" +
                        "<br>• There is a need for the monitoring of both achievements and costs</br>" + "<br></br>" +
                        "<br>Partly-completed tasks</br>" + "<br></br>" +
                        "<br>• The 0/100 technique </br>" + "<br></br>" +
                        "<br>– Earned value of task is zero until completion, and 100% of the planned value on completion</br>" + "<br></br>" +
                        "<br>• The 50/50 technique </br>" + "<br></br>" +
                        "<br>– Half of the planned value allocated at start, the other half on completion </br>" + "<br></br>" +
                        "<br>• The milestone technique </br>" + "<br></br>" +
                        "<br>– Earned value of task is the planned value of last milestone achieved </br>" + "<br></br>" +
                        "<br>• The percentage technique</br>" + "<br></br>" +
                        "<br>– Works only if there is a means of assessing the percentage of the task that was completed (e.g., what percentage of 500 data records have been manually typed into a database)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Exception Planning</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Project manager typically allowed to change project plan as long as the agreed project outcomes are produced on time and within budget" + "<br></br>" +
                        "<br>• But changes to delivery date, scope and/or cost of project can affect</br>" + "<br></br>" +
                        "<br>– Users (e.g., reductions in the scope of the project)</br>" + "<br></br>" +
                        "<br>– The business case (e.g. costs increase reducing the potential profits of delivered software product)</br>" + "<br></br>" +
                        "<br>• In these cases an exception report is needed </br>" + "<br></br>" +
                        "<br>– Written by the project manager to explain the reasons that justify such a deviation from the existing plan</br></font></h4>" + "<br></br>" +

                        "<br><u><b><h1><font color=\"#000000\">Prioritising Monitoring</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Monitoring takes time and uses resources" + "<br></br>" +
                        "<br>– Should be applied with different levels of detail/effort</br>" + "<br></br>" +
                        "<br>• We want to focus more on monitoring certain types of activity: </br>" + "<br></br>" +
                        "<br>– Critical path activities </br>" + "<br></br>" +
                        "<br>– Activities with no free float – if delayed later dependent activities (although not the whole project) are delayed </br>" + "<br></br>" +
                        "<br>– Activities with less than a specified amount of float</br>" + "<br></br>" +
                        "<br>– High-risk activities </br>" + "<br></br>" +
                        "<br>– Activities using critical resources</br></font></h4>";
                break;

            // The fifth topic is selected from the spinner
            case "Quality Management":
                content = "<u><b><h1><font color=\"#000000\">Introduction</font></h1></b></u>" +
                        "<h4><font color=\"000000\">Quality is generally perceived as a required property of software, yet is often vaguely defined" + "<br></br>" +
                        "<br>Different stakeholders have different views on quality</br>" + "<br></br>" +
                        "<br>Common fallacy: quality can be defined and improved to the required level after all functionality is in place</br>" + "<br></br>" +
                        "<br>The importance of software quality management is growing</br>" + "<br></br>" +
                        "<br>The criticality of software is increasing rapidly</br>" + "<br></br>" +
                        "<br>The size and complexity of software products is increasing</br>" + "<br></br>" +
                        "<br>Software products are increasingly including third-party components or even using third-party online services</br>" + "<br></br>" +
                        "<br>Product quality management versus process quality management</br>" + "<br></br>" +
                        "<br>Product quality management focuses on: </br>" + "<br></br>" +
                        "<br>• Identifying & quantifying required quality requirements of software </br>" + "<br></br>" +
                        "<br>• Mapping these requirements to requirements for each project product Suitable with</br>" + "<br></br>" +
                        "<br>Step Wise or PRINCE2 </br>" + "<br></br>" +
                        "<br> However, product quality management is difficult and costly </br>" + "<br></br>" +
                        "<br>An alternative approach is to ensure the quality of the processes used to implement the application, i.e., to manage process quality</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Defining a quality management plan (Quality planning)</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">The quality plan includes:" + "<br></br>" +
                        "<br>• Objectives: Share that with the project team and stakeholders</br>" + "<br></br>" +
                        "<br>• Quality processes</br>" + "<br></br>" +
                        "<br>• Quality characteristics need to be specified</br>" + "<br></br>" +
                        "<br>• Metrics to measure quality characteristics need to be defined</br>" + "<br></br>" +
                        "<br>• Roles and responsibilities : team members accountable for each step in the quality management plan</br>" + "<br></br>" +
                        "<br>Software Quality and the ISO 9126 Standard </br>" + "<br></br>" +
                        "<br>Checklists containing increasing numbers of software quality characteristics have been assembled over the years </br>" + "<br></br>" +
                        "<br>• The above led to the introduction of the ISO 9126 standard in 1991 </br>" + "<br></br>" +
                        "<br>ISO 9126 versions of ever increasing length issued every few years</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: functionality sub-characteristics </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Suitability – the essential functionality component; refers to the appropriateness (to specification) of the functions of the software" + "<br></br>" +
                        "<br>Accuracy – refers to the correctness of the functions (e.g., an ATM may provide a cash dispensing function but is the amount correct?)</br>" + "<br></br>" +
                        "<br> Interoperability – refers to the ability of a software component to interact with other components or systems </br>" + "<br></br>" +
                        "<br> Functionality compliance – refers to conformance to appropriate industry standards and guidelines </br>" + "<br></br>" +
                        "<br> Security – covers security aspects of the functionality, e.g., prevention of unauthorized access to the software functions</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: reliability sub-characteristics </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\"> Maturity – concerns frequency of failure of the software" + "<br></br>" +
                        "<br>Fault tolerance – ability of software to withstand (and recover) from component/environmental failure</br>" + "<br></br>" +
                        "<br>Recoverability – ability to bring back a failed system to full operation, including data</br>" + "<br></br>" +
                        "<br>Reliability compliance – ability of the software product to adhere to standards, conventions or regulations relating to reliability</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: usability sub-characteristics </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\"> Understandability – how easy can new and existing users understand the functionality of the product?" + "<br></br>" +
                        "<br>Learnability – how easy is it to learn to use the product? </br>" + "<br></br>" +
                        "<br>Operability – how easy is it to operate the product? Even if learning is easy, operating may be cumbersome due to the menu structure.</br>" + "<br></br>" +
                        "<br>Attractiveness – recent addition to the standard, but very important for software products that users do not have to use (e.g., games)</br>" + "<br></br>" +
                        "<br>Usability compliance – conformance to standards and conventions (e.g., pressing ‘F1’ brings help information on the screen)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: efficiency sub-characteristics</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Time behaviour – what is the “transaction” response time for different throughputs?" + "<br></br>" +
                        "<br>Resource utilization – what are the CPU, memory, disk, network usages associated with different throughputs?</br>" + "<br></br>" +
                        "<br>Efficiency compliance – conformance to standards, conventions, rules</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: maintainability sub-characteristics</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Analyzability – how easy can the cause of a failure be determined?" + "<br></br>" +
                        "<br>Changeability – what amount of effort is required to change the product?</br>" + "<br></br>" +
                        "<br>Stability – how likely are changes to individual components (e.g., bugfixes) to have unexpected side effects on the product?</br>" + "<br></br>" +
                        "<br>Testability – what amount of effort is required to test a system change</br>" + "<br></br>" +
                        "<br>Maintainability compliance – conformance to standards and conventions</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">ISO 9126: portability sub-characteristics </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Adaptibility – refers to the ability of the software to change to new specifications or operating environments" + "<br></br>" +
                        "<br>Installability – refers to the effort required to install the software</br>" + "<br></br>" +
                        "<br>Coexistence – refers to the ability of the software to share resources to other software components</br>" + "<br></br>" +
                        "<br>Replaceability – how easy is it to exchange a software component (e.g., with a third party component, or with a new version of the component)?</br>" + "<br></br>" +
                        "<br>Portability compliance – conformance to standards and conventions that are related to portability</br></font></h4>";
                break;

            // The sixth topic is selected from the spinner
            case "Agile Methodologies":
                content = "<u><b><h1><font color=\"#000000\">What is agile development</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Different focus:" + "<br></br>" +
                        "<br>– Change is something to embrace; we determine what is best for the project as we go along</br>" + "<br></br>" +
                        "<br>– Instead of big-design-upfront and fixed deadlines/costs, focus on client-developer collaboration</br>" + "<br></br>" +
                        "<br>– Keep only the parts of the process that deliver value (no process for the sake of process)</br>" + "<br></br>" +
                        "<br>• Examples of agile methodologies:</br>" + "<br></br>" +
                        "<br>– Scrum</br>" + "<br></br>" +
                        "<br>– Kanban</br>" + "<br></br>" +
                        "<br>Agile benefits</br>" + "<br></br>" +
                        "<br>• Agility allows a better alignment between business objectives and IT</br>" + "<br></br>" +
                        "<br>• Agility provides gains in terms of visibility, adaptability, business value, and risk reduction </br>" + "<br></br>" +
                        "<br>• Costs reduction thanks to better effectiveness </br>" + "<br></br>" +
                        "<br>• Time-to-market reduction</br>" + "<br></br>" +
                        "<br>• Control over change cost</br>" + "<br></br>" +
                        "<br>• Longer life software </br>" + "<br></br>" +
                        "<br>• People aware of their responsibilities, more motivated </br>" + "<br></br>" +
                        "<br>• Problems arise faster</br>" + "<br></br>" +
                        "<br>Agile drawbacks</br>" + "<br></br>" +
                        "<br>• Active user involvement and close collaboration is essential</br>" + "<br></br>" +
                        "<br>• Requirements emerge and evolve </br>" + "<br></br>" +
                        "<br>• Frequent delivery </br>" + "<br></br>" +
                        "<br>• System structure tends to degrade as new increments are added</br>" + "<br></br>" +
                        "<br>• Regular changes to the deliverable usually corrupt the structure unless time & money spent on refactoring</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Values according to Scrum</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">1. Commitment to achieving the goals and supporting each other" + "<br></br>" +
                        "<br>2. Focus on the work of the Sprint to make the best possible progress toward the sprint goal</br>" + "<br></br>" +
                        "<br>3. Openness about the work and the challenges you run into</br>" + "<br></br>" +
                        "<br>4. Respect each other to be capable, independent people</br>" + "<br></br>" +
                        "<br>5. Courage to do the right thing and work on tough problems</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Roles</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Product owner" + "<br></br>" +
                        "<br>– Possibly a Product Manager / Project Sponsor / Key end-user</br>" + "<br></br>" +
                        "<br>– Decides features, release date, prioritisation, budget</br>" + "<br></br>" +
                        "<br>• Scrum Master</br>" + "<br></br>" +
                        "<br>– Typically a Project Manager or Team Leader</br>" + "<br></br>" +
                        "<br>– Responsible for enacting Scrum values and practices </br>" + "<br></br>" +
                        "<br>– Remove impediments / politics, keeps everyone productive</br>" + "<br></br>" +
                        "<br>• Project Team</br>" + "<br></br>" +
                        "<br>– 3-10 members; Teams are self-organising </br>" + "<br></br>" +
                        "<br>– Cross-functional: QA, Programmers, UI Designers, etc. </br>" + "<br></br>" +
                        "<br>– Membership should change only between sprints</br>" + "<br></br>" +
                        "<br>Events</br>" + "<br></br>" +
                        "<br>• Sprint planning</br>" + "<br></br>" +
                        "<br>– Determining what will take place during a sprint</br>" + "<br></br>" +
                        "<br>• Daily stand-up</br>" + "<br></br>" +
                        "<br>– What did I do yesterday, what will I do today, what obstacles am I facing?</br>" + "<br></br>" +
                        "<br>• Sprint review</br>" + "<br></br>" +
                        "<br>– Everyone who wants to attend can attend; accomplishments are shown</br>" + "<br></br>" +
                        "<br>• Sprint retrospective</br>" + "<br></br>" +
                        "<br>– Examining lessons learned for the next sprint</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Advantages of Scrum\n</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Enables projects where the business requirements are hard to quantify to be successfully developed" + "<br></br>" +
                        "<br>• Fast moving, cutting-edge developments can be quickly coded and tested</br>" + "<br></br>" +
                        "<br>• Due to short sprints and constant feedback, it becomes easier to cope with changes</br>" + "<br></br>" +
                        "<br>• Daily meetings make it possible to measure individual productivity. This leads to improvements in the productivity of each team member</br>" + "<br></br>" +
                        "<br>• The overhead cost in terms of process and management is minimal, leading to a quicker, cheaper result.</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Disadvantages of Scrum</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Scrum is one of the leading causes of scope creep because unless there is a definite end date, the project management stakeholders will be tempted to keep demanding new functionality" + "<br></br>" +
                        "<br>• If the team members are not committed, the project will either never complete or fail</br>" + "<br></br>" +
                        "<br>• It is good for small, fast moving projects as it works well with small teams</br>" + "<br></br>" +
                        "<br>• This methodology requires experienced team members</br>" + "<br></br>" +
                        "<br>• If any of the team members leave during a development it can have a huge effect on the project development</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Introduction to Kanban</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Kanban means ‘signboard’ in Japanese" + "<br></br>" +
                        "<br>• Lean method for work management (not just software)</br>" + "<br></br>" +
                        "<br>• Originally used for just-in-time car manufacturing at Toyota (late 1940s), where parts were manufactured only when demanded (‘pulled’)</br>" + "<br></br>" +
                        "<br>• This reduced work-in-progress stocks and quickly pointed to any bottlenecks hidden by traditional push-oriented schedules</br>" + "<br></br>" +
                        "<br>• Adapted for software by David Anderson of Microsoft to handle software maintenance requests</br>" + "<br></br>" +
                        "<br>Kanban Steps</br>" + "<br></br>" +
                        "<br>1. Capture high-level routines</br>" + "<br></br>" +
                        "<br>2. Redecorate your wall</br>" + "<br></br>" +
                        "<br>3. Define done 4.</br>" + "<br></br>" +
                        "<br>Do your daily stand-ups</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Advantages of Kanban</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Ease of use: Kanban is a very simple and easy to understand approach, which makes it practical to apply effectively. No need to be an expert to work with Kanban." + "<br></br>" +
                        "<br>• Promotes continuous and sustainable improvements : Kanban approach not only consists of manual cards but also draws visualizations of the process outputs which makes the analysis of work easier.</br>" + "<br></br>" +
                        "<br>• Adaptability: Kanban encourages maximum adaptability</br>" + "<br></br>" +
                        "<br>• Collaboration: Kanban focuses on collaboration, this makes the team work together to produce the ideal outcomes/deliverables.</br>" + "<br></br>" +
                        "<br>• Low Overheads: Supervision of the use of a Kanban board, cards, and analysis of output is easier as compared to most methods/approaches to project management.</br></font></h4>" + "<br></br>" +

                        "<br><u><b><h1><font color=\"#000000\">Disadvantages of Kanban</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Lack of iteration: building software in iterations is a foundation for most development processes, which is not integral to Kanban at a ticket level. You can build iteration on top of Kanban, but it often ends up being its own separate process" + "<br></br>" +
                        "<br>• Lack of timing: there are no timeframes associated with each phase, which can be disadvantageous</br>" + "<br></br>" +
                        "<br>• Dependency on the board: if the board is not updated, or is too simplistic to begin with, any advantages that come from Kanban are lost</br></font></h4>";
                break;
            default:
                content = "";
                break;
        }

        // Update the text view with the information using html formatting
        Unit1TopicInformation.setText(HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }


}