package com.demo.sandbox.snippet;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
public class SnippetRestController {
	private final SnippetRepository repository;
	private Logger logger = LoggerFactory.getLogger(SnippetRestController.class);

	SnippetRestController(SnippetRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	@CrossOrigin
	private ResponseEntity<List<Snippet>> allSnippets(){
		System.out.println("Getting all Snippets");
		List<Snippet> snippetList = repository.findAllByOrderByCrtdtDesc();
		return new ResponseEntity<>(snippetList, HttpStatus.OK);
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
	
	// Get List of Snippets based on category
	@GetMapping("/c/{cat}")
	List<Snippet> findByCategory(@PathVariable String cat) {
		List<Snippet> snippetCatList = repository.findByCategory(cat);
		if (snippetCatList.size() == 0) {
			snippetCatList = repository.findByCategoryContainingIgnoreCase(cat);
		}
		return snippetCatList;
	}

	// Get List of Snippets based on title
	@GetMapping("/t/{title}")
	List<Snippet> findByTitle(@PathVariable String title) {
		List<Snippet> snippetTitleList = repository.findByTitle(title);
		if (snippetTitleList.size() == 0) {
			snippetTitleList = repository.findByTitleContainingIgnoreCase(title);
		}
		return snippetTitleList;
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
	
	// Get random Snippets
	@GetMapping("/rand")
	private ResponseEntity<List<Snippet>> getRand(){
		List<Snippet> snippetList = repository.getRand();
		return new ResponseEntity<>(snippetList, HttpStatus.OK);
	}

	@GetMapping("/all")
	public String getAll(Model model){
		List<Snippet> snippetList = repository.findAllByOrderByCrtdtDesc();
		model.addAttribute("snippets", snippetList);
		return "list_snippets";
	}

	// Get a random List of Snippets based on count
	@GetMapping("/rand/{count}")
	private ResponseEntity<List<Snippet>> getRand(@PathVariable Integer count){
		List<Snippet> snippetList = repository.getRand(count);
		return new ResponseEntity<>(snippetList, HttpStatus.OK);
	}
	
}
