package com.moringaschool.coffeeplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindPlacesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindPlacesButton = (Button) findViewById(R.id.FindPlacesButton);
        mFindPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //added a toast
                Toast.makeText(MainActivity.this, "Travel Is My Therapy", Toast.LENGTH_LONG).show();
            }
        });
    }
}