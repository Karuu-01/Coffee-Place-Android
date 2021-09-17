package com.moringaschool.coffeeplace.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;
import com.moringaschool.coffeeplace.ui.GalleryDetailFragment;

import java.util.List;

public class GalleryPagerAdapter extends FragmentPagerAdapter {
    private List<TravelGeoSightingResponse> mHotels;

    public GalleryPagerAdapter(@NonNull FragmentManager fm, int behavior, List<TravelGeoSightingResponse> hotels) {
        super(fm, behavior);
        mHotels = hotels;
    }

    @Override
    public Fragment getItem(int position) {
        return GalleryDetailFragment.newInstance(mHotels.get(position));
    }

    @Override
    public int getCount() {
        return mHotels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mHotels.get(position).getName();
    }
}
