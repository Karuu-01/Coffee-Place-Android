package com.moringaschool.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
import com.moringaschool.newsapp.ui.NewsDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseNewsViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;
    TextView mheading, mcontent, mauthor, mtime;
    CardView cardView;
    ImageView imageView;

    public FirebaseNewsViewholder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindNews(ArticleNews news) {
        mheading = itemView.findViewById(R.id.headingmain);
        mcontent = itemView.findViewById(R.id.content);
        mauthor = itemView.findViewById(R.id.author);
        mtime = itemView.findViewById(R.id.time);
        imageView = itemView.findViewById(R.id.imageview);
        cardView = itemView.findViewById(R.id.cardview);

    }

    @Override
    public void onClick(View view) {
        final ArrayList<ArticleNews> news = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_NEWS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    news.add(snapshot.getValue(ArticleNews.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, NewsDetailActivity.class);
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
