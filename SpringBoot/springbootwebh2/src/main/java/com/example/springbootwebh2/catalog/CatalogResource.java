package com.demo.sandbox.catalog;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogResource {

	@GetMapping("/catalogs")
	public List<String> retrieveAllStudents() {
		String[] months = { "Java", "Python" };
		return Arrays.asList(months);
	}

	
}
