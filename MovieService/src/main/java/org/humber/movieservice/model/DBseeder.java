package org.humber.movieservice.model;

import lombok.AllArgsConstructor;
import org.humber.movieservice.Repos.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class DBseeder implements CommandLineRunner {

    private final MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DB Seeded");
        List<Movie> movieList = List.of(
                Movie.builder().id(1).name("The Godfather").rating("5").build(),
                Movie.builder().id(2).name("The Dark Knight").rating("5").build(),
                Movie.builder().id(3).name("The Shawshank Redemption").rating("5").build()
        );
        movieRepository.saveAll(movieList);

  movieRepository.findAll().forEach((movie -> System.out.println(movie.getId() + " " + movie.getName() + " " + movie.getRating())));
    }

}
