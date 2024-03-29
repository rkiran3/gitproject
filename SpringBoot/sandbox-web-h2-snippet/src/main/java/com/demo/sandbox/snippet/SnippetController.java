package com.demo.sandbox.snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/snippets")
public class SnippetController {
	private final SnippetRepository repository;
	private Logger logger = LoggerFactory.getLogger(SnippetController.class);

	SnippetController(SnippetRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	@CrossOrigin
	private ResponseEntity<List<Snippet>> allSnippets(){
		List<Snippet> list = new ArrayList<>();
		System.out.println("Getting all Snippets");
		repository.findAll().forEach(e -> list.add(e));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	// Save a new Snippet
	@PostMapping
	@CrossOrigin
	Snippet newSnippet(@RequestBody Snippet newSnippet) {
		logger.info("Saving Snippet");
		return repository.save(newSnippet);
	}
	
	// Get a single Snippet
	@GetMapping("/{id}")
	Snippet one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new SnippetNotFoundException(id));
	}
	
	// Replace values of existing Snippet.
	@PutMapping("/{id}")
	Snippet replaceSnippet(@RequestBody Snippet newSnippet, @PathVariable Long id) {
		
		Optional<Snippet> existSnippetOpt = repository.findById(id);
		Snippet repSnippet;
		
		if (existSnippetOpt.isPresent()) {
			repSnippet = existSnippetOpt.get();
			repSnippet.setCategory(newSnippet.getCategory());
			repSnippet.setContent(newSnippet.getContent());
			repSnippet.setTitle(newSnippet.getTitle());
			repository.save(repSnippet);
		} else {
			newSnippet.setId(id);
			repSnippet = repository.save(newSnippet);
		}
		
		return repSnippet;
	}
	
	
	@DeleteMapping("/{id}") 
	void deleteSnippet(@PathVariable Long id) {
		
		repository.deleteById(id);
	}
}
