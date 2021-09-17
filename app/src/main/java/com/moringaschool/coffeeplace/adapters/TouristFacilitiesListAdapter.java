package com.moringaschool.coffeeplace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.coffeeplace.models.TravelAttractionResponse;
import com.moringaschool.coffeeplace.R;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouristFacilitiesListAdapter extends RecyclerView.Adapter<TouristFacilitiesListAdapter.TouristFacilitiesViewHolder>{
    private Context mContext;
    private List<TravelAttractionResponse> mTouristFacilities;

    public TouristFacilitiesListAdapter(Context mContext,List<TravelAttractionResponse> touristFacilities) {
        this.mContext = mContext;
        this.mTouristFacilities = touristFacilities;
    }

    public class TouristFacilitiesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sightingImageView) ImageView mTouristFacilitiesImageView;
        @BindView(R.id.sightingNameTextView) TextView mTouristFacilitiesNameTextView;
        @BindView(R.id.kindTextView) TextView mKindTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public TouristFacilitiesViewHolder (View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTouristFacility(TravelAttractionResponse touristFacilities) {
            mTouristFacilitiesNameTextView.setText(touristFacilities.getName());
            mKindTextView.setText(touristFacilities.getKinds());
            mRatingTextView.setText("Rating: " + touristFacilities.getRate() + "/5");
        }
    }

    @NonNull
    @Override
    public TouristFacilitiesListAdapter.TouristFacilitiesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sightings_list_item, parent, false);
        TouristFacilitiesListAdapter.TouristFacilitiesViewHolder viewHolder = new TouristFacilitiesListAdapter.TouristFacilitiesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TouristFacilitiesListAdapter.TouristFacilitiesViewHolder holder, int position) {
        holder.bindTouristFacility(mTouristFacilities.get(position));
    }

    @Override
    public int getItemCount() {
        return mTouristFacilities.size();
    }

}
