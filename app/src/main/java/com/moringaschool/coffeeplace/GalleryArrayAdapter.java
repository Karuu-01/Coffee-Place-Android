package com.moringaschool.coffeeplace;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class GalleryArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mLocation;
    private String[] mPlace;

    public GalleryArrayAdapter(Context mContext, int resource, String[] mLocation, String[] mPlace) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mLocation = mLocation;
        this.mPlace = mPlace;
    }

    @Override
    public Object getItem(int position) {
        String location = mLocation[position];
        String places = mPlace[position];
        return String.format("%s \nServes great: %s", location, places);
    }

    @Override
    public int getCount() {
        return mLocation.length;
    }
}
