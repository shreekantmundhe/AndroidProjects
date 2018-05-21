package com.example.android.news;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by shrikantm on 08/05/2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Query URL */
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<News> news = Utils.fetchNewsData(mUrl);
        return news;
    }
}
