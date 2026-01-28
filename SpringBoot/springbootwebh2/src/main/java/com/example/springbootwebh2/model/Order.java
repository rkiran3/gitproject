package com.example.springbootwebh2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor // Required by JPA
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
