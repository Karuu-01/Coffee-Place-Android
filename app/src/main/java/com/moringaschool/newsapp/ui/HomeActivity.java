package com.moringaschool.newsapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.newsapp.Constants;
import com.moringaschool.newsapp.R;
import com.spark.submitbutton.SubmitButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements  View.OnClickListener{
   private DatabaseReference mSearchedNewsReference;
   private ValueEventListener mSearchedNewsListener;

    @BindView(R.id.buttonStart)
    SubmitButton mButtonStart;
    @BindView(R.id.newsEditText)
    EditText mNewsEditText;
    @BindView(R.id.savedNewButton) Button mSavedNewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mfindNewsButton.setOnClickListener(this);
        mSavedNewButton.setOnClickListener(this);

        mSearchedNewsReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_NEWS);

       mSearchedNewsListener = mSearchedNewsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot newsSnapshot : dataSnapshot.getChildren()) {
                    String news = newsSnapshot.getValue().toString();
                    Log.d("News Updated", "news: " + news);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedNewsReference.removeEventListener(mSearchedNewsListener);
    }

    @Override
    public void onClick(View view) {
        if (view == mfindNewsButton) {
            String news = mNewsEditText.getText().toString();
            saveNewsToFirebase(news);
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.putExtra("news", news);
            startActivity(intent);
            finish();

//animation 2
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        if (view == mSavedNewButton) {
            Intent intent = new Intent(HomeActivity.this, SavedNewsActivity.class);
            startActivity(intent);
        }
    }

    public void saveNewsToFirebase(String news) {
        mSearchedNewsReference.push().setValue(news);
    }
}
