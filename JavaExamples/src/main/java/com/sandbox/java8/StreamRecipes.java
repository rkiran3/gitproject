package com.sandbox.java8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class StreamRecipes {

    public int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d\n", n);
        return n * 2;
    }

    public boolean divByThree(int n) {
        System.out.printf("Inside divByThree with arg %d\n", n);
        return n % 3 == 0;
    }

    public boolean isPalindrome(String s) {
        String forward = s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }

    public static void main(String [] args) {
        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(nums); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // Print consecutive days from today
        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);

        // Convert IntStream to an Array
        int[] intArray = IntStream.of(3, 1, 4, 1, 5, 9).toArray();

        //int[] intArray2 = IntStream.of(3, 1, 4, 1, 5, 9).toArray(int[]::new);

        // Summing using reduce, prints 55
        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + y).orElse(0);
        System.out.println("Sum: " + sum);

        // Print or debug intermediate sum
        int sum2 = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x=%d, y=%d%n", x, y);
                    return x + y;
                }).orElse(0);

        int sum3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);

        // max
        Integer max = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("The max value is " + max);

        // concat
        String s = Stream.of("this", "is", "a", "list")
                .reduce("", String::concat);
        System.out.println(s);

        // Create a Map of BookId with Book
        /*HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(),  1
        (map, book) -> {                2
            map.put(book.getId(), book);
            return map;
        },
                (map1, map2) -> {              3
                    map1.putAll(map2);
                    return map1;
                });
        bookMap.forEach((k,v) -> System.out.println(k + ": " + v));
        */

        // debugging while iterating
        int total = IntStream.rangeClosed(1, 10)
                .map(n -> {
                    System.out.println(n);
                    return n;
                })
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .sum();


        // partition by length
        Stream <String> stringsStream = Stream.of( "is", "a", "my", "this");
        Map<Boolean, Long> numberLengthMap = stringsStream
                .collect(Collectors.partitioningBy(
                        ss -> ss.length() % 2 == 0,
                        Collectors.counting()));
        numberLengthMap.forEach((k, v) -> System.out.printf("%5s: %d\n", k, v));
        //
        // false: 4
        // true: 8

        /*OptionalInt firstEvenDoubleDivBy3 = IntStream.range(1, 99999)
                .map(this::multByTwo)
                .filter(this::divByThree)
                .findFirst();*/

        // Creating a LinkedList
        List<String> actors =
                Stream.of("Hank Azaria", "Janeane Garofalo", "William H. Macy",
                        "Paul Reubens", "Ben Stiller", "Kel Mitchell", "Wes Studi")
                        .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(actors.stream().collect(Collectors.joining(", ")));


        //------ Creating a Map of Actors {name: role}
        /*Set<Actor> actors = mysteryMen.getActors();

        Map<String, String> actorMap = actors.stream()
                .collect(Collectors.toMap(Actor::getName, Actor::getRole)); 1

        actorMap.forEach((key,value) ->
                System.out.printf("%s played %s%n", key, value)); */



        //-------- Adding books to a Map { Book Object has id, name }
        /*Map<Integer, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, b -> b));
        bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));

        Identity lambda: given an element, return it
        2

        Static identity method in Function does the same thing */

        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
                "strings", "to", "use", "as", "a", "demo");

        Map<Boolean, List<String>> lengthMap = strings.stream()
                .collect(Collectors.partitioningBy(sl -> sl.length() % 2 == 0));

        lengthMap.forEach((key,value) -> System.out.printf("%5s: %s%n", key, value));
//
// false: [a, strings, use, a]
//  true: [this, is, long, list, of, to, as, demo]
        // The Collectors.partitioningBy method splits elements into those that satisfy a Predicate and those that do not.
        // The Collectors.groupingBy method produces a Map of categories, where the values are the elements in each category.

        //The groupingBy method performs an operation like a “group by” statement in SQL. It returns a Map where the keys are the groups and the values are lists of elements in each group.


        //fibbonacci
        /*
        private Map<Long, BigInteger> cache = new HashMap<>();

public BigInteger fib(long i) {
    if (i == 0) return BigInteger.ZERO;
    if (i == 1) return BigInteger.ONE;

    return cache.computeIfAbsent(i, n -> fib(n - 2).add(fib(n - 1))); 1
}

         */



    } // main ends
}
