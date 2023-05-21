#!/bin/bash

# compile project
mvn compile 

# sample program to test
java -cp target/classes com.sandbox.AnyMatchInListDemo
java -cp target/classes com.codewars.Order

# clean the target directory 
mvn clean

# To test the unit tests
mvn test

# Package the project
mvn package
