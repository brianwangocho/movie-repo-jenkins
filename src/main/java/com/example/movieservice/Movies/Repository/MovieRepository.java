package com.example.movieservice.Movies.Repository;

import com.example.movieservice.Movies.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Override
    Optional<Movie> findById(Integer integer);

    Optional<Movie> findByName(String name);
}
