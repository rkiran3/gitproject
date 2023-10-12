package com.sandbox.samples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

// Class that will be used to compare with other students
// When it implements Comparable, we need the 'compareTo' function
@AllArgsConstructor
@Getter
@Setter
@ToString
class Student implements Comparable<Student> {
    private String name;
    private int score;

    @Override
    public int compareTo(Student o) {
        return this.getScore() - o.getScore();
    }
}

// Sample Program which creates few Students and displays them
// in sorted order.
@Log
public class ComparableDemo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        
        // Add few students to list
        String[] names = { "Paul", "Mike", "Arthur" };
        int[] scores = {20, 15, 35};
        int index = 0;
        for (String name: names) {
            studentList.add(new Student(name, scores[index++]));
        }
        
        log.info("====> Sort and print by student score");
        // Here, we create a Stream using the List and sort them
        // this invokes the compareTo() method within the Student class
        studentList.stream()
            .sorted()
            .forEach(System.out::println);

        log.info("====> Sort and print by student name");
        // Compare by name
        studentList.stream()
            .sorted(Comparator.comparing(Student::getName))
            .forEach(System.out::println);
    }
}
