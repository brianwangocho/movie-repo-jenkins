package com.example.movieservice.Movies.Repository;

import com.example.movieservice.Movies.Model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository undertest;

    @AfterEach
    void tearDown(){
        undertest.deleteAll();
    }

    @Test
    void itShouldExistById() {
        ///given
        int id = 1;
        String name = "Black Panther";
        Movie movie = new Movie();
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;
        undertest.save(movie);
        //when
        boolean exists = undertest.findById(id).isPresent();
        //then
        assertThat(exists).isTrue();
    }
    @Test
    void ifNameDoesntExist(){
        //given
        String movie= "Dark Knight";

        // when
        boolean exists = undertest.findByName(movie).isPresent();

        //then
        assertThat(exists).isFalse();
    }


    @Test
    void itsShouldExistsByName() {
        //given
        String name = "Black Panther";
        Movie movie = new Movie();
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;

        undertest.save(movie);
        // when
        boolean exists = undertest.findByName(name).isPresent();
        //then
        assertThat(exists).isTrue();


    }
}