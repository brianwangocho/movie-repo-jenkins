package com.example.movieservice.Movies.Service;

import com.example.movieservice.Movies.Model.Movie;

public interface MovieServiceInterface {

    void AddMovie(Movie movie);

    void UpdateMovie(Movie movie);

    void DeleteMovie(int id);

    String  getMovieByName(String name);
}
