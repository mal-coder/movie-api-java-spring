package com.movie.api.service;

import com.movie.api.exceptions.InternalServerError;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MovieDataRequester {
    private Logger logger = LoggerFactory.getLogger(MovieDataRequester.class);
    private OkHttpClient client = new OkHttpClient();

    public String run(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                logger.error(response + response.body().string());
                throw new InternalServerError("Error while processing data. Please try again later.");
            }
        } catch (IOException | NullPointerException e) {
            logger.error(e.toString());
            throw new InternalServerError("Error while processing data. Please try again later.");
        }
    }
}