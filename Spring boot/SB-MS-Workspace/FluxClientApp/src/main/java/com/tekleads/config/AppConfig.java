package com.tekleads.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

	@Bean
	public WebClient buildWebClient() {
		WebClient.Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		return webClient;
	}

}
