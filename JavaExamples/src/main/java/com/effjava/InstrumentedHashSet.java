package com.effjava;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet <E> extends HashSet<E> {
	private int addCount = 0;
	
	public InstrumentedHashSet () { }
	
	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}
	
	@Override
	public boolean add(E e) {
		setAddCount(getAddCount() + 1);
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection <? extends E> c) {
		setAddCount(getAddCount() + c.size());
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}
	
	public static void main(String[] args) {
		InstrumentedHashSet <String> insHashSet = new InstrumentedHashSet<String>();
		insHashSet.addAll(Arrays.asList("One", "Two", "Three"));
		
		System.out.println(insHashSet.getAddCount());
	}

	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

}
