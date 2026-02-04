package com.example.springbootwebh2;

import java.util.List;

record User (String name) {}

public class Hello {

    public static void main (String... args) {
        User user = new User("Ravi");

        List<User> users = List.of(
                new User("Ravi"),
                new User("Chicago")

        );

        users.forEach(System.out::println);

        System.out.println(user);
    }
}
