package com.qa.PlayerMSt;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
