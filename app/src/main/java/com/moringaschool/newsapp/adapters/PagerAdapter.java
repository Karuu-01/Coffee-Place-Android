package com.moringaschool.newsapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.newsapp.ui.EntertainmentFragment;
import com.moringaschool.newsapp.ui.HealthFragment;
import com.moringaschool.newsapp.ui.HomeFragment;
import com.moringaschool.newsapp.ui.ScienceFragment;
import com.moringaschool.newsapp.ui.SportsFragment;
import com.moringaschool.newsapp.ui.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            return new HomeFragment();

            case 1:
                return new SportsFragment();

            case 2:
                return new ScienceFragment();

            case 3:
                return new HealthFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
