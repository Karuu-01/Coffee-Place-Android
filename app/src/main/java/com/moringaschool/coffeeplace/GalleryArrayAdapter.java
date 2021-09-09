package com.moringaschool.coffeeplace;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class GalleryArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mLocations;
    private String[] mPlaces;

    public GalleryArrayAdapter(Context mContext, int resource, String[] mLocations, String[] mPlaces) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mLocations = mLocations;
        this.mPlaces = mPlaces;
    }

    @Override
    public Object getItem(int position) {
        String location = mLocations[position];
        String place = mPlaces[position];
        return String.format("%s \nServes great: %s", location, place);
    }

    @Override
    public int getCount() {
        return mLocations.length;
    }
}
