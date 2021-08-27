package com.movie.api.auth;

import com.movie.api.exceptions.BadRequestException;
import com.movie.api.exceptions.UnauthorizedException;

public class TokenAuth {

    public static void validateToken(String authToken) {
        if (authToken.isBlank() || !authToken.toLowerCase().contains("bearer")) {
            throw new BadRequestException("'Bearer' keyword not provided.");
        } else if (authToken.split("\\s+").length != 2) {
            throw new BadRequestException("Bearer token format is incorrect");
        } else if (!compareTokens(authToken)) {
            throw new UnauthorizedException("Token is incorrect");
        }
    }

    private static Boolean compareTokens(String authToken) {
        String systemToken = System.getenv("API_KEY");
        return systemToken.equals(authToken.split("\\s+")[1]);
    }

}

