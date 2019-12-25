package com.sandbox.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectorExercise08 {

    public static List<String> getNames() {
        class Product {
            private String name;
            Product(String name) { this.setName(name); }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }
        List <String> names = null;
        
        List <Product> products = new ArrayList<Product>();
        products.add(new Product("January"));
        products.add(new Product("February"));
        
        names = products.stream()
            .map(p->p.getName())
            .collect(Collectors.toList());
        
        String expected = products.stream()
                .filter(p -> Objects.nonNull(p.getName()))
                .map(p -> p.getName())
                .collect(Collectors.joining(","));
        
        assert("January,February".equals(expected));
        
        return names;
    }
    
    public static void main(String[] args) {
    	List<String> namesList = CollectorExercise08.getNames();
        assert(2 == namesList.size());
        
        String names = namesList.stream()
        		.collect(Collectors.joining(","));
        
        assert("January,February".equals(names));
    }

}
