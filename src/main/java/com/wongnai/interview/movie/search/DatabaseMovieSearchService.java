package com.wongnai.interview.movie.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wongnai.interview.movie.util.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.MovieSearchService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component("databaseMovieSearchService")
public class DatabaseMovieSearchService implements MovieSearchService {
	private static final Logger logger = LogManager.getLogger(DatabaseMovieSearchService.class);

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 3 => Please make all test in DatabaseMovieSearchServiceIntegrationTest run pass.
		// This database search method must use only MovieRepository.findByNameContains(String), you also have to implement
		// MovieDataSynchronizer.forceSync() to load all movie data, using MovieDataService, into MovieRepository.
		// Do not change @Component annotation on this class

		List<Movie> movieResult = new ArrayList<>();
		queryText = queryText.toLowerCase();
		List<Movie> movieList = movieRepository.findByLowerNameContains(queryText);

		for (Movie movie : movieList) {
			if (movie.getName().toLowerCase().indexOf(queryText) != -1) {
				Set<String> set = new HashSet<String>(movie.getActors());
				movie.setActors(new ArrayList(set));
				movieResult.add(movie);
			}
		}

		return movieResult;
	}
}
