package com.sandbox.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;
import java.util.stream.Collectors;

/**
 * Input:
 * 	List of MapsOfMonthsToStones
 * 	[
 * 		{Apr=Diamond, May=Emerald, Mar=Aquamarine}
 * 		{June=Alexandrite, July=Ruby, August=Peridot}
 * 	]
 *  
 * Output: 
 *	Keys of each Map in List after applying FlatMap
 *		[Diamond, Emerald, Aquamarine, Alexandrite, Ruby, Peridot]
 */
public class FlatMapExercise03 {
	public static Logger logger = Logger.getLogger(FlatMapExercise03.class.getName());
	
	public static void main(String[] args) {
		logger.info("Begin");

		List<Map<String, String>> listOfMaps = new ArrayList<>();
		Map<String, String> springMap = new HashMap<>();
		springMap.put("Mar", "Aquamarine");
		springMap.put("Apr", "Diamond");
		springMap.put("May", "Emerald");
		System.out.println(springMap);
		
		Map<String, String> summerMap = new HashMap<>();
		summerMap.put("June", "Alexandrite");
		summerMap.put("July", "Ruby");
		summerMap.put("August", "Peridot");
		System.out.println(summerMap);
		
		listOfMaps.add(springMap);
		listOfMaps.add(summerMap);
		
		// returns a List of Map.Entry after appylying flatMap 
		List<Map.Entry<String, String>> entries = listOfMaps.stream()
			.flatMap(e -> e.entrySet().stream())
			.collect(Collectors.toList());

		// returns a List of Keys of each Map	
		// [Alexandrite, Diamond, Emerald, Ruby, Aquamarine, Peridot]
		List<String> stones = listOfMaps.stream()
				.flatMap(e -> e.entrySet().stream())
				.map(e -> e.getValue())
				.collect(Collectors.toList());
		System.out.println(stones);
		
		logger.info("End");
	}
}
