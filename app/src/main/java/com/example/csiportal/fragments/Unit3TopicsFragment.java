package com.example.csiportal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.csiportal.R;

public class Unit3TopicsFragment extends Fragment {

    // Key for passing the topic number as an argument between activities and fragments.
    private static final String TOPIC_NUMBER3 = "topic_number3";

    // Constructor needed for creating instances of Unit3TopicsFragment
    public Unit3TopicsFragment() {

    }

    // Method to create a new instance of Unit3TopicsFragment with topic number
    public static Unit3TopicsFragment newInstance(int topicNumber3) {

        // Make new instance of fragment
        Unit3TopicsFragment fragment = new Unit3TopicsFragment();

        // Make bundle to hold arguments
        Bundle args = new Bundle();

        // Place the topic number into the arguments bundle
        args.putInt(TOPIC_NUMBER3, topicNumber3);
        fragment.setArguments(args);
        return fragment;
    }

    // Called when the fragment is being created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for fragment
        View view = inflater.inflate(R.layout.unit3_topics, container, false);

        // Access topic number from the arguments
        int topicNumber3 = getArguments().getInt(TOPIC_NUMBER3, 1);

        // Return the inflated view for the fragment
        return view;
    }
}
