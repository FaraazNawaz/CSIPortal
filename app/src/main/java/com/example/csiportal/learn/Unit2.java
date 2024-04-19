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
import com.example.csiportal.fragments.Unit1TopicsFragment;
import com.example.csiportal.fragments.Unit2TopicsFragment;

public class Unit2 extends AppCompatActivity {

    // The spinner variable for selecting topics from dropdown menu
    private Spinner Unit2topics;

    // Text view variable for showing information about topic selected from spinner
    private TextView Unit2TopicInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2);

        // Set the title to human computer interaction and allow the back button to be enabled to go back to learn page
        getSupportActionBar().setTitle("Human Computer Interaction");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initialize the spinner and the text view
        //Spinner
        Unit2topics = findViewById(R.id.Unit2topics);
        //Text view
        Unit2TopicInformation = findViewById(R.id.Unit2TopicInformation);

        // Set up array adapter for the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unit2topics, R.layout.spinner_topic);

        // Set the layout for how the list of topics will look like
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Unit2topics.setAdapter(adapter);


        // Set up item selected listener for the spinner
        Unit2topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItem, int position, long id) {

                // Handle clicked topic in the spinner list
                String selectedTopic = parent.getItemAtPosition(position).toString();

                // Set information for the clicked topic
                unit2TopicInformation(selectedTopic);

                // Replace current fragment with the clicked topic
                replaceFragment(Unit2TopicsFragment.newInstance(position + 1));
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
        fragmentTransaction.replace(R.id.Unit2fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Method to set information in text view using the selected topic from spinner
    private void unit2TopicInformation(String clickedTopic) {

        // Information set for each selected topic from spinner using switch statement
        String content;
        switch (clickedTopic) {

            // The first topic is selected from the spinner
            case "Understanding the User":
                content = "<u><b><h1><font color=\"#000000\">Why do we need to ‘understand’ users?…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">The process of interacting with technology is cognitive to design successful UIs we need to take into account the cognitive processes involved and the cognitive limitations of users" + "<br></br>" +
                        "<br>• establish knowledge about what users can and cannot be expected to do</br>" + "<br></br>" +
                        "<br>• identify and explain the nature and causes of problems users encounter </br>" + "<br></br>" +
                        "<br>• establish theories, modelling tools, guidance, and methods that can lead to the design of better interactive products</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">What is cognition?…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">cognition is what goes on inside our heads when we perform everyday activities" + "<br></br>" +
                        "<br>cognition involves cognitive processes like thinking, remembering, learning, daydreaming, decision-making, seeing, reading, writing, talking, etc.</br>" + "<br></br>" +
                        "<br>Norman distinguishes 2 modes of cognition:</br>" + "<br></br>" +
                        "<br>• experiential cognition – state of mind in which we perceive, act, and react to events effectively and effortlessly</br>" + "<br></br>" +
                        "<br>requires reaching certain level of expertise and engagement</br>" + "<br></br>" +
                        "<br>• e.g., driving a car, reading a book, conversing, playing a game</br>" + "<br></br>" +
                        "<br>• reflective cognition – involves thinking, comparing, and decision-making</br>" + "<br></br>" +
                        "<br>leads to new ideas and creativity</br>" + "<br></br>" +
                        "<br>• e.g., designing, learning, and writing a book</br>" + "<br></br>" +
                        "<br>both types of cognition are essential for everyday life but each requires different kinds of technological support</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Core components of cognition…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">cognition includes different kinds of core processes:" + "<br></br>" +
                        "<br>• attention</br>" + "<br></br>" +
                        "<br>• perception and recognition</br>" + "<br></br>" +
                        "<br>• memory</br>" + "<br></br>" +
                        "<br>• learning</br>" + "<br></br>" +
                        "<br>• reading, speaking, and listening</br>" + "<br></br>" +
                        "<br>• problem-solving, planning, reasoning, and decision-making</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Attention…\n</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">the process of selecting things to concentrate on (at any given point in time) from the range of possibilities" + "<br></br>" +
                        "<br>involves auditory and visual senses</br>" + "<br></br>" +
                        "<br>• e.g., waiting for our name to be called out in dentist’s waiting room</br>" + "<br></br>" +
                        "<br>• e.g., scanning football results in the paper</br>" + "<br></br>" +
                        "<br>• allows us to focus on the information that is relevant to what we are doing</br>" + "<br></br>" +
                        "<br>whether this is easy or difficult depends on:</br>" + "<br></br>" +
                        "<br>• whether we have clear goals – if we know precisely what we want to find out, we try to match this with the information that is available</br>" + "<br></br>" +
                        "<br>• how salient the information is within the environment – the way information is presented can influence how easy or difficult it is to attend to appropriate pieces of information</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Perception and Recognition…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Perception refers to how information is acquired from the environment via our different senses and transformed into experiences" + "<br></br>" +
                        "<br>• vision is most dominant sense for sighted people, followed by hearing and touch</br>" + "<br></br>" +
                        "<br>• perception is complex – involves other cognitive processes such as memory, attention, and language</br>" + "<br></br>" +
                        "<br>In UI design, it is important to present information (i.e., design data representations) in a way that can be readily perceived in the manner intended</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Memory…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Involves encoding knowledge and then recalling it to allow us to act appropriately" + "<br></br>" +
                        "<br>• not possible to remember everything we sense</br>" + "<br></br>" +
                        "<br>• use a filtering process which initially encodes the information to determine what </br>" + "<br></br>" +
                        "<br>• information we attend to and how to interpret it</br>" + "<br></br>" +
                        "<br>• extent of this process determines our ability to later recall the information</br>" + "<br></br>" +
                        "<br>• the more attention and thought at the time, the more likely it is to be remembered</br>" + "<br></br>" +
                        "<br>• how information is interpreted when it is encountered affects its representation in memory and how easy it is to retrieve subsequently</br>" + "<br></br>" +
                        "<br>• e.g., when learning about HCI, it is much better to reflect upon it, carry out exercises, have discussions with others about it, and write notes than just passively read a book or listen to a lecture – hence the importance of work in your own time and the practical assignments!</br></font></h4>";
                break;

            // The second topic is selected from the spinner
            case "User-Centred Design(UCD)":
                content = "<u><b><h1><font color=\"#000000\">What is involved in interaction design?…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">It is a process:" + "<br></br>" +
                        "<br>• a goal-directed problem-solving activity informed by intended use, target domain, materials costs, and feasibility</br>" + "<br></br>" +
                        "<br>• a creative activity</br>" + "<br></br>" +
                        "<br>• a decision-making activity to balance trade-offs</br>" + "<br></br>" +
                        "<br>• it is a representation:</br>" + "<br></br>" +
                        "<br>• a plan for development</br>" + "<br></br>" +
                        "<br>• a set of alternatives and successive elaborations</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">The importance of involving users…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Expectation management:" + "<br></br>" +
                        "<br>• realistic expectations</br>" + "<br></br>" +
                        "<br>• no surprises, no disappointments</br>" + "<br></br>" +
                        "<br>• timely training</br>" + "<br></br>" +
                        "<br>• communication, but no hype</br>" + "<br></br>" +
                        "<br>Ownership:</br>" + "<br></br>" +
                        "<br>• make the users active stakeholders</br>" + "<br></br>" +
                        "<br>• more likely to forgive or accept problems</br>" + "<br></br>" +
                        "<br>• can make a big difference to acceptance and success of product</br>" + "<br></br>" +
                        "<br>• best way to ensure development continues to take users’ activities into account is to involve real users throughout development</br>" + "<br></br>" +
                        "<br>• user involvement is best way to gain better understanding of users’ goals – leads to a more appropriate, usable product</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">4 basic interaction design activities…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">4 basic activities in interaction/interface design:" + "<br></br>" +
                        "<br>Identifying needs and establishing requirements</br>" + "<br></br>" +
                        "<br>To design something to support people, need to understand who target users are and what kind of support could prove useful</br>" + "<br></br>" +
                        "<br>• fundamental to a user-centred approach and interaction design</br>" + "<br></br>" +
                        "<br>Developing alternative designs</br>" + "<br></br>" +
                        "<br>• core activity of designing – suggesting ideas for meeting requirements</br>" + "<br></br>" +
                        "<br>Conceptual design: conceptual model describing what the product should do, what it should look like, and how it should behave</br>" + "<br></br>" +
                        "<br>Physical design: detail of the design including colours, sounds, menus, etc.</br>" + "<br></br>" +
                        "<br>Building interactive versions of designs</br>" + "<br></br>" +
                        "<br>• most sensible way for users to evaluate designs is to interact with them in some way</br>" + "<br></br>" +
                        "<br>• evaluating designs</br>" + "<br></br>" +
                        "<br>• determining the usability and acceptability of the product</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">What is User-Centred Design (UCD)?…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">UCD is a philosophy as well as a design process" + "<br></br>" +
                        "<br>Based on premise that design should emerge from users’:</br>" + "<br></br>" +
                        "<br>• tasks</br>" + "<br></br>" +
                        "<br>• goals </br>" + "<br></br>" +
                        "<br>• environment </br>" + "<br></br>" +
                        "<br>Process focuses on human-centric issues:</br>" + "<br></br>" +
                        "<br>• cognition</br>" + "<br></br>" +
                        "<br>• perception </br>" + "<br></br>" +
                        "<br>• physical attributes and conditions of:</br>" + "<br></br>" +
                        "<br>• user</br></font></h4>";
                break;

            // The third topic is selected from the spinner
            case "Knowledge Elicitation":
                content = "<u><b><h1><font color=\"#000000\">Discovery in interaction design…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">First phase of an interaction design project is discovery phase" + "<br></br>" +
                        "<br>• identify and document work flow in rich detail</br>" + "<br></br>" +
                        "<br>• discovery involves data collection and interpretation</br>" + "<br></br>" +
                        "<br>• collect the information and organise then document it</br>" + "<br></br>" +
                        "<br>• during discovery, need to keep an open mind:</br>" + "<br></br>" +
                        "<br>• impact of technology on way people interact with each other</br>" + "<br></br>" +
                        "<br>• impact of proposed system on how people feel about the work they do</br>" + "<br></br>" +
                        "<br>• need to be flexible about what type of system is appropriate & how technology fits into the work flow in general</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data collection…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">What we learn during discovery phase sets course for design process" + "<br></br>" +
                        "<br>During the data collection part of the discovery phase, we formally identify:</br>" + "<br></br>" +
                        "<br>• people who are involved with the work</br>" + "<br></br>" +
                        "<br>• things they use to do the work</br>" + "<br></br>" +
                        "<br>• processes that are involved in the work</br>" + "<br></br>" +
                        "<br>• information required to do the work</br>" + "<br></br>" +
                        "<br>• constraints imposed on the work</br>" + "<br></br>" +
                        "<br>• inputs required by the work</br>" + "<br></br>" +
                        "<br>• outputs created by the work</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Interpretation…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">We then interpret the information about the work process by:" + "<br></br>" +
                        "<br>• creating descriptions of the people who do the work</br>" + "<br></br>" +
                        "<br>• describing the different goals involved in the work</br>" + "<br></br>" +
                        "<br>• documenting the work step by step</br>" + "<br></br>" +
                        "<br>• creating different stories about how the various aspects of the work are done</br>" + "<br></br>" +
                        "<br>• creating charts and diagrams of the work flow</br>" + "<br></br>" +
                        "<br>• tracing the different stories identified with the various people through the charts and diagrams</br>”</font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data collection…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">How do interaction designers begin to get a feel for the work flow and user needs?" + "<br></br>" +
                        "<br>Need to talk with or observe the people involved</br>" + "<br></br>" +
                        "<br>End users can supply insight into work and how it should be done, participate in design process (even as design team members), or can be observed in their work place</br>" + "<br></br>" +
                        "<br>• important to get users’ “buy-in” to the design process</br>" + "<br></br>" +
                        "<br>• need to feel empowered by proposed changes, not threatened by them</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Data collection methods…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">2 basic methods of collecting information about a potential design:" + "<br></br>" +
                        "<br>Observation: valuable information can be obtained by watching people perform their activities in the context of the work environment</br>" + "<br></br>" +
                        "<br>• observations can be made directly or indirectly using video and audio recordings</br>" + "<br></br>" +
                        "<br>Elicitation: elicitation methods involve direct and indirect methods of investigation such as interviews, focus groups, and questionnaires</br>" + "<br></br>" +
                        "<br>• techniques can be combined depending on the study focus, participants, nature of technique, and available resources</br></font></h4>";
                break;

            // The fourth topic is selected from the spinner
            case "Prototyping":
                content = "<u><b><h1><font color=\"#000000\">What is a prototype?… </font></h1></b></u>" +
                        "<h4><font color=\"000000\">In interaction design a prototype can be (amongst other things):" + "<br></br>" +
                        "<br>• a series of screen sketches</br>" + "<br></br>" +
                        "<br>• a storyboard – i.e., cartoon-like series of scenes</br>" + "<br></br>" +
                        "<br>• a PowerPoint slide show </br>" + "<br></br>" +
                        "<br>• a video simulating the use of a system</br>" + "<br></br>" +
                        "<br>• a lump of wood (e.g., a handheld device) </br>" + "<br></br>" +
                        "<br>• a cardboard mock-up </br>" + "<br></br>" +
                        "<br>• a piece of software with limited functionality </br>" + "<br></br>" +
                        "<br>• a prototype is a design in a form that lets stakeholders interact with an envisioned product in order to gain some experience of using it</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Why prototype?… </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Purpose: to demonstrate a set of (often abstract) ideas about a computer system in a concrete form" + "<br></br>" +
                        "<br>Prototypes are experimental, incomplete designs which permit users to become involved in the UI development process – both in design and testing </br>" + "<br></br>" +
                        "<br>• more likely to build the right thing!</br>" + "<br></br>" +
                        "<br>• more likely to build the right thing right!</br>" + "<br></br>" +
                        "<br>• developing prototypes is an integral part of iterative UCD </br>" + "<br></br>" +
                        "<br>• lets designers try out ideas with users to gather feedback</br>" + "<br></br>" +
                        "<br>• central role of a prototype in usability testing is to demonstrate and test aspects of HCI without inappropriate levels of time/cost investment </br>" + "<br></br>" +
                        "<br>• typically cost savings in the long run</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Prototype scope…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Full prototype contains complete functionality but not necessarily full performance</br>" + "<br></br>" +
                        "<br>• horizontal prototype contains all the high level functionality of a system but misses out the lower level detail</br>" + "<br></br>" +
                        "<br>• vertical prototype contains all of the high and low level functionality for a restricted part of the system</br>" + "<br></br>" +
                        "<br>Horizontal v. Vertical can be seen as balancing compromises</br>" + "<br></br>" +
                        "<br>• global prototype is similar to the horizontal prototype but, as well as breadth, can also have a good deal of depth</br>" + "<br></br>" +
                        "<br>• local prototype is a prototype of a single, specific detail (typically one that is important enough to potentially affect overall system usability)</br>" + "<br></br>" +
                        "<br>• used to evaluate design alternatives for a particular isolated interaction detail. If developed in detail, can be similar to a vertical prototype</br>" + "<br></br>" +
                        "<br>• local prototypes are typically stand-alone and have a very short life span</br>" + "<br></br>" +
                        "<br>• global prototypes are useful throughout the entire design process</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Prototyping fidelity: low-fidelity…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">low-fidelity prototyping involves the use of materials that are unlike the final product medium – e.g., paper, cardboard" + "<br></br>" +
                        "<br>• cheaper and faster to develop</br>" + "<br></br>" +
                        "<br>• easy to change</br>" + "<br></br>" +
                        "<br>Examples:</br>" + "<br></br>" +
                        "<br>• storyboards</br>" + "<br></br>" +
                        "<br>• screen sketches</br>" + "<br></br>" +
                        "<br>• Post-It™ notes</br>" + "<br></br>" +
                        "<br>• Wizard-of-Oz</br>" + "<br></br>" +
                        "<br>• paper prototypes</br></font></h4>";
                break;

            // The fifth topic is selected from the spinner
            case "Evaluation":
                content = "<u><b><h1><font color=\"#000000\">Knowledge elicitation v evaluation…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">Knowledge elicitation refers to data gathering (discovery) for the purpose of initially informing design (requirements capture) and/or surveying practice/attitudes, etc." + "<br></br>" +
                        "<br>Evaluation</br>" + "<br></br>" +
                        "<br>• concerned with gathering data about the usability of a design or product</br>" + "<br></br>" +
                        "<br>• terms often used interchangeably</br>" + "<br></br>" +
                        "<br>• available techniques are often applicable to both</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Where the processes fit in…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Knowledge elicitation is completed to:" + "<br></br>" +
                        "<br>• create design team’s understanding of users’ requirements</br>" + "<br></br>" +
                        "<br>• generate initial design ideas</br>" + "<br></br>" +
                        "<br>Evaluation is completed to:</br>" + "<br></br>" +
                        "<br>• predict usability of product or an aspect of a product</br>" + "<br></br>" +
                        "<br>• informally or formally test out ideas</br>" + "<br></br>" +
                        "<br>• select from set of design alternatives</br>" + "<br></br>" +
                        "<br>• identify user difficulties</br>" + "<br></br>" +
                        "<br>• fine tune product to better meet user needs</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Associated goals…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Goals of knowledge elicitation are to assess:" + "<br></br>" +
                        "<br>• user activity/attitudes/practice</br>" + "<br></br>" +
                        "<br>• its implications on the introduction of technology</br>" + "<br></br>" +
                        "<br>Functional requirements</br>" + "<br></br>" +
                        "<br>• what does a system and interface need to do?</br>" + "<br></br>" +
                        "<br>Non-functional requirements</br>" + "<br></br>" +
                        "<br>• what constraints are placed on the implementation?</br>" + "<br></br>" +
                        "<br>What benchmarks must be met?</br>" + "<br></br>" +
                        "<br>Goals of evaluation are to assess:</br>" + "<br></br>" +
                        "<br>• usability</br>" + "<br></br>" +
                        "<br>What is the effect of the interaction design on the user (efficiency, effectiveness, and satisfaction)?</br>" + "<br></br>" +
                        "<br>• functionality</br>" + "<br></br>" +
                        "<br>• does the system provide the required functionality?</br>" + "<br></br>" +
                        "<br>• problems in the design</br>" + "<br></br>" +
                        "<br>• what aspects of the design cause unexpected results or confusion?</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Evaluation lets us: </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Evaluation lets us:</br>" + "<br></br>" +
                        "<br>• compare designs</br>" + "<br></br>" +
                        "<br>• which is best?</br>" + "<br></br>" +
                        "<br>• engineer towards a target</br>" + "<br></br>" +
                        "<br>• is it good enough?</br>" + "<br></br>" + "<br></br>" +
                        "<br>• assess conformance with standards</br>" + "<br></br>" +
                        "<br>e.g., is screen legibility acceptable?</br>" + "<br></br>" +
                        "<br>Validate v. verify</br>" + "<br></br>" +
                        "<br>• have we built the right thing?</br></font></h4>";
                break;
            default:
                content = "";
                break;
        }

        // Update the text view with the information using html formatting
        Unit2TopicInformation.setText(HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

}