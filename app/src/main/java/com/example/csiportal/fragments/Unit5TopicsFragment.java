package com.example.csiportal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.csiportal.R;

public class Unit5TopicsFragment extends Fragment {

    // Key for passing the topic number as an argument between activities and fragments.
    private static final String TOPIC_NUMBER5 = "topic_number5";

    // Constructor needed for creating instances of Unit5TopicsFragment
    public Unit5TopicsFragment() {

    }

    // Method to create a new instance of Unit5TopicsFragment with topic number
    public static Unit5TopicsFragment newInstance(int topicNumber5) {

        // Make new instance of fragment
        Unit5TopicsFragment fragment = new Unit5TopicsFragment();

        // Make bundle to hold arguments
        Bundle args = new Bundle();

        // Place the topic number into the arguments bundle
        args.putInt(TOPIC_NUMBER5, topicNumber5);
        fragment.setArguments(args);
        return fragment;
    }

    // Called when the fragment is being created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for fragment
        View view = inflater.inflate(R.layout.unit5_topics, container, false);

        // Access topic number from the arguments
        int topicNumber5 = getArguments().getInt(TOPIC_NUMBER5, 1);

        // Return the inflated view for the fragment
        return view;
    }
}
