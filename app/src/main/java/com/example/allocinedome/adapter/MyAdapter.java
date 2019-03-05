package com.example.allocinedome.adapter;

import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.allocinedome.R;
import com.example.allocinedome.model.Cinema;
import com.example.allocinedome.model.DisplayMovie;
import com.example.allocinedome.model.MovieShowtimes;
import com.squareup.picasso.Picasso;

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
        String textMovie = "\n\n" + mMovie.onShow.movie.genre.get(0).name + "\n"
                + "Sortie le : " + mMovie.onShow.movie.release.releaseDate;
        holder.textViewItemMovie.setText(textMovie);
        holder.itemView.setOnClickListener(v -> listener.onMovieClicked(mMovie));
        Picasso.get().load(mMovie.onShow.movie.poster.href).into(holder.posterImage);
        holder.ratingBar.setIsIndicator(true);
        holder.ratingBar.setRating(mMovie.onShow.movie.statistics.pressRating);
        holder.ratingBarUser.setIsIndicator(true);
        holder.ratingBarUser.setRating(mMovie.onShow.movie.statistics.userRating);
        holder.pressRating.setText("Presse : ");
        holder.userRating.setText("Spectateurs : ");
        holder.title.setText(mMovie.onShow.movie.title);
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
        ImageView posterImage;
        RatingBar ratingBar;
        RatingBar ratingBarUser;
        TextView pressRating;
        TextView userRating;
        TextView title;

        MyViewHolder(View view) {
            super(view);
            textViewItemMovie = view.findViewById(R.id.text_item_movie);
            posterImage = view.findViewById(R.id.posterView);
            ratingBar = view.findViewById(R.id.ratingBar);
            ratingBarUser = view.findViewById(R.id.ratingBarUser);
            pressRating = view.findViewById(R.id.pressRating);
            userRating = view.findViewById(R.id.userRating);
            title = view.findViewById(R.id.title);
        }
    }

    public interface OnMovieClickedListener {
        void onMovieClicked(MovieShowtimes movie);
    }
}
