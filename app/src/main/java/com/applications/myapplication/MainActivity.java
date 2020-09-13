package com.applications.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;

import biz.laenger.android.vpbs.BottomSheetUtils;

public class MainActivity extends AppCompatActivity {


    private String[] tabTitles = new String[]{"Highlights", "Science", "Gaming", "Movies"};
    private int[] imageResId = {R.drawable.highlights, R.drawable.science, R.drawable.gaming, R.drawable.movies};

    BottomSheetBehavior bottomSheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_layout);


        final ViewPager viewPager = findViewById(R.id.viewPager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        /*View view = findViewById(R.id.nsv);
        bottomSheetBehavior = BottomSheetBehavior.from(view);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);*/

        TabItem tabHighlights = findViewById(R.id.tab_highlights);
        TabItem tabScience = findViewById(R.id.tab_science);
        TabItem tabGaming = findViewById(R.id.tab_gaming);
        TabItem tabMovies = findViewById(R.id.tab_movies);

        /*Button button = (Button)findViewById(R.id.press);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });*/


        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        tabLayout.setupWithViewPager(viewPager);



        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tab);

        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab1);

        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab2);

        tabLayout.getTabAt(3).setCustomView(R.layout.custom_tab3);

        BottomSheetUtils.setupViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}