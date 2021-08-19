Movie API Simple REST API allowing requesting information about movies (but not necessarily limited to that).

With default configuration the user makes his requests using the API's / endpoint with query parameter title={movie
title}. Requests is authenticated with Bearer token provided by the user in Authorization header. API queries for the
title in the OMDB (https://www.omdbapi.com/), converts the response answer from XML to JSON and returns it to the user.