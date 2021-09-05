package com.moringaschool.coffeeplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {
    private TextView mGalleryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mGalleryTextView = (TextView) findViewById(R.id.galleryTextView);

        Intent intent = getIntent();
        String gallery = intent.getStringExtra("gallery");
        mGalleryTextView.setText("Here are all the places near: " + gallery);
    }
}