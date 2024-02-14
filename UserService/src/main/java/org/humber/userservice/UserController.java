package org.humber.userservice;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final MovieClient movieClient;

    @GetMapping("/user-movies")
    ResponseEntity<String> getMovies() {
        return ResponseEntity.ok(movieClient.getMovies().toString());

    }
}
