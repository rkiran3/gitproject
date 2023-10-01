package com.demo.sandbox.snippet;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@NoArgsConstructor
public class SnippetForm {
	List<Snippet> snippetsList;
	private String keyword = "";
	private String title = "";
	private String category = "";
	private String content = "";
	
	
	public List<Snippet> getSnippetsList() {
		return snippetsList;
	}
	public void setSnippetsList(List<Snippet> snippetsList) {
		this.snippetsList = snippetsList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
