package com.demo.sandbox.snippet;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface SnippetRepository extends CrudRepository<Snippet, Long> {

	List<Snippet> findAllByOrderByCrtdtDesc();
	
}
