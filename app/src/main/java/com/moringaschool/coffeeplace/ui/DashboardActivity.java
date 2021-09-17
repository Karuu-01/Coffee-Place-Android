package com.moringaschool.coffeeplace.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;
import com.moringaschool.coffeeplace.adapters.KenyaSightingsListAdapter;
import com.moringaschool.coffeeplace.adapters.TouristFacilitiesListAdapter;
import com.moringaschool.coffeeplace.models.TravelAttractionResponse;
import com.moringaschool.coffeeplace.models.TravelGeoSightingResponse;
import com.moringaschool.coffeeplace.network.TravelClientApi;
import com.moringaschool.coffeeplace.network.TravelSearchApi;
import com.moringaschool.coffeeplace.BuildConfig;
import com.moringaschool.coffeeplace.R;



import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    DrawerLayout drawerLayout;
    NavigationView navMenu;
    Toolbar toolbar;
    RecyclerView sightingsRecyclerView;
    private KenyaSightingsListAdapter mSightingsListAdapter;
    private TouristFacilitiesListAdapter mTouristFacilitiesListAdapter;
    public List<TravelGeoSightingResponse> travelGeoSightingResponses;
    public List<TravelAttractionResponse> travelAttractionResponses;
    TravelSearchApi travelSearchApi = TravelClientApi.getClient();
    TextView tourist_facilities;
    @BindView(R.id.sports) TextView mSports;
    @BindView(R.id.nature) TextView mNature;
    @BindView(R.id.amusements) TextView mAmusements;
    @BindView(R.id.accomodation) TextView mAccomodation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navMenu = findViewById(R.id.navMenu);
        toolbar = findViewById(R.id.toolbar);
        sightingsRecyclerView = findViewById(R.id.sightings);
        tourist_facilities = findViewById(R.id.tourist_facilities);





        getSightings();
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(DashboardActivity.this);
        sightingsRecyclerView.setLayoutManager(layoutManager);
        sightingsRecyclerView.setHasFixedSize(true);
        mSightingsListAdapter = new KenyaSightingsListAdapter(DashboardActivity.this, travelGeoSightingResponses);
        sightingsRecyclerView.setAdapter(mSightingsListAdapter);
    }

    public void getSightings(){
        Call<TravelGeoSightingResponse> call = travelSearchApi.getHotels(BuildConfig.KEY);

        call.enqueue(new Callback<TravelGeoSightingResponse>() {
            @Override
            public void onResponse(Call<TravelGeoSightingResponse> call, Response<TravelGeoSightingResponse> response) {
                if(response.isSuccessful()){
                    travelGeoSightingResponses.addAll(response.body().getTravelGeoSightingResponseList());
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(DashboardActivity.this);
                    sightingsRecyclerView.setLayoutManager(layoutManager);
                    sightingsRecyclerView.setHasFixedSize(true);
                    mSightingsListAdapter = new KenyaSightingsListAdapter(DashboardActivity.this, travelGeoSightingResponses);
                    sightingsRecyclerView.setAdapter(mSightingsListAdapter);
                }
            }

            @Override
            public void onFailure(Call<TravelGeoSightingResponse> call, Throwable t) {

            }
        });
    }

    public void getTouristFacilities(){
        Call<TravelAttractionResponse> call = travelSearchApi.getTourist();

        call.enqueue(new Callback<TravelAttractionResponse>() {
            @Override
            public void onResponse(Call<TravelAttractionResponse> call, Response<TravelAttractionResponse> response) {
                if(response.isSuccessful()){
                    travelAttractionResponses.addAll(response.body().getTravelAttractionResponseList());
                    mTouristFacilitiesListAdapter = new TouristFacilitiesListAdapter(DashboardActivity.this, travelAttractionResponses);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(DashboardActivity.this);
                    sightingsRecyclerView.setLayoutManager(layoutManager);
                    sightingsRecyclerView.setHasFixedSize(true);
                    sightingsRecyclerView.setAdapter(mTouristFacilitiesListAdapter);
                }
            }

            @Override
            public void onFailure(Call<TravelAttractionResponse> call, Throwable t) {
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    public void onClick(View view) {
        String touristFacilities = "<font color=#F3A333>Tourist Facilities</font>";
        tourist_facilities.setText(Html.fromHtml(touristFacilities));
        tourist_facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTouristFacilities();
            }
        });

        String sports = "<font color=#F3A333>Sports</font>";
        mSports.setText(Html.fromHtml(sports));

        String nature = "<font color=#F3A333>Nature</font>";
        mNature.setText(Html.fromHtml(nature));

        String amusements = "<font color=#F3A333>Amusements</font>";
        mAmusements.setText(Html.fromHtml(amusements));

        String accomodation = "<font color=#F3A333>Accomodation</font>";
        mAccomodation.setText(Html.fromHtml(accomodation));

    }
}