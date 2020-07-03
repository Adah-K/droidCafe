package com.example.mydroidcaffev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflate the toolbar (
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setting the toolbar as the Action Bar for the activity
        //setSupportActionBar(toolbar);
        //Create an instance of the tabLayout and add the three tabs to the tab layout
        TabLayout tablayout = findViewById(R.id.tab_layout);
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_one));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_two));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_three));
        //specifies how an object should position its contents both on X,Y axis.
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //Use the pager adapter to connect the content to the ViewPager which is the view
        //Each page is represented by its own fragment
        //ViewPager is used to swipe or shuffle between screens/pages.
        final ViewPager viewPager= findViewById(R.id.view_pager);
        //Create an instance of the PageAdapter that has Fragment Manager and uses tab layout. TabCount to get
        //the number of tabs
        final PagerAdapter pagerAdapter = new com.example.mydroidcaffev1.PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        //Connecting/setting the adapter to the ViewPager
         viewPager.setAdapter(pagerAdapter);
         //Add PagerListener to know when user clicks or swipes to another page and pass the tab layout to also know when the user changes or clicks to another tab
        //callback interface for responding to adapter changes
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        //Interface invoked when a tab's selection state changes
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //get the position of the tab which enables the page to be loaded after getting the position
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            //When a tab is unselected nothing happens here
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            //When a tab is reselected nothing happens here
            }
        });


    }
}