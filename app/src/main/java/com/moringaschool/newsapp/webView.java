package com.moringaschool.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.newsapp.models.ArticleNews;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class webView extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    WebView webView;
    @BindView(R.id.webButton)
    Button mWebButton;
    ArrayList<ArticleNews> articleNewsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        mWebButton.setOnClickListener(this);

        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webview);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public void onClick(View view) {
        if (view == mWebButton) {
            DatabaseReference newsRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_NEWS);
            newsRef.push().setValue(articleNewsArrayList);
//            Toast.makeText(webView.this, "Saved", Toast.LENGTH_SHORT).show();
        }

    }
}