package com.example.movieservice.Movies.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    @GetMapping("/all_movies")
    public ResponseEntity allMovies(){

        return ResponseEntity.ok("ALLL MOVIES");
    }
}
