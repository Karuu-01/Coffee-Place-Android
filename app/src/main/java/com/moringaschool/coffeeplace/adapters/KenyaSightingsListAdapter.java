package com.moringaschool.coffeeplace.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KenyaSightingsListAdapter extends RecyclerView.Adapter<KenyaSightingsListAdapter.SightingsViewHolder> {
    private Context mContext;
    private List<TravelGeoSightingResponse> mSightings;

    public KenyaSightingsListAdapter(Context mContext, List<TravelGeoSightingResponse> kenyaSightings) {
        this.mContext = mContext;
        this.mSightings = kenyaSightings;
    }

    public class SightingsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sightingImageView) ImageView mSightingImageView;
        @BindView(R.id.sightingNameTextView) TextView mSightingNameTextView;
        @BindView(R.id.kindTextView) TextView mKindTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public SightingsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindSighting(TravelGeoSightingResponse sighting) {
            mSightingNameTextView.setText(sighting.getName());
            mKindTextView.setText(sighting.getKinds());
            mRatingTextView.setText("Rating: " + sighting.getRate() + "/5");
        }
    }

    @NonNull
    @Override
    public KenyaSightingsListAdapter.SightingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sightings_list_item, parent, false);
        SightingsViewHolder viewHolder = new SightingsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KenyaSightingsListAdapter.SightingsViewHolder holder, int position) {
        holder.bindSighting(mSightings.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
