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

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {
    @BindView(R.id.galleryTextView) TextView mGalleryTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] location = new String[] {"Turkey","Sweden", "France", "Portugal", "Germany", "USA", "Canada", "Spain", "China", "Italy", "Belgium", "Finland", "Lithuania", "Scotland", "Croatia" };
    private String[] places = new String[] {"Bamburi beach", "Villa Total", "Voyager", "Sneak pik", "Burudani place", "Alps", "Mt.Everest recreation place", "Kangaroo Villa", "Panda house", "Portugal villa", "Aladdin Castle", "Bahamas", "Yolo hotel", "Frenzy villa" ,"Puerto rico mansion"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        GalleryArrayAdapter adapter = new GalleryArrayAdapter(this, android.R.layout.simple_list_item_1, location, places);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
            String location = ((TextView)view).getText().toString();
            Log.v("Gallery Activity", "In the onItemClickListener");
            Toast.makeText(GalleryActivity.this, location, Toast.LENGTH_LONG).show();;
        }});

        Intent intent = getIntent();
        String gallery = intent.getStringExtra("gallery");
        mGalleryTextView.setText("Here are all the places near: " + gallery);
        Log.v("GalleryActivity", "In the Oncreate method!");

    }
}