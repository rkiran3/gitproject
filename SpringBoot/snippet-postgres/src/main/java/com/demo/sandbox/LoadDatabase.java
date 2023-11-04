package com.demo.sandbox;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.sandbox.snippet.Snippet;
import com.demo.sandbox.snippet.SnippetRepository;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(SnippetRepository repository) {
		return args -> {
			log.info("loading data");
			//repository.save(new Snippet("Java", "Optional ", "Check Optional using isExists", new Date()));
			
			//repository.save(new Snippet("Java", "Optional Hello ", "Check Optional using isExists"));
			
			//repository.save(new Snippet("SpringBoot", "Configuration Bean annotation", "use the @Bean Annotation in the @Configuration class to preload entities"));
			
			//repository.save(new Snippet("Thymeleaf", "use th:href to process expression", "Thymeleaf"));
			
		};
		
	}
}
