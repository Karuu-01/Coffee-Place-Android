package com.moringaschool.coffeeplace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.coffeeplace.R;
import com.moringaschool.coffeeplace.adapters.GalleryListAdapter;
import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;
import com.moringaschool.coffeeplace.network.TravelClientApi;
import com.moringaschool.coffeeplace.network.TravelSearchApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryListActivity extends AppCompatActivity {
    private static final String TAG = GalleryListActivity.class.getSimpleName();
    private GalleryListAdapter mAdapter;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    public List<TravelGeoSightingResponse> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String gallery = intent.getStringExtra("gallery");

        //Making the request
        TravelSearchApi client = TravelClientApi.getClient();
        Call<TravelGeoSightingResponse> call = client.getHotels(gallery);

        call.enqueue(new Callback<TravelGeoSightingResponse>() {
            @Override
            public void onResponse(Call<TravelGeoSightingResponse> call, Response<TravelGeoSightingResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    hotels = response.body().getTravelGeoSightingResponseList();
                    mAdapter = new GalleryListAdapter(GalleryListActivity.this, hotels);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(GalleryListActivity.this, 2);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showGallery();
                }else {
                    showUnsuccessfulMessage();
                }
            }
            @Override
            public void onFailure(Call<TravelGeoSightingResponse> call, Throwable t) {
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
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}