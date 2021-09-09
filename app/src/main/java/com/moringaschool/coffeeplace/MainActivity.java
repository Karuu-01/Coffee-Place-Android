package com.moringaschool.coffeeplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.FindPlacesButton) Button mFindPlacesButton;
    @BindView(R.id.galleryEditText) EditText mGalleryEditText;
    @BindView(R.id.tembeaKenyaTextView) TextView mTembeaKenyaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindPlacesButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
        if(v == mFindPlacesButton) {
                //added a toast
                Toast.makeText(MainActivity.this, "Travel Is My Therapy", Toast.LENGTH_LONG).show();
                //added a editText to take input from the button
                String gallery = mGalleryEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                intent.putExtra("gallery", gallery);
                startActivity(intent);
        }
    }
}