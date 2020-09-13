package com.applications.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.applications.myapplication.fragments.GamingFrag;
import com.applications.myapplication.fragments.HighlightsFrag;
import com.applications.myapplication.fragments.MoviesFrag;
import com.applications.myapplication.fragments.ScienceFrag;

public class PagerAdapter extends FragmentPagerAdapter {

    public int noOfTabs;

    private String[] tabTitles = new String[] { "Highlights", "Science", "Gaming", "Movies" };
    private int[] imageResId = { R.drawable.highlights, R.drawable.science, R.drawable.gaming, R.drawable.movies };

    public PagerAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)   {
            case 0:
                return new HighlightsFrag();
            case 1:
                return new ScienceFrag();
            case 2:
                return new GamingFrag();
            case 3:
                return new MoviesFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }


}
