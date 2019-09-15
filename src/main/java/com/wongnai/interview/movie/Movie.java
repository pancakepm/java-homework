package com.wongnai.interview.movie;

import com.wongnai.interview.movie.external.MovieData;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@ToString
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "MOVIE_ACTORS", joinColumns = @JoinColumn(name = "MOVIE_ID"))

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="MOVIE_ACTORS",joinColumns=@JoinColumn(name="MOVIE_ID"))
	private List<String> actors = new ArrayList<>();

	/**
	 * Required by JPA.
	 */
	protected Movie() {
	}

	public Movie(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors){
		this.actors = actors;
	}
}
