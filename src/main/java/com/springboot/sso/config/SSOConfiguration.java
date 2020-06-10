package com.springboot.sso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SSOConfiguration {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
