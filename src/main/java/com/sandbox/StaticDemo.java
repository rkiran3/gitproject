package com.sandbox;

import java.util.ArrayList;
import java.util.List;

class Board {
	public static final List<Integer> idList = new ArrayList<Integer>();
	static {
		idList.add(Integer.valueOf(22));
	}

	static {
		idList.add(Integer.valueOf(22));
	}
}

public class StaticDemo {
	
	public static void main(String[] args) {
		Board.idList.stream()
			.map(String::valueOf)
			.forEach(System.out::println);
		
	}

}
