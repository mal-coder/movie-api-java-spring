package com.movie.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication {

    public static void main(String[] args) throws Exception {
        // Validate required env variables existence
        try {
            if (System.getenv("API_KEY").isBlank()) {
                throw new Exception("'API_KEY' environmental variable not provided");
            }
        } catch (NullPointerException e) {
            throw new Exception("'API_KEY' environmental variable not provided");
        }

        try {
            if (System.getenv("XML_API_URI").isBlank()) {
                throw new Exception("'XML_API_URI' environmental variable not provided");
            }
        } catch (NullPointerException e) {
            throw new Exception("'XML_API_URI' environmental variable not provided");
        }

        SpringApplication.run(MovieApplication.class, args);
    }

}
