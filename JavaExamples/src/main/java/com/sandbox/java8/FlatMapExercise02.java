package com.sandbox.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExercise02 {

	public static List <String> getDays(String month, int limit) {
		List <String> daysList = new ArrayList<String>();
		for (int i=0; i<limit; i++) {
			daysList.add(month + "-" + i);
		}		
		return daysList;
	}
	
	public static void main(String[] args) {
		List <String> monthList = Arrays.asList("Jan", "Feb");
		List <String> daysList = new ArrayList <String>();
				
		// create a list of days using a limit (example: Jan-0, Jan-1, Feb-0, Feb-1)
		daysList = monthList.stream()
			.flatMap(m -> getDays(m,2).stream())
			.collect(Collectors.toList());
		
		//daysList.forEach(System.out::println);
		String totalDays = daysList.stream()
			.collect(Collectors.joining(", "));
		//System.out.println(totalDays);
		if (!totalDays.equals("Jan-0, Jan-1, Feb-0, Feb-1")){
			System.out.println("Fails");
		}
	}
}
