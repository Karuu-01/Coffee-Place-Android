package com.moringaschool.newsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.adapters.Adapter;
import com.moringaschool.newsapp.models.ArticleNews;
import com.moringaschool.newsapp.models.MainNews;
import com.moringaschool.newsapp.network.NewsClientApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    String api = "e4ec187190a44ade83b0e610b5e9aa95";
    ArrayList<ArticleNews> articleNewsArrayList;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerViewHome;
    private String category = "business";
    DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, null);

        recyclerViewHome = view.findViewById(R.id.recyclerViewHome);
        articleNewsArrayList = new ArrayList<>();
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), articleNewsArrayList);
        recyclerViewHome.setAdapter(adapter);
        databaseReference = FirebaseDatabase
                .getInstance()
                .getReference("News");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ArticleNews articleNews = dataSnapshot.getValue(ArticleNews.class);
                    articleNewsArrayList.add(articleNews);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        findNews();

        return view;
    }


    private void findNews() {
        NewsClientApi.getNewsSearchApi().getCategoryNews(country,category ,100, api)
                .enqueue(new Callback<MainNews>() {
                    @Override
                    public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                        if (response.isSuccessful()){
                            articleNewsArrayList.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<MainNews> call, Throwable t) {

                    }
                });
    }
}
