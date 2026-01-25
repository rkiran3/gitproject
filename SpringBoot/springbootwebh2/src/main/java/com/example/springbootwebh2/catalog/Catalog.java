package com.demo.sandbox.catalog;

public class Catalog {

	private Long id;
	private String name;
	
	public Catalog() {
		super();
	}

	public Catalog(Long id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
