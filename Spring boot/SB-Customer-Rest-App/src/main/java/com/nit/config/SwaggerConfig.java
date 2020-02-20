package com.nit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2).
				 select()
				.apis(RequestHandlerSelectors.basePackage("com.nit.rest"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiMetaData());
	}

	private ApiInfo apiMetaData() {
		
		Contact contact = new Contact("Naresh I Technologies", "www.nareshit.com", "info@nareshit.com");
		
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Online Store", 
				"1.0",
				"Terms of service",
				contact,
				"Apache License Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

}
