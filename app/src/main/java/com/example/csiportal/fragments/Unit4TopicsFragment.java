package com.example.csiportal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.csiportal.R;

public class Unit4TopicsFragment extends Fragment {

    // Key for passing the topic number as an argument between activities and fragments.
    private static final String TOPIC_NUMBER4 = "topic_number4";

    // Constructor needed for creating instances of Unit4TopicsFragment
    public Unit4TopicsFragment() {

    }

    // Method to create a new instance of Unit4TopicsFragment with topic number
    public static Unit4TopicsFragment newInstance(int topicNumber4) {

        // Make new instance of fragment
        Unit4TopicsFragment fragment = new Unit4TopicsFragment();

        // Make bundle to hold arguments
        Bundle args = new Bundle();

        // Place the topic number into the arguments bundle
        args.putInt(TOPIC_NUMBER4, topicNumber4);
        fragment.setArguments(args);
        return fragment;
    }

    // Called when the fragment is being created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for fragment
        View view = inflater.inflate(R.layout.unit4_topics, container, false);

        // Access topic number from the arguments
        int topicNumber4 = getArguments().getInt(TOPIC_NUMBER4, 1);

        // Return the inflated view for the fragment
        return view;
    }
}
