package com.devgym.may2020;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamChallenge16 {
	public static Logger logger = Logger.getLogger(StreamChallenge16.class.getName());
	
	public static void main(String [] args) {
		int []counterArr = new int[99999];
		
		int count=0;
		for (int i=0; i< Integer.MAX_VALUE; i++) {
			Set <Warrior> warriorSet = Set.of(
					new Warrior("Cabbage"),
					new Warrior("penta"),
					new Warrior("Furs"));
			
			List<Warrior> outList = warriorSet.stream()
				//.distinct()
				.sorted()
				.collect(Collectors.toList());
			
            System.out.println("list size: " + outList.size());

			counterArr[count] = counterArr[count] + i;
			count++;
			if (count > 10000) {
				count = 0;
			}
		}
		
		logger.info("End");
	}
	
	static class Warrior implements Comparable<Warrior> {
		private String name;
		public Warrior(String name) {
			this.setName(name);
		}
		
		public String toString() {
			return getName();
		}

		
		
		@Override
		public int compareTo(Warrior wo) {
			return this.name.compareTo(wo.getName());
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			return this.name.length();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			Warrior otherObj = (Warrior)obj;
			
			return this.name.length() == otherObj.getName().length();
		}
	}
}
