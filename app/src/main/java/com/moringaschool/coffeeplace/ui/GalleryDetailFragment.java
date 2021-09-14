package com.moringaschool.coffeeplace.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.models.Business;
import com.moringaschool.coffeeplace.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryDetailFragment extends Fragment {
    @BindView(R.id.hotelImageView)
    ImageView mImageLabel;
    @BindView(R.id.hotelNameTextView)
    TextView mNameLabel;
    @BindView(R.id.categoryTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveHotelButton) TextView mSaveHotelButton;

    private Business mHotel;

    public GalleryDetailFragment() {
        // Required empty public constructor
    }

    public static GalleryDetailFragment newInstance(Business hotel) {
        GalleryDetailFragment galleryDetailFragment = new GalleryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("hotels", Parcels.wrap(hotel));
        galleryDetailFragment.setArguments(args);
        return galleryDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mHotel = Parcels.unwrap(getArguments().getParcelable("hotels"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mHotel.getImageUrl()).into(mImageLabel);

        List<String> categories = new ArrayList<>();

        for (Category category: mHotel.getCategories()) {
            categories.add(category.getTitle());
        }
        mNameLabel.setText(mHotel.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(",", categories));
        mRatingLabel.setText(Double.toString(mHotel.getRating()) + "/5");
        mPhoneLabel.setText(mHotel.getPhone());
        mAddressLabel.setText(mHotel.getLocation().toString());

        return view;
    }
}