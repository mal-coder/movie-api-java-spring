package com.movie.api.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.movie.api.auth.TokenAuth;
import com.movie.api.service.MovieDataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
    @Autowired
    private TokenAuth tokenAuth;

    @Autowired
    private MovieDataProcessor movieDataProcessor;

    @GetMapping("/")
    public JsonNode returnMovieData(@RequestParam("Title") String movieTitle,
                                    @RequestHeader("Authorization") String authToken) {

        tokenAuth.validateToken(authToken);

        return movieDataProcessor.getMovieData(movieTitle);
    }
}
