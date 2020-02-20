package com.sai.clients;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<String> fetchMovies() throws Exception{
		return (List<String>)restTemplate.getForObject(new URI("http://localhost:8989/all"),List.class);
	}

}
