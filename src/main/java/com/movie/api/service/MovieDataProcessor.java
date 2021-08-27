package com.movie.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.movie.api.exceptions.InternalServerError;
import com.movie.api.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MovieDataProcessor {
    private Logger logger = LoggerFactory.getLogger(MovieDataProcessor.class);

    @Autowired
    private MovieDataRequester movieDataRequester;

    private JsonNode movieData;

    public JsonNode getMovieData(String movieTitle) {
        String url = System.getenv("XML_API_URI") + "&t=" + movieTitle;
        String data = movieDataRequester.run(url);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            movieData = xmlMapper.readTree(data.getBytes()).get("movie");
        } catch (IOException e) {
            logger.error(e.toString());
            throw new InternalServerError("Error while processing data. Please try again later.");
        }
        if (movieData == null) {
            throw new NotFoundException("Movie: '%s' not found.".formatted(movieTitle));
        }
        return movieData;
    }
}
