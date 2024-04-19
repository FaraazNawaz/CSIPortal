package com.example.csiportal.support;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// Adapter class for managing the learn, quiz and support fragments in viewpager2
public class SupportPageViewPagerAdapter extends FragmentStateAdapter {

    // Constructor for adapter
    public SupportPageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    // Method to create a new fragment for the position in viewpager2
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Switch statement to decide which fragment will be shown based on position
        switch (position) {
            case 1:
                // return a new instance of quiz fragment for position 1
                return new QuizFragment();
            case 2:
                // Return a new instance of profile fragment for position 2
                return new ProfileFragment();
            default:
                // Return learn fragment as the default
                return new LearnFragment();
        }
    }

    // Method for number of items in the viewpager2
    @Override
    public int getItemCount() {
        // Return the 3 fragments
        return 3;
    }
}
