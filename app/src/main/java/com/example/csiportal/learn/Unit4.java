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
import com.example.csiportal.fragments.Unit4TopicsFragment;

public class Unit4 extends AppCompatActivity {

    private Spinner Unit4topics;
    private TextView Unit4TopicInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit4);

        // Set the title to mobile design and development and allow the back button to be enabled to go back to learn page
        getSupportActionBar().setTitle("Mobile Design and Development");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initialize the spinner and the text view
        //Spinner
        Unit4topics = findViewById(R.id.Unit4topics);
        //Text view
        Unit4TopicInformation = findViewById(R.id.Unit4TopicInformation);

        // Set up array adapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unit4topics, R.layout.spinner_topic);

        // Set the layout for how the list of topics will look like
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Unit4topics.setAdapter(adapter);


    // Set up item selected listener for the spinner
        Unit4topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View selectedItem, int position, long id) {

            // Handle clicked topic in the spinner list
            String selectedTopic = parent.getItemAtPosition(position).toString();

            // Set information for the clicked topic
            unit4TopicInformation(selectedTopic);

            // Replace current fragment with the clicked topic
            replaceFragment(Unit4TopicsFragment.newInstance(position + 1));
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
        fragmentTransaction.replace(R.id.Unit4fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Method to set information in text view using the selected topic from spinner
    private void unit4TopicInformation(String clickedTopic) {

        // Information set for each selected topic from spinner using switch statement
        String content;
        switch (clickedTopic) {

            // The first topic is selected from the spinner
            case "Mobile Interaction Design Introduction":
                content = "<u><b><h1><font color=\"#000000\">Introduction </font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Over 6.64 billion smartphone users (~83% of people) globally..." + "<br></br>" +
                        "<br>▪ ...and the number keeps growing</br>" + "<br></br>" +
                        "<br>▪ 3 times as many mobile phones as personal computers</br>" + "<br></br>" +
                        "<br>▪ >100% penetration in some countries (i.e., some people have >1 device)</br>" + "<br></br>" +
                        "<br>• >130% penetration in western Europe</br>" + "<br></br>" +
                        "<br>• mobile phones are essential part of everyday life for many, many people!</br>" + "<br></br>" +
                        "<br>• mobile phones are truly personal devices</br>" + "<br></br>" +
                        "<br>▪ help people feel safer, less lonely, and more human!</br>" + "<br></br>" +
                        "<br>• uptake of basic mobile devices (phones) = rapid & successful</br>" + "<br></br>" +
                        "<br>▪ more advanced devices = sluggish uptake in comparison</br>" + "<br></br>" +
                        "<br>▪ why? – former meet basic human requirements in very direct ways!</br>" + "<br></br>" +
                        "<br>• Q: how do we spot & develop future mobile user experience?</br>" + "<br></br>" +
                        "<br>• A: mobile interaction design!</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Reasons for poor mobile design</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• 3 key reasons:" + "<br></br>" +
                        "<br>▪ Financial short-termism: perceived financial cost associated with better design</br>" + "<br></br>" +
                        "<br>• product price is more immediately visible than quality of interaction when selecting to purchase</br>" + "<br></br>" +
                        "<br>• quality interaction design increases production costs</br>" + "<br></br>" +
                        "<br>▪ Techno-fixation: emphasis on technology over purpose</br>" + "<br></br>" +
                        "<br>• technological wizardry is exciting to developers and users</br>" + "<br></br>" +
                        "<br>• what’s the point of technical mastery if users’ experience is dull and desperate?</br>" + "<br></br>" +
                        "<br>– it’s like being forced to eat the finest chocolate cake through a straw!</br>" + "<br></br>" +
                        "<br>▪ Overlooking the real bugs: lack of user-based debugging</br>" + "<br></br>" +
                        "<br>• spotting flaws at late stage causes emotional tension for a developer – known as “cognitive dissonance” </br>" + "<br></br>" +
                        "<br>which is overcome by rationalising away problems rather than fixing them</br>" + "<br></br>" +
                        "<br>– “it’s the users’ fault; they need to read the manual!“</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Impacts of poor mobile design</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▪ emotional impact" + "<br></br>" +
                        "<br>▪ economic impact</br>" + "<br></br>" +
                        "<br>▪ ethical impact</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Key points</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• mobile ≠ just mobile phone" + "<br></br>" +
                        "<br>▪ includes handhelds, wearables, badges, RFID tags, even implants </br>" + "<br></br>" +
                        "<br>• interesting interaction possibilities involving audio, touch, gestures </br>" + "<br></br>" +
                        "<br>• rather than “impoverished interfaces”, the trouble is current impoverished designs </br>" + "<br></br>" +
                        "<br>• mobile interaction design is about finding the right way to deploy new technological capabilities to meet real needs </br>" + "<br></br>" +
                        "<br>• without effective mobile interaction design, we will see negative emotional, economic, and ethical impacts</br></font></h4>";
                break;

            // The second topic is selected from the spinner
            case "Mobiles for People":
                content = "<u><b><h1><font color=\"#000000\">Useful</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Our motivation = discovering things that people really want to do – things that they just can’t do without" + "<br></br>" +
                        "<br>▪ seek to produce services that users want to use repeatedly and are happy to spend their money on</br>" + "<br></br>" +
                        "<br>• text messaging seems a difficult activity (even with modern improvements) yet people do it repeatedly and enjoy it – why?</br>" + "<br></br>" +
                        "<br>• for designers, exciting but problematic nature of mobiles is that they don’t conform to work-centred notion of computing</br>" + "<br></br>" +
                        "<br>▪ business-type goals and tasks are relatively easy to analyse and represent</br>" + "<br></br>" +
                        "<br>▪ mobiles reach out to non-business areas of people’s lives, blurring boundaries between work and leisure" + "<br></br>" +
                        "<br>• life is about more than speedy decisions and quick transactions – people are involved in activities over long periods of time, being creative and reflective...and mobiles can support this</br>" + "<br></br>" +
                        "<br>• when developing mobile services, don’t focus on fast-paced, always-on, always connected interaction...how could you help users slow down with more relaxed styles and systems?</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Usable...</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• how often have you lost interest in an app or mobile service soon after downloading/subscribing to it?" + "<br></br>" +
                        "<br>▪ users repeatedly abandon devices/apps</br>" + "<br></br>" +
                        "<br>• usability refers to the way you control and operate the system – the “how” of design and often it is poor</br>" + "<br></br>" +
                        "<br>• Poor usability comes in 2 forms:" + "<br></br>" +
                        "<br>▪ ease of use: whether the device or service is usable in itself – devices/applications are often just difficult to use/operate</br>" + "<br></br>" +
                        "<br>▪ fit-in-context: whether the device or service works in harmony with the things around it</br>" + "<br></br>" +
                        "<br>• poor usability can arise when there is a lack of thought about how the mobile might integrate with other resources and the wider world in which they work/move around</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">User experience...</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Two ways of improving the overall user experience:" + "<br></br>" +
                        "<br>▪ the identity of a product – the message the device sends to users, and the way it makes them feel</br>" + "<br></br>" +
                        "<br>▪ the need to extend the influence of interaction design beyond the technology to the whole package presented to the user – i.e., marketing, customer care, charging plans, etc.</br>" + "<br></br>" +
                        "<br>• aim is to present user with experience that is solid, distinct, understandable, trustworthy, and satisfying</br>" + "<br></br>" +
                        "<br>• Strong identity: making computing disappear is about tidying away the technology so users’ needs remain at the foreground...</br>" + "<br></br>" +
                        "<br>• ...it doesn’t mean that products shouldn’t have clear, discernable, likeable identities...when users are using a mobile, they should know they are using it and enjoy the experience!</br>" + "<br></br>" +
                        "<br>• strong identity contd....</br>" + "<br></br>" +
                        "<br>• iPod = landmark model of how physical elements can give product a strong identity</br>" + "<br></br>" +
                        "<br>• excellent mappings: movement used to scroll gives a good sensation; gesture has direct and clear mapping – i.e., action and its results are obviously linked (e.g., moving your finger clockwise means “more”, anticlockwise “less”)</br>" + "<br></br>" +
                        "<br>• consistency: while the wheel is used to control a large number of features, the uncomplicated mapping always holds – there is a high degree of consistency in the way it works</br></font></h4>";
                break;

            // The third topic is selected from the spinner
            case "Innovating and Interaction Design":
                content = "<u><b><h1><font color=\"#000000\">Introduction…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Billions of users waiting for innovative mobile services that are useful and usable and offer satisfying user experience" + "<br></br>" +
                        "<br>• without innovation, organisations and economies tend to stagnate</br>" + "<br></br>" +
                        "<br>• governments recognise this by investing in innovation, science parks, and linking up industry with academia</br>" + "<br></br>" +
                        "<br>• commercial enterprises recognise this by reinvesting substantial proportions of their revenues back into research (e.g., in 2003, Nokia reinvested 13% of net sales)”</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Types of innovation…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Notion of sustaining and disruptive innovations" + "<br></br>" +
                        "<br>• sustaining innovations give customers more of what they already have and want</br>" + "<br></br>" +
                        "<br>▪ e.g., increasingly sophisticated camera phones</br>" + "<br></br>" +
                        "<br>▪ some are incremental (e.g., increased storage capacity on small hard drives)</br>" + "<br></br>" +
                        "<br>▪ some are more radical – introducing distinct types of technology (e.g., auto-sensed context based phone setting adjustment)" + "<br></br>" +
                        "<br>• disruptive innovations disrupt the status quo: turn accepted order on its head</br>" + "<br></br>" +
                        "<br>▪ redefine what success is</br>" + "<br></br>" +
                        "<br>▪ radical difference means that they are often sidelined or rejected</br>" + "<br></br>" +
                        "<br>▪ e.g., SMS was a disruptive innovation which was initially overlooked</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Transferring from the desktop…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Obvious innovation strategy is to take approaches that were successful on the PC and bring them to the mobile" + "<br></br>" +
                        "<br>▪ either at application level or in terms of look and feel</br>" + "<br></br>" +
                        "<br>• application level – if something is highly desired on desktop, then why not let users access it on mobile devices too?</br>" + "<br></br>" +
                        "<br>▪ comfort of anticipated success</br>" + "<br></br>" +
                        "<br>▪ allow users to carry on activity started on desktop</br>" + "<br></br>" +
                        "<br>▪ degree of re-learning will be minimal</br>" + "<br></br>" +
                        "<br>• UI level – giving mobile familiar look and feel might help cut down on learning needed to use mobile device</br>" + "<br></br>" +
                        "<br>▪ useful in marketing</br>" + "<br></br>" +
                        "<br>• just because a type of app or style of UI works well on one platform doesn’t mean it will be so effective on another</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Transferring from the desktop: applications…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• e.g., highlighting thinking and pitfalls = Instant Messaging (IM)" + "<br></br>" +
                        "<br>• highly popular, especially among teenagers: IM = ‘social glue’</br>" + "<br></br>" +
                        "<br>• given apparent similarities with SMS, wireless providers looked at offering IM-type services on mobile devices</br>" + "<br></br>" +
                        "<br>• research on why and how people use IM on desktops hints at some problems – simply providing similar features on mobile will not be success providers hope for:</br>" + "<br></br>" +
                        "<br>▪ teenagers use IM in parallel with our computer-based activities – on small screen, how do you allow a user to monitor IM and carry out other activities?</br>" + "<br></br>" +
                        "<br>▪ often teenagers have more than one IM window open, being involved in concurrent conversations – how can more than one thread be supported when screen space is limited?”</br></font></h4>";
                break;

            // The fourth topic is selected from the spinner
            case "Design Directions":
                content = "<u><b><h1><font color=\"#000000\">Introduction…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Mobile technologies should be used to augment human behaviour not to modify it" + "<br></br>" +
                        "<br>• need to seriously consider how to provide effective mechanisms by which users can control complex functions</br>" + "<br></br>" +
                        "<br>• menus have long been used in mobile devices – but are menus best optimised for small screen use?</br>" + "<br></br>" +
                        "<br>• how can access to information be best supported? how best can we support effective browsing and searching?</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Menus and memory…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Menus are almost ubiquitous on mobile devices, but is this a good thing?" + "<br></br>" +
                        "<br>• we know that menus are easy to use as they facilitate recognition rather than recall</br>" + "<br></br>" +
                        "<br>▪ using a menu, the user can see the available options and select the one that is most appropriate...</br>" + "<br></br>" +
                        "<br>▪ ...but on a small screen, user cannot see all the options at once – have to scroll from option to option which reintroduces the recall problem as users have to remember options as they scroll off screen</br>" + "<br></br>" +
                        "<br>▪ Miller’s 7±2 rule indicates our short term memory capacity but if a small screen only displays one item at a time and there are >7 items, users are likely to have forgotten the first item by the time they reach end of the menu</br>" + "<br></br>" +
                        "<br>• especially problematic for looping menus (seemingly endless list of options)</br>" + "<br></br>" +
                        "<br>• menus on small screens cause issues...but just how serious is the problem?</br>" + "<br></br>" +
                        "<br>• time taken to select options increases as display size drops</br>" + "<br></br>" +
                        "<br>▪ most significantly or drastically when display is reduced to a single line where not only does the time taken to select disproportionately increase, but so too does the number of selection errors</br>" + "<br></br>" +
                        "<br>• mobile devices which display >1 option at a time (ideally 3+) have performance characteristics that are similar to a large screen...displaying only one option at a time makes system disproportionately more difficult to use</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Hierarchical menus…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• hierarchical menus overcome problem of overloading users’ short-term memory but place new burden on users...forcing them to remember function’s location in 2D navigational structure" + "<br></br>" +
                        "<br>• when users eventually become familiar with structure, they can rapidly find items they are looking for...but when unfamiliar, users often struggle</br>" + "<br></br>" +
                        "<br>• when expert, users perform ‘identity mapping’ whereby they scan until they see the name they are looking for...menu usage is therefore not a problem</br>" + "<br></br>" +
                        "<br>• novice users engage in slower form of searching known as ‘class-inclusion’</br>" + "<br></br>" +
                        "<br>▪ have to repeatedly make decisions about higher-level menus to decide whether their target is contained within a given sub-menu</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Impact of small screens…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• 2 fundamental information activities = browsing & searching" + "<br></br>" +
                        "<br>▪ Browsing = moving through content, using access paths; it is all about finding things via navigation</br>" + "<br></br>" +
                        "<br>▪ Searching = locating information resources in direct ways; it is all about finding things via querying</br>" + "<br></br>" +
                        "<br>▪ small display areas are part and parcel of the whole mobile gig</br>" + "<br></br>" +
                        "<br>▪ while displays will continue to improve, very real constraint of screen size (viewable screen) will remain just because the device has to remain pocketable</br>" + "<br></br>" +
                        "<br>• faced with world of information presented via a diminutive window</br>" + "<br></br>" +
                        "<br>▪ reading bite sized chunks of text, users cope well</br>" + "<br></br>" +
                        "<br>▪ supporting browsing & searching needs careful design</br></font></h4>";
                break;

            // The fifth topic is selected from the spinner
            case "Mobile Evaluation":
                content = "<u><b><h1><font color=\"#000000\">Introduction…</font></h1></b></u>" +
                        "<h4><font color=\"000000\">• Why evaluate?" + "<br></br>" +
                        "<br>• you will never second-guess how people use your designs</br>" + "<br></br>" +
                        "<br>• we all get emotionally attached to our designs and need perspective</br>" + "<br></br>" +
                        "<br>▪ yes, your baby may be ugly!</br>" + "<br></br>" +
                        "<br>• Evaluation is all about humility</br>" + "<br></br>" +
                        "<br>• no matter how good you think your design is, there will always be something you missed...users are very good at doing what you don’t expect them to do!</br>" + "<br></br>" +
                        "<br>• need to consider how the evaluation of mobile systems differs from that of desktop systems so we can assess the applicability of traditional evaluation approaches</br>" + "<br></br>" +
                        "<br>• Fundamentally, need to consider:</br>" + "<br></br>" +
                        "<br>▪ On whom? – don’t always have to include end users</br>" + "<br></br>" +
                        "<br>▪ Where? – lab v. field</br>" + "<br></br>" +
                        "<br>▪ Results – different techniques inform the design process in different ways...from anecdotal evidence to complex stats</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Quick and dirty…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• First evaluations will be on initial design ideas themselves..." + "<br></br>" +
                        "<br>• ...so goal is to get rapid, broad-brush feedback on the design</br>" + "<br></br>" +
                        "<br>• end users in an informal environment with a lo-fi prototype</br>" + "<br></br>" +
                        "<br>▪ show and tell...“what do you think of this?”</br>" + "<br></br>" +
                        "<br>• results are typically anecdotal and unstructured</br>" + "<br></br>" +
                        "<br>• this type of rapid user test makes sure ideas are sensible and relevant</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Conceptual model extraction…</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• Goal is to see how users interpret a completely new interface given their existing mental models of how things should work" + "<br></br>" +
                        "<br>• end users in a controlled environment with an interface sketch</br>" + "<br></br>" +
                        "<br>• results are typically qualitative</br>" + "<br></br>" +
                        "<br>• e.g., HP did a lot of conceptual model extraction when developing the first digital camera</br>" + "<br></br>" +
                        "<br>▪ ‘skyscraper stack’ v. ‘messy stack’ for showing how many photos had been taken</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Interviews...</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• end users with an interactive prototype in a controlled environment" + "<br></br>" +
                        "<br>• results are typically qualitative</br>" + "<br></br>" +
                        "<br>• hard to do without biasing outcome</br>" + "<br></br>" +
                        "<br>• conducting interviews instead of observing users can lead to information being missed...</br>" + "<br></br>" +
                        "<br>▪ ...users are incredibly bad at explaining and deconstructing how they achieve tasks</br>" + "<br></br>" +
                        "<br>▪ frequently repeated tasks are chunked together and become second nature</br>" + "<br></br>" +
                        "<br>• e.g., changing gear in a manual car</br>" + "<br></br>" +
                        "<br>• interviews are best used in conjunction with video or artefact walkthrough</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Questionnaires...</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• end users with an interactive prototype and a questionnaire" + "<br></br>" +
                        "<br>• can be done anywhere, including online</br>" + "<br></br>" +
                        "<br>• results are a mix of qualitative and quantitative</br>" + "<br></br>" +
                        "<br>• can reach large audience, cheap to administer, rapid analysis</br>" + "<br></br>" +
                        "<br>• designing a good questionnaire is complicated...often best left to experts</br></font></h4>";
                break;
            default:
                content = "";
                break;
        }

        // Update the text view with the information using html formatting
        Unit4TopicInformation.setText(HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }
}