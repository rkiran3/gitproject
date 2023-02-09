package com.sandbox.samples;

import java.util.ArrayList;
import java.util.List;

// Class that will be used to compare with other students
// When it implements Comparable, we need the 'compareTo' function
class Student implements Comparable<Student> {
	private String name;
	private int score;
		
	@Override
	public int compareTo(Student o) {
		return this.getScore() - o.getScore();
	}
	
	public Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

// Sample Program which creates few Students and displays them
// in sorted order.
public class ComparableDemo {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Bill", 20));
		studentList.add(new Student("Bob", 15));
		studentList.add(new Student("Pam", 35));
		
		studentList.stream()
			.sorted()
			.forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
	}
}
