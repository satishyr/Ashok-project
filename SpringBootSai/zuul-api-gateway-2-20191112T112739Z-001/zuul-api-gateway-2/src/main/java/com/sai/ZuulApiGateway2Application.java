package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sai.fallback.providers.MovieServiceFallbackProvider;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGateway2Application.class, args);
	}
	
	@Bean
	public MovieServiceFallbackProvider movieServiceFallbackProvider() {
		return new MovieServiceFallbackProvider();
	}

}
