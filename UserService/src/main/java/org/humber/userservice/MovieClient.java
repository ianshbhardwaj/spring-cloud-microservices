package org.humber.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/movies")
    List<MovieDto> getMovies();
}
