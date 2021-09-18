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

import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.adapters.Adapter;
import com.moringaschool.newsapp.models.ArticleNews;
import com.moringaschool.newsapp.models.MainNews;
import com.moringaschool.newsapp.network.NewsClientApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {


    String api = "e4ec187190a44ade83b0e610b5e9aa95";
    ArrayList<ArticleNews> articleNewsArrayList;
    Adapter adapter;
    String country = "us";
    private RecyclerView recyclerViewTechnology;
    private String category = "Technology";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_fragment, null);

        recyclerViewTechnology = view.findViewById(R.id.recyclerViewTechnology);
        articleNewsArrayList = new ArrayList<>();
        recyclerViewTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), articleNewsArrayList);
        recyclerViewTechnology.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        NewsClientApi.getNewsSearchApi().getCategoryNews(country, category, 100, api)
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
