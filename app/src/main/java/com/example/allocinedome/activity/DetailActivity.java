package com.example.allocinedome.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allocinedome.R;
import com.example.allocinedome.adapter.MyAdapter;
import com.example.allocinedome.model.Cinema;
import com.example.allocinedome.model.MovieListener;
import com.example.allocinedome.model.MovieShowtimes;
import com.example.allocinedome.rest.ApiHelper;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
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
    private MovieShowtimes movies;
    TextView description;
    ShareActionProvider shareAction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ImageView trailerImage = findViewById(R.id.trailerImage);
        movies = (MovieShowtimes)this.getIntent().getSerializableExtra("movie");
        Picasso.get().load(movies.onShow.movie.poster.href).into(trailerImage);
        description = findViewById(R.id.description);
        description.setText("Descrition :\n"
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque tincidunt sem a finibus. Fusce at ligula elit. Quisque vel volutpat sapien.");
        Objects.requireNonNull(getSupportActionBar()).setTitle(movies.onShow.movie.title);
    }

    public void launch(View v){
        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movies.onShow.movie.trailer.href));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem action_share = menu.findItem(R.id.action_share);
        ActionProvider actionProvider = MenuItemCompat.getActionProvider(action_share);
        shareAction = (ShareActionProvider) actionProvider;

        String shareMessage = "Coucou ! Regarde ce film :\"" + movies.onShow.movie.title + "\".";
        if(movies.onShow.movie.trailer !=null && movies.onShow.movie.trailer.href != null)
            shareMessage = shareMessage + " Regarde le trailer ici: "+ movies.onShow.movie.trailer.href;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Regarde ce film !");
        intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        setShareIntent(intent);
        return true;
    }

    private void setShareIntent(Intent shareIntent){
        if(shareAction!=null){
            shareAction.setShareIntent(shareIntent);
        }
    }
}
