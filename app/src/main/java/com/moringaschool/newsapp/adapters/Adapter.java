package com.moringaschool.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moringaschool.newsapp.R;
import com.moringaschool.newsapp.models.ArticleNews;
import com.moringaschool.newsapp.webView;

import org.parceler.Parcels;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ArticleNews> articleNewsArrayList;

    public Adapter(Context context, ArrayList<ArticleNews> articleNewsArrayList) {
        this.context = context;
        this.articleNewsArrayList = articleNewsArrayList;
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, webView.class);
               intent.putExtra("url", articleNewsArrayList.get(position).getUrl());
               context.startActivity(intent);
           }
       });

        holder.mtime.setText("Published At:-"+articleNewsArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(articleNewsArrayList.get(position).getAuthor());
        holder.mheading.setText(articleNewsArrayList.get(position).getTitle());
        holder.mcontent.setText(articleNewsArrayList.get(position).getDescription());
        Glide.with(context).load(articleNewsArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articleNewsArrayList.size();
    }

       public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView mheading, mcontent, mauthor, mtime;
        CardView cardView;
        ImageView imageView;
        private Context mContext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
            mheading = itemView.findViewById(R.id.headingmain);
            mcontent = itemView.findViewById(R.id.content);
            mauthor = itemView.findViewById(R.id.author);
            mtime = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardview);

        }

           @Override
           public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DashActivity.class);
            intent.putExtra("position" , itemPosition);
            intent.putExtra("news", Parcels.wrap(articleNewsArrayList));
            mContext.startActivity(intent);

           }
       }

}
