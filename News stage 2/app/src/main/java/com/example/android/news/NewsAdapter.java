package com.example.android.news;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shrikantm on 01/05/2018.
 */


public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News news = getItem(position);

        TextView newsTitles = (TextView) listItemView.findViewById(R.id.title);
        newsTitles.setText(news.getNewsTitle());

        TextView newsDate = (TextView) listItemView.findViewById(R.id.date);
        newsDate.setText(news.getDate());

        TextView newsAuthor = (TextView) listItemView.findViewById(R.id.author);
        newsAuthor.setText(news.getAuthor());

        TextView newsSection = (TextView) listItemView.findViewById(R.id.section);
        newsSection.setText(news.getSection());

        return listItemView;
    }
}

