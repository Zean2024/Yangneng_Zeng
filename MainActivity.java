package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.movieRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        loadMovies();
    }

    private void loadMovies() {
        List<Movie> movies = JsonUtils.loadMoviesFromJson(this);
        if (movies == null) {
            Toast.makeText(this, "Failed to load movie data!", Toast.LENGTH_LONG).show();
        } else if (movies.isEmpty()) {
            Toast.makeText(this, "No movies found!", Toast.LENGTH_LONG).show();
        } else {
            adapter.updateData(movies);
        }
    }
}