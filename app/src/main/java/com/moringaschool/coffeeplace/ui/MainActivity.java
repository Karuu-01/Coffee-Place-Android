package com.moringaschool.coffeeplace.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.coffeeplace.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.getStarted) Button mGetStartedButton;
    @BindView(R.id.dash) Button mDash;
    @BindView(R.id.galleryEditText)
    EditText mGalleryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mGetStartedButton.setOnClickListener(this);
        mDash.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == mGetStartedButton) {
            Toast.makeText(MainActivity.this, "Travel is MY Therapy", Toast.LENGTH_LONG).show();
            String gallery = mGalleryEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            intent.putExtra("gallery", gallery);
            startActivity(intent);
        }

        if (view == mDash) {
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }

    }
}