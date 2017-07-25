package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.*;

//This will signify to Spring to treat this object as a database entity.
@Entity
public class User {
    private Integer id;
    private String name;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
