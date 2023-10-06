package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@Configuration
public class StudentcontrolserviceApplication {
    @Bean
	public RestTemplate getresttemplate() {
		
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentcontrolserviceApplication.class, args);
	}

}
