package com.example.myapplication;

public class Movie {
    private final String title;
    private final Integer year;
    private final String genre;
    private final String posterResource;

    public Movie(String title, Integer year, String genre, String posterResource) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be null or empty");
        }
        this.title = title;
        this.year = year;
        this.genre = (genre == null || genre.isEmpty()) ? "Unknown Genre" : genre;
        this.posterResource = (posterResource == null || posterResource.isEmpty())
                ? "placeholder"
                : posterResource;
    }

    // Getters
    public String getTitle() { return title; }
    public Integer getYear() { return year; }
    public String getGenre() { return genre; }
    public String getPosterResource() { return posterResource; }
}