package com.sai.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
//		        .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("account microservice rest api","these are account service apis","API 1.0","http://sai.com/terms",new springfox.documentation.service.Contact("sai","www.sai.com","sai@gmail.com"),"license of api","https://www.sai.com/license",Collections.emptyList());
	}
	
}
