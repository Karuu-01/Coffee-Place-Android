package com.moringaschool.newsapp.adapters;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class FirebaseNewsViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseNewsViewholder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
