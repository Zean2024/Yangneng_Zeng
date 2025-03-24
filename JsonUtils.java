package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUtils {
    public static List<Movie> loadMoviesFromJson(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            // 1. 读取 JSON 文件
            InputStream is = context.getAssets().open("movie_data.json");
            String json = new Scanner(is).useDelimiter("\\A").next();
            JSONArray jsonArray = new JSONArray(json);

            // 2. 解析每个电影条目
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String title = obj.getString("title"); // 必填字段
                    Integer year = obj.has("year") ? obj.getInt("year") : null;
                    String genre = obj.optString("genre", null);
                    String poster = obj.optString("poster", null);
                    movies.add(new Movie(title, year, genre, poster));
                } catch (JSONException | IllegalArgumentException e) {
                    Log.e("JsonUtils", "Invalid movie data at index " + i, e);
                }
            }
        } catch (IOException e) {
            Log.e("JsonUtils", "JSON file not found", e);
            return null;
        } catch (JSONException e) {
            Log.e("JsonUtils", "Invalid JSON format", e);
            return null;
        }
        return movies;
    }
}
