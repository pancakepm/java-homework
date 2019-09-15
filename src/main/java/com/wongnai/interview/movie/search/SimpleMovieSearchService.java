package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wongnai.interview.movie.external.MovieData;
import com.wongnai.interview.movie.external.MovieDataServiceImpl;
import com.wongnai.interview.movie.external.MoviesResponse;
import com.wongnai.interview.movie.util.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {
	private static final Logger logger = LogManager.getLogger(SimpleMovieSearchService.class);

	@Autowired
	private MovieDataService movieDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class

		List<Movie> movieList = new ArrayList<>();
		MoviesResponse moviesResponse = movieDataService.fetchAll();

		if(util.checkOneWord(queryText)) {// check one word
			for (MovieData movieData : moviesResponse) {
				String title = movieData.getTitle();
				List<String> cast = movieData.getCast();

				if (util.getDataLowerCaseNotSpace(title).indexOf(util.getDataLowerCaseNotSpace(queryText)) != -1) {
					Movie movie = new Movie(title);
					movie.setActors(cast);

					movieList.add(movie);
				}
			}
		}

		return movieList;
	}

}
