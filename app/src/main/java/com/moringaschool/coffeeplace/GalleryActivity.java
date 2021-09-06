package com.moringaschool.coffeeplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private TextView mGalleryTextView;
    private ListView mListView;
    private String[] location = new String[] {"Europe", "Africa", "North America", "Asia", "South America", "Australia", "New Zealand", "Kenya", "Porto"};
    private String[] places = new String[] {"Bamburi beach", "Voyager", "Sneak pik", "Burudani place", "Alps", "Mt.Everest recreation place", "Kangaroo Villa", "Panda house"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mGalleryTextView = (TextView) findViewById(R.id.galleryTextView);
        mListView = (ListView) findViewById(R.id.listView);

        GalleryArrayAdapter adapter = new GalleryArrayAdapter(this, android.R.layout.simple_list_item_1, location, places);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
            String places = ((TextView)view).getText().toString();
            Toast.makeText(GalleryActivity.this, places, Toast.LENGTH_LONG).show();;
        }});

        Intent intent = getIntent();
        String gallery = intent.getStringExtra("gallery");
        mGalleryTextView.setText("Here are all the places near: " + gallery);
        Log.d("GalleryActivity", "In the Oncreate method!");

    }
}