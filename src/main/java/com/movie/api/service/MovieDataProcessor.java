package com.movie.api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.movie.api.exceptions.InternalServerError;
import com.movie.api.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MovieDataProcessor {
    static Logger logger = LoggerFactory.getLogger(MovieDataProcessor.class);

    public static JsonNode getMovieData(String movieTitle) {
        String url = System.getenv("XML_API_URI") + "&t=" + movieTitle;
        String data = MovieDataRequester.run(url);
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode movieData = null;
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
