//package sandbox;

import java.util.Arrays;
import java.util.stream.*;

public class ArraysDemo {
	public static void main(String [] args) {
		try {
			// Create Array of Strings
			String [] months = { "Jan", "February", "March" };
			
			// Create a Stream from the Array 			
			Stream <String> stringStream = Arrays.stream(months);
			
			// Count 
			assert months.length == stringStream.count();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // main ends
} // classTest ends
