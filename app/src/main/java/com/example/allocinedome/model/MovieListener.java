package com.example.allocinedome.model;

import android.content.Context;
import android.content.Intent;

import com.example.allocinedome.activity.DetailActivity;
import com.example.allocinedome.adapter.MyAdapter;

public class MovieListener implements MyAdapter.OnMovieClickedListener {
    private Context context;

    public MovieListener(Context context) {
        this.context = context;
    }

    @Override
    public void onMovieClicked(MovieShowtimes movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("movie", movie);
        context.startActivity(intent);
    }
}
