package com.demo.sandbox.snippet;

public class SnippetNotFoundException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5012452082316395297L;

	SnippetNotFoundException(Long id) {
		super("Could not find Snippet " + id);
	}
}
