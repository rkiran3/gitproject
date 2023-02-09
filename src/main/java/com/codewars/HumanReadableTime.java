package com.codewars;

public class HumanReadableTime {

	public static String makeReadable2(int input) {
	    
		long secs = (input % 60);
		long mins = (input / 60);
		long hrs = input / (60*60);
		long mMins = mins % 60;
		
		String message = String.format("Secs: %03d  %02d:%02d:%02d", input, hrs, mMins, secs);
		
		
		System.out.println(message);
		
	    return Integer.toString(input);
	}

	public static String makeReadable(int input) {
	    
		int SECS = 60;
		long MINS = 59*59;
		long HRS = 59*59*59;

		long secs = (input % SECS);
		long mins = (input / MINS);
		//long minsMod = (input % MINS);
		long hrs = 0;
		
		if (mins <= 60) {
			String message = String.format("Secs: %2d  %02d:%02d:%02d", input, hrs, mins, secs);
			System.out.println(message);
		} else {
			//secs = mins % SECS;
			mins = mins % SECS;
			hrs = mins % 60;
			String message = String.format("Secs: %2d  %02d:%02d:%02d", input, hrs, mins, secs);
			System.out.println(message);			
		}
		
	    return Integer.toString(input);
	}

	public static void main(String[] args) {
		
		for (int i=0; i <= 3601; i++) {
			makeReadable2(i);
		}
	}
}

