package com.example.movieservice.Movies.Service;

import com.example.movieservice.Movies.Excepions.BadRequestException;
import com.example.movieservice.Movies.Model.Movie;
import com.example.movieservice.Movies.Repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class MovieServiceImpTest {


    private MovieServiceImp undertest;


    @Mock
    private MovieRepository movieRepositorytest;


    @BeforeEach
    void setup(){
        undertest = new MovieServiceImp(movieRepositorytest);
    }





    @Test
    void canaddMovie() {
        //given

        String name = "Black Panther";
        Movie movie = new Movie();
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;
        movieRepositorytest.save(movie);

        //when
        undertest.AddMovie(movie);

        //then
        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);

        verify(movieRepositorytest,atLeastOnce()).save(movieArgumentCaptor.capture());

       Movie capturedMovie =  movieArgumentCaptor.getValue();

       assertThat(capturedMovie).isEqualTo(movie);


    }
    @Test
    void willThrowErrorWhenNameIsTaken(){
        //given
        String name = "Black Panther";
        Movie movie = new Movie();
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;



    given(movieRepositorytest.findByName(movie.name)).willReturn(Optional.of(movie));

        //when
        //then
        assertThatThrownBy(()->undertest.AddMovie(movie))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Movie "+movie.name+" already exists");





    }

    @Test
    void updateMovie() {
        //given
        int id = 20;
        //given
        String name = "Black Panther";
        Movie movie = new Movie();
        movie.id = 20;
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;
        given(movieRepositorytest.findById(id)).willReturn(Optional.of(movie));

        //when
        undertest.UpdateMovie(movie);

        verify(movieRepositorytest,atLeastOnce()).save(movie);



    }



    @Test
    void canDeleteMovie() {
        //given
        int id = 20;
        //given
        String name = "Black Panther";
        Movie movie = new Movie();
        movie.id = 20;
        movie.name = name;
        movie.genre ="action";
        movie.releasedOn = new Date();
        movie.rating = 9;
        given(movieRepositorytest.findById(id)).willReturn(Optional.of(movie));

        //when
        undertest.DeleteMovie(id);




       verify(movieRepositorytest,atLeastOnce()).delete(movie);






    }

    @Test
    void cantDeleteMovie(){
        //given
        int id = 20;
        given(movieRepositorytest.findById(id)).willReturn(Optional.ofNullable(any()));


        //when
        //then
        assertThatThrownBy(()->undertest.DeleteMovie(id))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Movie by this id doesnt exist");

        verify(movieRepositorytest,never()).delete(any());

    }
}