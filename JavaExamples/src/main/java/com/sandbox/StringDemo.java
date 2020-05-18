package com.sandbox;

import java.util.logging.Logger;

public class StringDemo {
	
	public static Logger logger = Logger.getLogger(StringDemo.class.getName());
	
	public String customFormat(String value) {
		if (value == null) {
			return null;
		}
		
		if (value.length() == 7) {
			//return value.substring(0,3) + "-" + value.substring(3,7);
			StringBuilder sb = new StringBuilder(value.substring(0,3));
			sb.append("-");
			sb.append(value.substring(3,7));
			
			return sb.toString();
		}
		
		
		return null;
	
	}
	
	public static void main(String[] args) {
		logger.info("Start");
		
		StringDemo stringDemo = new StringDemo();
		String result = stringDemo.customFormat("1234567");
		
		logger.info("End " + result);
	}

}
