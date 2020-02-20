package com.sai.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import com.sai.beans.WelcomeBean;

@Configuration
@ConditionalOnClass(WelcomeService.class)
public class WelcomeServiceAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean(value= WelcomeBean.class)
	public WelcomeBean welcomeBean() {
		System.out.println("In welcomeBean()........!");
		return new WelcomeBean();
	}
	
	@Bean
	@ConditionalOnMissingBean(value= WelcomeService.class)
	public WelcomeService welcomeService() {
		System.out.println("In welcomeService().........!");
		return new WelcomeServiceImpl();
	}
	

}
