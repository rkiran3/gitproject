package com.demo.sandbox.snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface SnippetRepository extends CrudRepository<Snippet, Long> {

}
