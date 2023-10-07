package com.demo.sandbox.snippet;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SNIPPET")
@Getter
@Setter
@Data
public class Snippet {

	private @Id @GeneratedValue Long id;
	private String category;
	private String title;
	@Getter @Setter
	private String content;
	@Getter @Setter
	private Timestamp crtdt;
	@Getter @Setter
	private Timestamp lstmoddt;
	
	public Snippet(String category, String title, String content, Date crtDt) {
		this.category = category; 
		this.title = title; 
		
		this.content = content;
		this.setCrtdt(new Timestamp(crtDt.getTime())); 
		this.setLstmoddt(new Timestamp(new Date().getTime())); 
	}
	 
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

	public Timestamp getCrtdt() {
		return crtdt;
	}

	public void setCrtdt(Timestamp crtdt) {
		this.crtdt = crtdt;
	}

	public Timestamp getLstmoddt() {
		return lstmoddt;
	}
	
	public void setLstmoddt(Timestamp lstmoddt) {
		this.lstmoddt = lstmoddt;
	}

}
