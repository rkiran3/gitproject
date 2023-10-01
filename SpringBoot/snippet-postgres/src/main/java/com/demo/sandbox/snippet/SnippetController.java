package com.demo.sandbox.snippet;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/")
public class SnippetController {
	private final SnippetRepository repository;
	private Logger logger = LoggerFactory.getLogger(SnippetController.class);

	SnippetController(SnippetRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("th_snippets")
	public String getAll(Model model){
		List<Snippet> snippetList = repository.findAllByOrderByCrtdtDesc();
		//model.addAttribute("snippet", new Snippet());
		SnippetForm snippetForm = new SnippetForm();
		model.addAttribute("snippetForm", snippetForm);
				
		snippetList = snippetList.stream()
			.map(s -> new Snippet(s.getCategory(), s.getTitle(), s.getContent().trim()))
					.collect(Collectors.toList());
		
		snippetForm.setSnippetsList(snippetList);
		
		model.addAttribute("snippets", snippetList);
		logger.info("Adding snippets");
		
		return "list_snippets";
	}
	
	@PostMapping("th_snippets")
	public String snippetSubmit(@ModelAttribute("snippetForm") SnippetForm snippetForm
			, BindingResult bindingResult
			, Model model){
		if (bindingResult.hasErrors()) {
			return "error";
		}
		List<Snippet> snippetList = repository.findAllByOrderByCrtdtDesc();
		snippetList = snippetList.stream()
			.map(s -> new Snippet(s.getCategory(), s.getTitle(), s.getContent().trim()))
			.collect(Collectors.toList());

		model.addAttribute("snippetForm", snippetForm);
		snippetForm.setSnippetsList(snippetList);
		
		logger.info("Adding snippets");
		model.addAttribute("snippets", snippetList);
		return "list_snippets";
	}
	
	// Get random Snippet
	@GetMapping("/th_rand")
	private String getRand(Model model){
		return getRand(model, 5);
	}

	// Get a random List of Snippet based on count
	@GetMapping("/th_rand/{count}")
	private String getRand(Model model, @PathVariable Integer count){
		List<Snippet> snippetList = repository.getRand(count);
		SnippetForm snippetForm = new SnippetForm();
		
		snippetForm.setSnippetsList(snippetList);
		model.addAttribute("snippetForm", snippetForm);
		model.addAttribute("snippet", new Snippet());
		model.addAttribute("snippets", snippetList);
		logger.info("Adding snippets");
		return "list_snippets";
	}
}