package com.example.movieservice.Movies.Service;

import com.example.movieservice.Movies.Excepions.BadRequestException;
import com.example.movieservice.Movies.Model.Movie;
import com.example.movieservice.Movies.Repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImp implements MovieServiceInterface {
    private  final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void AddMovie(Movie movie) {
        Boolean isMoviePresent = movieRepository.findByName(movie.name).isPresent();
        if(isMoviePresent){
            throw new BadRequestException("Movie "+movie.name+" already exists");
        }else{
            movieRepository.save(movie);
        }

    }

    @Override
    public void UpdateMovie(Movie movie) {

    }

    @Override
    public void DeleteMovie(int id) {
        Boolean isMoviePresent = movieRepository.findById(id).isPresent();
        if(!isMoviePresent){
            throw new NullPointerException("Movie by this id doesnt exist");
        }
        else{
            Movie movie = movieRepository.findById(id).get();
            movieRepository.delete(movie);
        }

    }

    @Override
    public String getMovieByName(String name) {
        return null;
    }
}
