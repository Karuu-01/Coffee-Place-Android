package com.moringaschool.coffeeplace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.adapters.GalleryPagerAdapter;
import com.moringaschool.coffeeplace.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private GalleryPagerAdapter adapterViewPager;
    List<Business> mHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        ButterKnife.bind(this);

        mHotels = Parcels.unwrap(getIntent().getParcelableExtra("hotels"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new GalleryPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mHotels);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}