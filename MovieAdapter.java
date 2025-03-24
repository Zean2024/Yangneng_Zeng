package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = (movies != null) ? movies : new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear() != null ? String.valueOf(movie.getYear()) : "Year Unknown");
        holder.genre.setText(movie.getGenre());

        // 加载海报图片
        String posterName = movie.getPosterResource();
        int resId = holder.itemView.getResources()
                .getIdentifier(posterName, "drawable", holder.itemView.getContext().getPackageName());
        holder.poster.setImageResource((resId != 0) ? resId : R.drawable.placeholder);
    }

    @Override
    public int getItemCount() { return movies.size(); }

    public void updateData(List<Movie> newMovies) {
        movies = (newMovies != null) ? newMovies : new ArrayList<>();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTextView);
            year = itemView.findViewById(R.id.yearTextView);
            genre = itemView.findViewById(R.id.genreTextView);
            poster = itemView.findViewById(R.id.posterImageView);
        }
    }
}