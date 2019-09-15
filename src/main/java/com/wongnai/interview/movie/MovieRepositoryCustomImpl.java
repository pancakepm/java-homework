package com.wongnai.interview.movie;

import com.wongnai.interview.movie.search.DatabaseMovieSearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryCustomImpl implements MovieRepositoryCustom {
    private static final Logger logger = LogManager.getLogger(MovieRepositoryCustomImpl.class);

    @PersistenceContext
    EntityManager entityManager;

//    @Override
//    @Transactional
//    public List<Movie> findAll(){
//        String sql = "SELECT m FROM Movie m";
//        TypedQuery<Movie> query = entityManager.createQuery(sql, Movie.class);
//        List<Movie> movieList = new ArrayList<>();
//
//        if(query.getResultList().size() > 0){
//            movieList = query.getResultList();
//        }
//
//        return movieList;
//    }
//
//    @Override
//    @Transactional
//    public List<Movie> findByLowerNameContains(String keyword) {
//        String sql = "SELECT m FROM Movie m where lower(m.name) LIKE '%" + keyword + "%'";
//        Query<Movie> query = ((Session) entityManager.getDelegate()).createQuery(sql);
//
//        List<Movie> movieList = new ArrayList<>();
//
//        if(query.list().size() > 0){
//            movieList = query.list();
//        }
//
//        return movieList;
//    }

}
