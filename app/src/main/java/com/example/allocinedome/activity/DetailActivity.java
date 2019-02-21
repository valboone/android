package com.example.allocinedome.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.allocinedome.R;
import com.example.allocinedome.adapter.MyAdapter;
import com.example.allocinedome.model.Cinema;
import com.example.allocinedome.model.MovieListener;
import com.example.allocinedome.model.MovieShowtimes;
import com.example.allocinedome.rest.ApiHelper;

import java.io.Serializable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        MovieShowtimes movies = (MovieShowtimes)this.getIntent().getSerializableExtra("movie");

    }
}
