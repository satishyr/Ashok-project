package com.sai.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sai.entities.Movie;
import com.sai.repositories.MovieRepository;

@RestController
public class MovieResource {
	
	@Autowired
	CacheManager cacheManager;
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/movie")
	@HystrixCommand(fallbackMethod="fetchMovieDetailsByName_Fallback")
	@CachePut("movie")
	public String fetchMovieDetailsByName(@RequestParam("name") String name) {
		Optional<Movie> movieOptional = movieRepository.findByTitle(name);
		if(movieOptional.isPresent()) {
			Movie movie = movieOptional.get();
			return movie.getTitle()+", "+movie.getDuration()+", "+movie.getReleaseDate();
		}else {
			return "Details not matched";
		}
	}
	
	@GetMapping("/all")
	public List<String> fetchMoviesDetail(){
		ArrayList<String> list = new ArrayList<>();
		movieRepository.findAll().forEach(t -> {
			list.add(t.getTitle()+", "+t.getDuration()+", "+t.getReleaseDate());
		});
		return list;
	}
	
	public String fetchMovieDetailsByName_Fallback(String name) {
		Cache movieCache = cacheManager.getCache("movie");
		ValueWrapper value = movieCache.get(name);
		return value != null ? value.get().toString() : "mymovie, 3:10, 22-10-3000";
	}

}
