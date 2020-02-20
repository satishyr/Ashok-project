package com.tekleads.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyRestController {
	
	private static final String REST_URL="https://tekleads-ce-api.cfapps.io/getCurrencyExchangeCost/from/{from}/to/{to}";

	@GetMapping("/getCost")
	@HystrixCommand(
			fallbackMethod="getCurrencyCostFallBack"
	)
	public String getCurrencyCost() {
		
		Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		String responseJson = webClient.get()
							  		   .uri(REST_URL,"USD","INR")
							  		   .retrieve()
							  		   .bodyToMono(String.class)
							  		   .timeout(Duration.ofMillis(2500))
							  		   .block();
		return responseJson;
	}
	
	public String getCurrencyCostFallBack() {
		return "This is fallback response";
	}
	
}
