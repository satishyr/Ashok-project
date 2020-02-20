package com.tekleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tekleads.service.CustomerEventsService;

@SpringBootApplication
public class FluxClientAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(FluxClientAppApplication.class, args);

		CustomerEventsService eventsService = ctxt.getBean(CustomerEventsService.class);

		eventsService.getEventRawResponse();
		// System.out.println("---------------------------------");
		// eventsService.getEventObjResponse();
		// System.out.println("------------------------------");
		// eventsService.getEvents();
	}

}
