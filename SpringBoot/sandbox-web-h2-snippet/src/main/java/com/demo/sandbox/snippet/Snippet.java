package com.demo.sandbox.snippet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Snippet {

	private @Id @GeneratedValue Long id;
	private String title;
	private String content;
	private String category;
	
	public Snippet(String category, String title, String content) {
		this.category = category;
		this.title = title;
		this.content = content;
	}
	
	public Snippet() {}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
