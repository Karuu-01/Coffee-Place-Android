package com.moringaschool.newsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.newsapp.Constants;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.adapters.FirebaseNewsViewholder;
import com.moringaschool.newsapp.models.ArticleNews;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedNewsActivity extends AppCompatActivity {

    private DatabaseReference mNewsReference;
    private FirebaseRecyclerAdapter<ArticleNews, FirebaseNewsViewholder> mFirebaseAdapter;


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mNewsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_NEWS).child(uid);
        setUpFirebaseAdapter();
        hideProgressBar();
        showNews();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<ArticleNews> options =
                new FirebaseRecyclerOptions.Builder<ArticleNews>()
                        .setQuery(mNewsReference, ArticleNews.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<ArticleNews, FirebaseNewsViewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseNewsViewholder holder, int position, @NonNull ArticleNews model) {
                holder.bindNews(model);
            }


            @NonNull
            @Override
            public FirebaseNewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
                return new FirebaseNewsViewholder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
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
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}