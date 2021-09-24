package com.moringaschool.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.newsapp.Constants;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.models.ArticleNews;
import com.moringaschool.newsapp.ui.HomeFragment;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;

    public FirebaseNewsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindNews(ArticleNews news) {
        ImageView imageView = mView.findViewById(R.id.imageview);
        TextView contentView = mView.findViewById(R.id.content);
        TextView headingView = mView.findViewById(R.id.headingmain);
        TextView timeView = mView.findViewById(R.id.time);
        TextView authorView = mView.findViewById(R.id.author);
        CardView cardView = mView.findViewById(R.id.cardview);

        contentView.setText(news.getDescription());
        headingView.setText(news.getTitle());
        authorView.setText(news.getAuthor());
        timeView.setText(news.getPublishedAt());
        cardView.setOnClickListener(this);
        Glide.with(imageView).load(news.getUrlToImage());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<ArticleNews> news = new ArrayList<>();
        FirebaseUser user = FirebaseAuth
                .getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_NEWS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dateSnapshot) {
                for (DataSnapshot snapshot : dateSnapshot.getChildren()) {
                    news.add(snapshot.getValue(ArticleNews.class));
                }
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, HomeFragment.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("news", Parcels.wrap(news));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}
