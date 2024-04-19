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
import com.example.csiportal.fragments.Unit3TopicsFragment;

public class Unit3 extends AppCompatActivity {

    // The spinner variable for selecting topics from dropdown menu
    private Spinner Unit3topics;

    // Text view variable for showing information about topic selected from spinner
    private TextView Unit3TopicInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit3);

        // Set the title to information security and allow the back button to be enabled to go back to learn page
        getSupportActionBar().setTitle("Information Security");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initialize the spinner and the text view
        //Spinner
        Unit3topics = findViewById(R.id.Unit3topics);
        //Text view
        Unit3TopicInformation = findViewById(R.id.Unit3TopicInformation);

        // Set up array adapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unit3topics, R.layout.spinner_topic);

        // Set the layout for how the list of topics will look like
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Unit3topics.setAdapter(adapter);


        // Set up item selected listener for the spinner
        Unit3topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItem, int position, long id) {

                // Handle clicked topic in the spinner list
                String selectedTopic = parent.getItemAtPosition(position).toString();

                // Set information for the clicked topic
                unit3TopicInformation(selectedTopic);

                // Replace current fragment with the clicked topic
                replaceFragment(Unit3TopicsFragment.newInstance(position + 1));
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
        fragmentTransaction.replace(R.id.Unit3fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    //Method to set information in text view using the selected topic from spinner
    private void unit3TopicInformation(String clickedTopic) {

        // Information set for each selected topic from spinner using switch statement
        String content;
        switch (clickedTopic) {

            // The first topic is selected from the spinner
            case "Cryptography":
                content = "<u><b><h1><font color=\"#000000\"> Intro to cryptography and simple shift cyphers</font></h1></b></u>" +
                        "<h4><font color=\"000000\"> Information Security is a field of Computer Science concerned with the protection of computer-system assets: data, software, hardware" + "<br></br>" +
                        "<br>▶ The key goals of security are to ensure asset confidentiality, availability and integrity </br>" + "<br></br>" +
                        "<br>▶ Security engineering </br>" + "<br></br>" +
                        "<br>▶ identifies system vulnerabilities </br>" + "<br></br>" +
                        "<br>▶ implements controls that block threats by removing/reducing vulnerabilities</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\"> Cryptography = “secret writing” (Greek) </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ the art and science of concealing meaning" + "<br></br>" +
                        "<br>▶ strongest control tool against numerous security threats </br>" + "<br></br>" +
                        "<br>▶ building on multiple areas of higher mathematics</br>" + "<br></br>" +
                        "<br>▶ Encryption (encoding, enciphering) = the process of scrambling a message so that its meaning is not obvious</br>" + "<br></br>" +
                        "<br>▶ Decryption (decoding, deciphering) = the reverse process</br>" + "<br></br>" +
                        "<br>“Key = a device used to influence the way in which encryption and decryption are carried out”</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Cryptosystem (cipher) = a system for encryption and decryption</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">“A cryptosystem is a 5-tuple* (E, D, P, C, K) where:" + "<br></br>" +
                        "<br>▶ P is the set of plaintext units** </br>" + "<br></br>" +
                        "<br>▶ C is the set of ciphertext units </br>" + "<br></br>" +
                        "<br>▶ K is the set of (possible) keys </br>" + "<br></br>" +
                        "<br>▶ E : P x K → C is the encryption function</br>" + "<br></br>" +
                        "<br>▶ D : C x K → P is the decryption function</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">The Caesar Cipher </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ The shift cipher with k = 3" + "<br></br>" +
                        "<br>▶ Of historical importance </br>" + "<br></br>" +
                        "<br>▶ said to have been first used by Julius Caesar </br>" + "<br></br>" +
                        "<br>▶ effective in Roman times </br>" + "<br></br>" +
                        "<br>▶relatively safe: few people knew how to read </br>" + "<br></br>" +
                        "<br>▶encryption p → p + 3 mod 26 easy to remember & utilise</br>" + "<br></br>" +
                        "<br>▶ Shift cipher trivial to break in modern times, for any k </br>" + "<br></br>" +
                        "<br>▶ just try all 25 possible keys!*</br></font></h4>";
                break;

            // The second topic is selected from the spinner
            case "Authentication":
                content = "<u><b><h1><font color=\"#000000\">Introduction</font></h1></b></u>" +
                        "<h4><font color=\"000000\">The protection of information-system assets relies on" + "<br></br>" +
                        "<br>• knowing who the user of the system is </br>" + "<br></br>" +
                        "<br>• knowing what operations can be performed by what users and on what data</br>" + "<br></br>" +
                        "<br>User authentication: establishes the identity of IT system users</br>" + "<br></br>" +
                        "<br>Access control: specifies the privileges of authenticated users of an IT system</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Direct Measurement</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• the user could be a person or another IT system" + "<br></br>" +
                        "<br>• based on knowledge shared only by the IT system and the user</br>" + "<br></br>" +
                        "<br>• Authentication mechanisms use any of these characteristics: </br>" + "<br></br>" +
                        "<br>•what the user knows (e.g., password, PIN number)</br>" + "<br></br>" +
                        "<br>• what the user has (e.g., badge, smart card)</br>" + "<br></br>" +
                        "<br>• what the user is (e.g., fingerprints, voice) </br>" + "<br></br>" +
                        "<br>• where the user is (e.g., in front of a particular terminal)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">An authentication system comprises </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">• the authentication information that users supply to prove their identity (e.g., user name and password)" + "<br></br>" +
                        "<br>• the complementary information stored on computer and used to validate authentication information (e.g., set of encrypted passwords for all registered users)</br" + "<br></br>" + "<br></br>" +
                        "<br>• the complementation function that generates the complementary information from the authentication information (e.g., encryption function)</br</font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Passwords </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Sequence of characters" + "<br></br>" +
                        "<br>Examples: 10 digits, a string of letters, etc.</br>" + "<br></br>" +
                        "<br>Generated randomly, by user, by computer with user input</br>" + "<br></br>" +
                        "<br>Sequence of words</br>" + "<br></br>" +
                        "<br>Examples: pass-phrases</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Preventing Attacks</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Keep authentication information secret" + "<br></br>" +
                        "<br>Hide additional components of the authentication system</br>" + "<br></br>" +
                        "<br>Hide complementary information and/or complementation function</br>" + "<br></br>" +
                        "<br>Prevents off-line attacks</br>" + "<br></br>" +
                        "<br>• e.g., new versions of UNIX/Linux use shadow password files that are only visible to users with administrative rights</br>" + "<br></br>" +
                        "<br>Salt passwords</br>" + "<br></br>" +
                        "<br>Prevent attacker from knowing if guess succeeded in part</br>" + "<br></br>" +
                        "<br>• e.g., when only one of user name and password is invalid don’t tell which one is wrong</br>" + "<br></br>" +
                        "<br>Constrain incoming connections to trusted remote machines</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">User Selection of Passwords</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Problem: people pick easy to guess passwords" + "<br></br>" +
                        "<br>Based on account names, user names, computer names, place names </br>" + "<br></br>" +
                        "<br>Dictionary words (also reversed, odd capitalizations, control characters, conjugations or declensions, favourite book words)</br>" + "<br></br>" +
                        "<br>Too short; or digits only; or letters only </br>" + "<br></br>" +
                        "<br>License plates, acronyms, social security numbers </br>" + "<br></br>" +
                        "<br>Personal characteristics (pet names, nicknames, job characteristics, etc.)</br></font></h4>";
                break;

            // The third topic is selected from the spinner
            case "Programming and Operating System Security":
                content = "<u><b><h1><font color=\"#000000\">Secure programs </font></h1></b></u>" +
                        "<h4><font color=\"000000\">Program = software asset of an information system" + "<br></br>" +
                        "<br>• software application </br>" + "<br></br>" +
                        "<br>• device driver </br>" + "<br></br>" +
                        "<br>• operating system code</br>" + "<br></br>" +
                        "<br>• network infrastructure</br>" + "<br></br>" +
                        "<br>Programs are essential components of information systems → program protection is at the heart of information security</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Secure programs </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Reminder: security = confidentiality + integrity + availability" + "<br></br>" +
                        "<br>Secure programs </br>" + "<br></br>" +
                        "<br>• preserve the confidentiality and integrity of sensitive assets within the IT system – including their own </br>" + "<br></br>" +
                        "<br>• fulfil all the requirements associated with availability </br>" + "<br></br>" +
                        "<br>• present in a useable form </br>" + "<br></br>" +
                        "<br>• make clear progress </br>" + "<br></br>" +
                        "<br>• complete in an acceptable period of time </br>" + "<br></br>" +
                        "<br>• handle requests timely and fairly </br>" + "<br></br>" +
                        "<br>• used easily and in the intended way</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Errors, faults and failures</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Error = a mistake made by a human" + "<br></br>" +
                        "<br>• e.g., misinterpretation of a user requirement or a coding mistake</br>" + "<br></br>" +
                        "<br>Fault = incorrect step, command, process or data definition in a computer program</br>" + "<br></br>" +
                        "<br>• the result of an error</br>" + "<br></br>" +
                        "<br>• may be unnoticeable</br>" + "<br></br>" +
                        "<br>Failure = a departure from the required behaviour noticed by a user of the system</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Program security flaw </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Flaw = informal, generic term referring to a fault or failure" + "<br></br>" +
                        "<br>Reminder: vulnerability = weakness that can be exploited to cause loss or harm</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Improper Validation </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Something not checked for consistency or correctness" + "<br></br>" +
                        "<br>Bounds checking</br>" + "<br></br>" +
                        "<br>Type checking</br>" + "<br></br>" +
                        "<br>Error checking</br>" + "<br></br>" +
                        "<br>Checking for valid, not invalid, data</br>" + "<br></br>" +
                        "<br>Checking input</br>" + "<br></br>" +
                        "<br>Designing for validation</br>" + "<br></br>" +
                        "<br>Malicious code: definition</br>" + "<br></br>" +
                        "<br>• Code developed with the intention to cause loss or harm through violating the security of information systems</br></font></h4>";
                break;

            // The fourth topic is selected from the spinner
            case "Network Security":
                content = "<u><b><h1><font color=\"#000000\">Network concepts</font></h1></b></u>" +
                        "<h4><font color=\"000000\">▶ Computer networks = sets of interconnected computers" + "<br></br>" +
                        "<br>▶ support communication between subjects (e.g., applications or users) and sharing of objects (e.g., files or printers)</br>" + "<br></br>" +
                        "<br>▶ Telecommunication networks = sets of communicating nodes and links that support exchanging messages between nodes, over multiple links and through various nodes</br>" + "<br></br>" +
                        "<br>▶ computer networks are one type of telecommunication network</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Why computer networks?</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Significant advantages over single-computer systems</br>" + "<br></br>" +
                        "<br>▶ resource sharing, e.g., databases, storage, software</br>" + "<br></br>" +
                        "<br>▶ distributed applications</br>" + "<br></br>" +
                        "<br>▶ workload balancing across servers and application instances</br>" + "<br></br>" +
                        "<br>▶ increased reliability</br>" + "<br></br>" +
                        "<br>▶ expandability</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Network security</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Network security: concerned with the security of telecommunication networks including computer networks and other networks whose components resemble computers" + "<br></br>" +
                        "<br>▶ there is an ever increasing number of such components (mobile phones, games, consoles, home entertainment units, cars, etc.)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Types of networks</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Local Area Networks (LANs) – network connecting together several small computers and devices such as printers and file storage units" + "<br></br>" +
                        "<br>▶ small: often within a single building</br>" + "<br></br>" +
                        "<br>▶ locally controlled: equipment owned and managed by a single organisation, whose members are the network users</br>" + "<br></br>" +
                        "<br>▶ physically protected: on the premises of the owner</br>" + "<br></br>" +
                        "<br>▶ limited scope: supporting a single organisation or part of it</br>" + "<br></br>" +
                        "<br>▶ Security policies (access control, software used, etc.) relatively easy to establish, deploy and manage”</br>" + "<br></br>" +
                        "<br>▶ Wide Area Networks (WANs) – much larger than LANs in terms of size and covered geographical area, but with some unifying characteristic (e.g., controlled by a single organisation who determines who can join)</br>" + "<br></br>" +
                        "<br>▶ Typically using publically available communications media for at least some parts of the network</br>" + "<br></br>" +
                        "<br>▶ messages exchanged between hosts are not under the control of the WAN administrators for some of the time</br>" + "<br></br>" +
                        "<br>▶ Internetworks (or internets) – connections of 2+ separately managed and controlled networks</br>" + "<br></br>" +
                        "<br>▶ e.g., the Internet</br>" + "<br></br>" +
                        "<br>▶ Security implications</br>" + "<br></br>" +
                        "<br>▶ federation: no centralised control</br>" + "<br></br>" +
                        "<br>▶ enormous</br>" + "<br></br>" +
                        "<br>▶ heterogeneous: at least one of every kind of available hardware and software is likely to be connected to the Internet</br>" + "<br></br>" +
                        "<br>▶ physically and logically exposed: no global access control</br></font></h4>";
                break;

            // The fifth topic is selected from the spinner
            case "Non-Technical Aspects of Security":
                content = "<u><b><h1><font color=\"#000000\">Security Awareness, Training and Education</font></h1></b></u>" +
                        "<h4><font color=\"000000\">▶ Limited understanding of vulnerabilities, threats, controls and value of assets → user errors" + "<br></br>" +
                        "<br>▶ weak passwords</br>" + "<br></br>" +
                        "<br>▶ password disclosure</br>" + "<br></br>" +
                        "<br>▶ switching off security mechanisms (e.g., firewall rules)</br>" + "<br></br>" +
                        "<br>▶ Awareness, training & education provide benefits in:</br>" + "<br></br>" +
                        "<br>▶ improving employee behavior</br>" + "<br></br>" +
                        "<br>▶ increasing employee accountability </br>" + "<br></br>" +
                        "<br>▶ mitigating liability for employee behavior </br>" + "<br></br>" +
                        "<br>▶ complying with regulations and contractual obligations</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Security Learning Continuum</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">Awareness emphasises the importance of security and the role that individual users play in it" + "<br></br>" +
                        "<br>Education teaches users about key security terms and concepts </br>" + "<br></br>" +
                        "<br>Training teaches IT security specialists and some users in detail about vulnerabilities, threats and controls</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Awareness </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Security awareness campaigns often target a specific aspect of security" + "<br></br>" +
                        "<br>▶ dangers of social engineering </br>" + "<br></br>" +
                        "<br>▶ risks of email attachments</br>" + "<br></br>" +
                        "<br>▶ handling sensitive data (e.g., taking copies, backups)</br>" + "<br></br>" +
                        "<br>▶ legal aspects – software licensing, copyright</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Training</font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Teaches what people should do and how they should do it to securely perform tasks involving computer systems" + "<br></br>" +
                        "<br>▶ includes teaching about the value of assets – intellectual property, customer data</br>" + "<br></br>" +
                        "<br>▶ Is targeted at a wide range of user types </br>" + "<br></br>" +
                        "<br>▶ general users need to learn good computer security practices </br>" + "<br></br>" +
                        "<br>▶ developers need to learn secure code development </br>" + "<br></br>" +
                        "<br>▶ managers must understand tradeoffs involving security risks, costs, benefits</br>" + "<br></br>" +
                        "<br>▶ Aims to create enough motivation to justify the extra effort that is required to follow security policies</br>" + "<br></br>" +
                        "<br>▶ users must believe that security threats are real and pose risks to themselves, to others that they care about and to the organisation </br>" + "<br></br>" +
                        "<br>▶ users must understand that they will be held accountable if they do not follow the security policies of their organisation </br>" + "<br></br>" +
                        "<br>▶ Security misconceptions are often the explanation for security breaches </br>" + "<br></br>" +
                        "<br>▶ user may fail to understand threat – “who would bother to target me?”</br>" + "<br></br>" +
                        "<br>▶ users may perceive controls as ineffective against determined attackers</br>" + "<br></br>" +
                        "<br>▶ security-conscious users may be labelled “paranoid” (taking risks is “cool”)</br></font></h4>" +

                        "<br><u><b><h1><font color=\"#000000\">Education </font></h1></b></u></br>" +
                        "<h4><font color=\"000000\">▶ Component targeting in-depth learning" + "<br></br>" +
                        "<br>▶ Targeted at security professionals whose jobs require expertise in security</br>" + "<br></br>" +
                        "<br>▶ significant career development opportunity </br>" + "<br></br>" +
                        "<br>▶ Often provided by outside sources </br>" + "<br></br>" +
                        "<br>▶ college courses </br>" + "<br></br>" +
                        "<br>▶ specialized training programs</br></font></h4>";
                break;
            default:
                content = "";
                break;
        }

        // Update the text view with the information using html formatting
        Unit3TopicInformation.setText(HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_LEGACY));
    }
}