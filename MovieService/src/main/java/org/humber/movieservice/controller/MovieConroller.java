package org.humber.movieservice.controller;

import lombok.AllArgsConstructor;
import org.humber.movieservice.model.Movie;
import org.humber.movieservice.model.DBseeder;
import org.humber.movieservice.Repos.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
public class MovieConroller {

    private final MovieRepository movieRepository;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(){
        System.out.println("This is Movie Controller ");
        return ResponseEntity.ok(movieRepository.findAll());
    }
}
