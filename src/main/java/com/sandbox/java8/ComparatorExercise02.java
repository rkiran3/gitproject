package com.sandbox.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
/**
 * We define a class that denotes a month, this class will be used later
 * to sort them by name, days
 */
class Month {
    private int days;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String toString() {
        return String.format("%-10s - %d", name, days);
    }

}
public class ComparatorExercise02 {

    /**
     * Helper Method
     * @param message
     * @param monthList
     */
    public static void printMonthList(final String message, final List<Month> monthList) {
            System.out.println(message);
            monthList.forEach(System.out::println);
    }

    public static void main(String [] args) {
        Comparator<Month> compareAscending =
                (month1, month2) -> month1.getName().compareTo(month2.getName());
        Comparator<Month> compareDescending = compareAscending.reversed();

        final Function<Month, Integer> byDays = month -> month.getDays();
        final Function<Month, String> byTheirName = month -> month.getName();

        /* Create a list of month classes with their name and days */
        List<Month> monthList = Arrays.asList(
                new Month("January", 31),
                new Month("February", 28),
                new Month("March", 31),
                new Month("April", 30),
                new Month("May", 31),
                new Month("June", 30),
                new Month("July", 31),
                new Month("August", 31),
                new Month("September", 30),
                new Month("October", 31),
                new Month("November", 30),
                new Month("December", 31)
        );

        /* sort the months by days and then by their name */
        printMonthList("Sort by Days and then by their Name:", monthList
                .stream()
                .sorted(comparing(byDays).thenComparing(byTheirName))
                .collect(toList()));

        /* Simple sort of months by their Names */
        printMonthList("Sort by Name: ",    monthList
                .stream()
                .sorted(compareAscending)
                .collect(toList()));

        /* Another test to list months by Name */
        List <Month> outMonths = monthList
                .stream()
                .sorted(compareAscending)
                .collect(toList());

        if (!outMonths.get(0).getName().equals("April")) {
            System.out.println("Error");
        }
    }
}
