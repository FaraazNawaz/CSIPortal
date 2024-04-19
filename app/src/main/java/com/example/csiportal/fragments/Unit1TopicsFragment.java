package com.example.csiportal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.csiportal.R;

public class Unit1TopicsFragment extends Fragment {

    // Key for passing the topic number as an argument between activities and fragments.
    private static final String TOPIC_NUMBER = "topic_number";

    // Constructor needed for creating instances of Unit1TopicsFragment
    public Unit1TopicsFragment() {

    }

    // Method to create a new instance of Unit1TopicsFragment with topic number
    public static Unit1TopicsFragment newInstance(int topicNumber) {

        // Make new instance of fragment
        Unit1TopicsFragment fragment = new Unit1TopicsFragment();

        // Make bundle to hold arguments
        Bundle args = new Bundle();

        // Place the topic number into the arguments bundle
        args.putInt(TOPIC_NUMBER, topicNumber);
        fragment.setArguments(args);
        return fragment;
    }


    // Called when the fragment is being created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for fragment
        View view = inflater.inflate(R.layout.unit1_topics, container, false);

        // Access topic number from the arguments
        int topicNumber = getArguments().getInt(TOPIC_NUMBER, 1);

        // Return the inflated view for the fragment
        return view;
    }
}

