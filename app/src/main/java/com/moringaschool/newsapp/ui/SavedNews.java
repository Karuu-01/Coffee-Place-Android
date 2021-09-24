package com.moringaschool.newsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.newsapp.Constants;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.adapters.Adapter;
import com.moringaschool.newsapp.adapters.FirebaseNewsViewHolder;
import com.moringaschool.newsapp.models.ArticleNews;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedNews extends AppCompatActivity {

private DatabaseReference mNewsref;
private FirebaseRecyclerAdapter<ArticleNews, FirebaseNewsViewHolder> mFirebaseAdapter;

@BindView(R.id.recyclerViewHome) RecyclerView mRecyclerViewHome;
@BindView(R.id.errorTextView) TextView mErrorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mNewsref = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_NEWS).child(uid);
        setUpFireBaseAdapter();
        showNews();
    }

    private void setUpFireBaseAdapter(){
    FirebaseRecyclerOptions<ArticleNews> options =
    new FirebaseRecyclerOptions.Builder<ArticleNews>()
    .setQuery(mNewsref, ArticleNews.class)
    .build();

    mFirebaseAdapter = new FirebaseRecyclerAdapter<ArticleNews, FirebaseNewsViewHolder>(options) {
        @Override
        protected void onBindViewHolder(@NonNull FirebaseNewsViewHolder holder, int position, @NonNull ArticleNews model) {
            holder.bindNews(model);

        }

        @NonNull
        @Override
        public FirebaseNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
             return new FirebaseNewsViewHolder(view);
        }
    };
    mRecyclerViewHome.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerViewHome.setAdapter(mFirebaseAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showNews() {
        mRecyclerViewHome.setVisibility(View.VISIBLE);
    }


}