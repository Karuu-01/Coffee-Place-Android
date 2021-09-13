package com.moringaschool.coffeeplace.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.coffeeplace.adapters.GalleryArrayAdapter;
import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.models.Business;
import com.moringaschool.coffeeplace.models.Category;
import com.moringaschool.coffeeplace.models.Coordinates;
import com.moringaschool.coffeeplace.models.TravelBusinessesSearchResponse;
import com.moringaschool.coffeeplace.network.TravelClientApi;
import com.moringaschool.coffeeplace.network.TravelSearchApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = GalleryActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.galleryTextView) TextView mGalleryTextView;
    @BindView(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
            String location = ((TextView)view).getText().toString();
            Toast.makeText(GalleryActivity.this, location, Toast.LENGTH_LONG).show();;
        }});

        Intent intent = getIntent();
        String gallery = intent.getStringExtra("gallery");
        mGalleryTextView.setText("Here are all the places near: " + gallery);

        //Making the request
        TravelSearchApi client = TravelClientApi.getClient();
        Call<TravelBusinessesSearchResponse> call = client.getHotels(gallery, "hotels");

        call.enqueue(new Callback<TravelBusinessesSearchResponse>() {
            @Override
            public void onResponse(Call<TravelBusinessesSearchResponse> call, Response<TravelBusinessesSearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Business> galleryList = response.body().getBusinesses();
                    String[] gallery = new String[galleryList.size()];
                    String[] categories = new String[galleryList.size()];

                    for (int i = 0; i < gallery.length; i++){
                        gallery[i] = galleryList.get(i).getName();
                    }

                    for (int i = 0; i < categories.length; i++){
                        Category category = galleryList.get(i).getCategories().get(0);
                        categories[i] = category.getTitle();
                    }
                    ArrayAdapter adapter = new GalleryArrayAdapter(GalleryActivity.this, android.R.layout.simple_list_item_1, gallery, categories);
                    mListView.setAdapter(adapter);

                    showGallery();
                }else {
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<TravelBusinessesSearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ", t);
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. PLease check your internet connection and try again");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showGallery() {
        mListView.setVisibility(View.VISIBLE);
        mGalleryTextView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}