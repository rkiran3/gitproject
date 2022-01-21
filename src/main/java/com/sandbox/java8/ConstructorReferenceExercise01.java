package com.sandbox.java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This example will show how to use Constructor Reference
 * i.e (Object::new)
 *
 *
 */
class User {
    protected String name;
    public User(String name) {this.name = name;}
    public String toString() { return "User: " + name;}
}


public class ConstructorReferenceExercise01 {

    public static void main(String [] args) {
        String [] labels = {"Bill", "Bob"};

        // construct a Stream of User Object
        Stream<User> userStream = Arrays.asList(labels)
                .stream()
                .map(User::new);

        assert (userStream.count() == 2);
    }
}
