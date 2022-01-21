package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class MyArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = -1096016601671653667L;

	boolean removeAll(E e) {
		for (int i=0; i < size(); i++) {
			E tmpObj = get(i);
			if (tmpObj != null && tmpObj.equals(e)) {
				remove(e);
			} else {
				if (tmpObj == e) {
					remove(e);
				}
			}
		}

		return false;
	}
}


class Empl {
	String name;
	int age;
	public Empl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Empl)) {
			return false;
		}
		Empl other = (Empl)o;
		boolean b = this.name.equals(other.name);
		return b;
	}
	
	public int hashcode() {
		return this.name.hashCode();
	}
	
	public String toString() {
		return this.name + " " + this.age;
	}
	
}

public class Test {

	public static void main(String[] args) {
		MyArrayList <Empl> names = null;
		
		List<Empl> tmp = Optional.ofNullable(names).orElseGet(MyArrayList::new);
		
		names.add(new Empl("Robb", 20));
		//names.add(new Empl("Bran", 21));
		names.add(null);
		names.add(new Empl("Rick", 22));
		names.add(new Empl("Bran", 21));
		
		if (names.indexOf(new Empl("Rick", 22)) > 0) {
			names.add(new Empl("Jon", 23));
		}
		
		if (names.removeAll(new Empl("Bran", 21))) {
			names.remove(new Empl("Jonathan", 24));
		}
		

		
		
		System.out.println(names);
	}

}
