package com.sandbox.java7.lang;

public class ScratchDemo {
	
	public static void main(String [] args) {
		String [] trueStringArray = {"True", "true", "TRUE" };
		String [] falseStringArray = {"yes", "false", "FALSE", "", null};
		
		int max = 10;
		int i=0;
		while ( i < max) {
			i++;
			for (int j=1; j<50; j++) {
				System.out.println("Processing: i="+ i + " j=" + j);
				if ( j%10 ==0)
					break;
			}
		}
	}
}

