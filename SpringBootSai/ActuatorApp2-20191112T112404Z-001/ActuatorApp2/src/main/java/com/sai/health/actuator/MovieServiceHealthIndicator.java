package com.sai.health.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.sai.clients.MovieClient;

@Component
public class MovieServiceHealthIndicator implements HealthIndicator {

	@Autowired
	MovieClient movieClient;
	
	@Override
	public Health health() {
		try {
		movieClient.fetchMovies();
		return Health.up().build();
		}catch(Exception ob) {
	    return Health.down().withDetail("Message",ob.getMessage()).build();
		}
	}

}
