package com.demo.sandbox.snippet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface SnippetRepository extends CrudRepository<Snippet, Long> {

	List<Snippet> findAllByOrderByCrtdtDesc();

	List<Snippet> findAllByOrderByLstmoddtDesc();

	List<Snippet> findAllByOrderByLstmoddt();
	
	@Query(nativeQuery = true, value = "SELECT * FROM SNIPPET ORDER by random() LIMIT 3")
	List<Snippet> getRand();
	
	@Query(nativeQuery = true, value = "SELECT * FROM SNIPPET ORDER by random() LIMIT ?")
	List<Snippet> getRand(int count);

	List<Snippet> findByCategory(String category);

	List<Snippet> findByCategoryContaining(String category);

	List<Snippet> findByTitle(String title);

	List<Snippet> findByTitleContaining(String title);

	List<Snippet> findByCategoryContainingIgnoreCase(String cat);

	List<Snippet> findByTitleContainingIgnoreCase(String title);
}
