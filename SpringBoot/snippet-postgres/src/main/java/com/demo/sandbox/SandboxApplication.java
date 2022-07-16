package com.demo.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SandboxApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("Add Cors Mapping");
				registry.addMapping("/snippets/*")
						.allowedOrigins("*")
						.allowCredentials(false)
						.allowedHeaders("*")
						.exposedHeaders("*")
						.allowedMethods("*");
			}
		};
	}
}
