package com.tekleads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tekleads.constants.AppConstatns;
import com.tekleads.domain.CustomerEvent;
import com.tekleads.properties.AppProperties;

@Service
public class CustomerEventsService {

	@Autowired
	private WebClient webClient;
	
	@Autowired
	private AppProperties appProperties;

	public void getEventRawResponse() {
		  String eventUrl = appProperties.getMessages()
				  						 .get(AppConstatns.EVENT_URL);
		  String data = webClient.get()
		  		   .uri(eventUrl)
		  		   .retrieve()
		  		   .bodyToMono(String.class)
		  		   .block();
		  
		  System.out.println(data);
	}
	
	public void getEventObjResponse() {
		String eventsUrl = appProperties.getMessages()
										.get(AppConstatns.EVENTS_URL);
		CustomerEvent block = webClient.get()
		  		   .uri(eventsUrl)
		  		   .retrieve()
		  		   .bodyToMono(CustomerEvent.class)
		  		   .block();
		  System.out.println(block);
	}
	
	
	public void getEvents() {
	  String eventsUrl = appProperties.getMessages()
			  						  .get(AppConstatns.EVENTS_URL);
	  webClient.get()
	  		   .uri(eventsUrl)
	  		   .retrieve()
	  		   .bodyToFlux(CustomerEvent.class)
	  		   .subscribe(System.out::println);
	}
	
}
