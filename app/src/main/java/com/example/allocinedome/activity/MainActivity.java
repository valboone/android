package com.example.allocinedome.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.example.allocinedome.R;
import com.example.allocinedome.model.Cinema;
import com.example.allocinedome.model.MovieListener;
import com.example.allocinedome.model.MovieShowtimes;
import com.example.allocinedome.rest.ApiHelper;
import com.example.allocinedome.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnMovieClickedListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String content;
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        
        ApiHelper.getInstance().getNewsApi().getFile().enqueue(new Callback<Cinema>() {
            @Override
            public void onResponse(Call<Cinema> call, Response<Cinema> response) {
                mLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
                mRecyclerView.setLayoutManager(mLayoutManager);

                mAdapter = new MyAdapter(response.body().movieShowtimes, new MovieListener(context));
                mRecyclerView.setAdapter(mAdapter);

                for (MovieShowtimes m: response.body().movieShowtimes
                     ) {
                    Log.d("MainActivity",m.onShow.movie.title.toString());
                }


            }

            @Override
            public void onFailure(Call<Cinema> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }


    @Override
    public void onMovieClicked(MovieShowtimes movie) {
        Log.d("MainActivity", "CLIC");
    }
}

