package com.applications.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Field;

import biz.laenger.android.vpbs.BottomSheetUtils;

public class MainActivity extends AppCompatActivity {


    private String[] tabTitles = new String[]{"Highlights", "Science", "Gaming", "Movies"};
    private int[] imageResId = {R.drawable.highlights, R.drawable.science, R.drawable.gaming, R.drawable.movies};

    CoordinatorLayout coordinatorLayout;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_layout);

        Intent intent = getIntent();
        int i = intent.getIntExtra("tabNo", 0);

        tabLayout = findViewById(R.id.tabLayout);
        coordinatorLayout = findViewById(R.id.cLayout);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tab);

        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab1);

        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab2);

        tabLayout.getTabAt(3).setCustomView(R.layout.custom_tab3);

        viewPager.setCurrentItem(i);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


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

    public void goBack()    {
        YoYo.with(Techniques.SlideOutDown)
                .duration(500)
                .repeat(0)
                .playOn(coordinatorLayout);
    }
}