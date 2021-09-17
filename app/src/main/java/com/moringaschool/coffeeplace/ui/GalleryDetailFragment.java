package com.moringaschool.coffeeplace.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.hotelImageView)
    ImageView mImageLabel;
    @BindView(R.id.hotelNameTextView)
    TextView mNameLabel;
    @BindView(R.id.hotelWelcomeTextView) TextView mHotelWelcomeTextView;
    @BindView(R.id.resortTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveHotelButton) TextView mSaveHotelButton;

    private TravelGeoSightingResponse mHotel;

    public GalleryDetailFragment() {
        // Required empty public constructor
    }

    public static GalleryDetailFragment newInstance(TravelGeoSightingResponse hotel) {
        GalleryDetailFragment galleryDetailFragment = new GalleryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("destination", Parcels.wrap(hotel));
        galleryDetailFragment.setArguments(args);
        return galleryDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mHotel = Parcels.unwrap(getArguments().getParcelable("destination"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_detail, container, false);
        ButterKnife.bind(this, view);
//        Picasso.get().load(mHotel.getExternalUrls().toString()).into(mImageLabel);

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        mImageLabel.setOnClickListener(this);

        List<String> acceptedPay = new ArrayList<>();

//        for (Medium medium: mHotel.getMedia()) {
//            acceptedPay.add(medium.getCategory());
//        }
        mNameLabel.setText(mHotel.getName());
//        mCategoriesLabel.setText(android.text.TextUtils.join(",", acceptedPay));
//        mRatingLabel.setText(Double.toString(mHotel.getStarRating()) + "/5");
//        mPhoneLabel.setText(mHotel.getPhoneNumbers().toString());
//        mAddressLabel.setText(mHotel.getAddress().toString());

        return view;
    }
    @Override
    public void onClick(View v) {
//        if (v == mWebsiteLabel) {
//            Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse(mHotel.getWebsiteUrl().toString()));
//            startActivity(webIntent);
//        }
//
//        if (v == mPhoneLabel) {
//            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
//                    Uri.parse("tel:" + mHotel.getPhoneNumbers()));
//            startActivity(phoneIntent);
//        }
//
//        if (v == mAddressLabel) {
//            Intent mapIntent = new Intent(Intent.ACTION_DIAL,
//                    Uri.parse("geo:" + mHotel.getLocation().getLatitude() + "," + mHotel.getLocation().getLongitude() + "?q=(" + mHotel.getName() + ")"));
//            startActivity(mapIntent);
//        }
//
//        if (v == mImageLabel) {
//            Intent imageIntent = new Intent(Intent.ACTION_VIEW,
//                    Uri.parse(mHotel.getImages().toString()));
//            startActivity(imageIntent);
//         }

    }

}