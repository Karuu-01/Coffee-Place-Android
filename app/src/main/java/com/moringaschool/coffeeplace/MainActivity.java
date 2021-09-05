package com.moringaschool.coffeeplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindPlacesButton;
    private EditText mGalleryEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindPlacesButton = (Button) findViewById(R.id.FindPlacesButton);
        mGalleryEditView = (EditText) findViewById(R.id.galleryEditView);

        mFindPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //added a toast
                Toast.makeText(MainActivity.this, "Travel Is My Therapy", Toast.LENGTH_LONG).show();
                //added a editview to take input from the button
                String gallery = mGalleryEditView.getText().toString();
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                intent.putExtra("gallery", gallery);
                startActivity(intent);
                
            }
        });
    }
}