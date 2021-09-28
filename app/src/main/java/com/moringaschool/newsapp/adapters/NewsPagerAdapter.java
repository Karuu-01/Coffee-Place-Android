package com.moringaschool.newsapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.newsapp.models.ArticleNews;
import com.moringaschool.newsapp.ui.HomeFragment;
import com.moringaschool.newsapp.ui.NewsDetailActivity;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private List<ArticleNews> mNews;

    public NewsPagerAdapter(@NonNull FragmentManager fm, int behavior, List<ArticleNews> news) {
        super(fm, behavior);
        mNews = news;
    }


    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mNews.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNews.get(position).getTitle();
    }
}
