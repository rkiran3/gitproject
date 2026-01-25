package com.example.springbootwebh2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, updatable=false)
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
