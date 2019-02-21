package com.example.allocinedome.adapter;

import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.allocinedome.R;
import com.example.allocinedome.model.Cinema;
import com.example.allocinedome.model.DisplayMovie;
import com.example.allocinedome.model.MovieShowtimes;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<MovieShowtimes> movies;
    private OnMovieClickedListener listener;

    public MyAdapter(List<MovieShowtimes> myMovies, OnMovieClickedListener onMovieClickedListener) {
        this.movies = myMovies;
        this.listener = onMovieClickedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieShowtimes mMovie = movies.get(position);
        holder.textViewItemMovie.setText(mMovie.onShow.movie.title);
        holder.itemView.setOnClickListener(v -> listener.onMovieClicked(mMovie));
    }

    public int getItemCount() {
        int count = 0;
        for (MovieShowtimes m: movies
        ) {
            count += 1;
        }
        return count;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemMovie;

        MyViewHolder(View view) {
            super(view);
            textViewItemMovie = view.findViewById(R.id.text_item_movie);
        }
    }

    public interface OnMovieClickedListener {
        void onMovieClicked(MovieShowtimes movie);
    }
}
