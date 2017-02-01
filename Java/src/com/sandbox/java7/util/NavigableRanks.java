package com.sandbox.java7.util;

// This Rank class represents a number, this implements Comparable
class Rank implements Comparable <Rank>{
    public int rankNumber;
    public Rank(int rankNumber) {
        this.rankNumber = rankNumber;
    }

    public int getRankNumber() { return rankNumber; }

    public int compareTo(Rank second) {
        System.out.println("in compareTo: comparing " +
            this.rankNumber + " with " + second.getRankNumber());
        return this.rankNumber - second.getRankNumber();
    }

    public String toString() {    return String.valueOf(rankNumber);    }
}

// This class creates some Rank objects and stores them in a Set.
public class NavigableRanks {

    public static void main(String[] args) {

        java.util.List <Rank> rankList = new java.util.LinkedList<Rank>();
        for (int i=3; i>0; i--) {
            Rank one = new Rank(i);
            rankList.add(one);
        }
        assert 3 == rankList.size();

        // Create a Set to store the List of elements, this set will store elements in sorted order
        java.util.NavigableSet<Rank> navigableSet = new java.util.TreeSet<Rank>();
        navigableSet.addAll(rankList);
        assert 3 == navigableSet.size();

        // the first element will be in sorted order
        // pollFirst: Retrieves and removes the first (lowest) element, or returns null if this set is empty.
        assert "1".equals((navigableSet.pollFirst()).toString());
        // size of set is reduced by one
        assert 2 == navigableSet.size();

        // pollLast: Retrieves and removes the last (highest) element, or returns null if this set is empty.
        assert "2".equals((navigableSet.pollFirst()).toString());
        // another element is removed from Set
        assert 1 == navigableSet.size();

        // pollLast: Retrieves and removes the last (highest) element, or returns null if this set is empty.
        assert "3".equals((navigableSet.pollLast()).toString());
        // now, Set does not contain any elements
        assert 0 == navigableSet.size();
    }
}
