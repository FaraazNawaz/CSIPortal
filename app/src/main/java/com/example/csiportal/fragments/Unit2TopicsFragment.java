package com.example.csiportal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.csiportal.R;

public class Unit2TopicsFragment extends Fragment {

    // Key for passing the topic number as an argument between activities and fragments.
    private static final String TOPIC_NUMBER2 = "topic_number2";

    // Constructor needed for creating instances of Unit2TopicsFragment
    public Unit2TopicsFragment() {

    }

    // Method to create a new instance of Unit2TopicsFragment with topic number
    public static Unit2TopicsFragment newInstance(int topicNumber2) {

        // Make new instance of fragment
        Unit2TopicsFragment fragment = new Unit2TopicsFragment();

        // Make bundle to hold arguments
        Bundle args = new Bundle();

        // Place the topic number into the arguments bundle
        args.putInt(TOPIC_NUMBER2, topicNumber2);
        fragment.setArguments(args);
        return fragment;
    }

    // Called when the fragment is being created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for fragment
        View view = inflater.inflate(R.layout.unit2_topics, container, false);

        // Access topic number from the arguments
        int topicNumber2 = getArguments().getInt(TOPIC_NUMBER2, 1);

        // Return the inflated view for the fragment
        return view;
    }
}
