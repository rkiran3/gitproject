package com.sandbox.java8;

import java.util.Optional;

public class OptionalExercise02 {

	
	public static void main(String[] args) {
		String demo = null;
		Optional <String>optN = Optional.ofNullable(demo);
		boolean result = optN.isPresent();
		assert(!result);
		
		demo = "";
		
		assert(result);
		
	}

}
