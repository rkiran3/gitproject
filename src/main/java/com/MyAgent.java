package com;

import java.lang.instrument.Instrumentation;
	
public class MyAgent {
    private static Instrumentation instrumentation;
	
    public static void premain(String args, Instrumentation inst) {
    	instrumentation = inst;
    }
    
	public static long getObjectSize(Object someObject) {
		System.out.println("within getObjectSize");
		
	    return instrumentation.getObjectSize(someObject);
	  }
}
	