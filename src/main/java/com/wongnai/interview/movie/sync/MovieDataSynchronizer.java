package com.wongnai.interview.movie.sync;

import javax.transaction.Transactional;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieData;
import com.wongnai.interview.movie.external.MovieDataServiceImpl;
import com.wongnai.interview.movie.external.MoviesResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.external.MovieDataService;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieDataSynchronizer {
	private static final Logger logger = LogManager.getLogger(MovieDataSynchronizer.class);

	@Autowired
	private MovieDataService movieDataService;

	@Autowired
	private MovieRepository movieRepository;

	private static List<Movie> movieList = new ArrayList<>();

	@Transactional
	public void forceSync() {
		//TODO: implement this to sync movie into repository

		logger.info("---------------------------- [Initial Data] ----------------------------");
		MoviesResponse moviesResponse = movieDataService.fetchAll();
		this.getMovieList().clear();

		for (MovieData movieData : moviesResponse) {
			Movie movie = new Movie(movieData.getTitle());
			movie.setActors(movieData.getCast());

			Movie movieSave = movieRepository.save(movie);
			this.getMovieList().add(movieSave);
		}
	}

	public List<Movie> getMovieList(){
		return this.movieList;
	}

	public void setMovieList(List<Movie> movieList){
		this.movieList = movieList;
	}
}
