package com.sai.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sai.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie,Integer>{
    Optional<Movie> findByTitle(String title);
}
