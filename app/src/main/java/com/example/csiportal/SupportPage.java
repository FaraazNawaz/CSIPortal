package com.example.csiportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.csiportal.support.SupportPageViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class SupportPage extends AppCompatActivity {

    // The tabLayout, viewPager2 and adapter for viewPager2 variables
    TabLayout supportPageTabs;
    ViewPager2 supportPageViewPager;
    SupportPageViewPagerAdapter supportPageViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_page);

        //Set the title for the support page and allow back button to be enabled to go back to the home page
        getSupportActionBar().setTitle("Support");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Initialise the tabLayout, viewPager2 and adapter
        supportPageTabs = findViewById(R.id.SupportPageTabs);
        supportPageViewPager = findViewById(R.id.SupportPageViewPager);

        // Make a new instance of the adapter
        supportPageViewPagerAdapter = new SupportPageViewPagerAdapter(this);


        // Set the adapter for viewPager2
        supportPageViewPager.setAdapter(supportPageViewPagerAdapter);

        // Add a listener to tabLayout for which tab has been selected
        supportPageTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                // Set current item of viewPager 2 to the tabs position
                supportPageViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Register a callback to listen for changes in pages in viewPager2
        supportPageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                // Set tab as the one selected from the 3 available options
                supportPageTabs.getTabAt(position).select();
            }
        });

    }
}