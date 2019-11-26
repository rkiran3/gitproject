package com.sandbox;

class BaseDemo {
	public BaseDemo() {
		System.out.println("BaseDemo");
	}
	
}

public class ConstructorDemo extends BaseDemo {

	public ConstructorDemo () {
		//super();
		System.out.println("ConstructorDemo");
	}
	
	public static void main(String[] args) {
		ConstructorDemo demo = new ConstructorDemo();
	}

}
