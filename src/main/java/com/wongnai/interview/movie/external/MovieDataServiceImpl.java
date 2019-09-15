package com.wongnai.interview.movie.external;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class MovieDataServiceImpl implements MovieDataService {
	private static final Logger logger = LogManager.getLogger(MovieDataServiceImpl.class);

	public static final String MOVIE_DATA_URL = "https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json";

	@Autowired
	private RestOperations restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public MoviesResponse fetchAll() {
		//TODO:
		// Step 1 => Implement this method to download data from MOVIE_DATA_URL and fix any error you may found.
		// Please noted that you must only read data remotely and only from given source,
		// do not download and use local file or put the file anywhere else.

		MoviesResponse moviesResponse = new MoviesResponse();
		String response = restTemplate.getForObject(MOVIE_DATA_URL , String.class);

		try {
			moviesResponse = objectMapper.readValue(response, MoviesResponse.class);
		} catch (IOException e) {
			logger.info("Response Json Object not Match");
		}

		return moviesResponse;
	}
}
