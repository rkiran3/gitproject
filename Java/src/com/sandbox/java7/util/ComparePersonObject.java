package com.sandbox.java7.util;

import java.util.*;

class Person {
    String name;
    String number;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return String.format("[%s]", this.name);
    }

    public String getName() {
        return name;
    }

    public boolean equals (Object object) {
        boolean result = false;

        if (this == object) {
            result = true;

        } else {
            if (!(object instanceof Person )) {
                result = false;
            } else {
                Person person = (Person)object;
                if ((person.name.equals(this.name)) && (person.number == this.number)) {
                    result = true;
                }
            }
        }
        return result;
    }
}

public class ComparePersonObject {

    public static void main(String [] args) {

        Map <Person, String> personMap = new HashMap<Person, String>();
        // create Person objects in different formats
        Person greenPerson = new Person("green", "Greenname");
        Person [] personArray = {
                new Person ("yellow", "number"),
                new Person("red", "number")
        };

        List <Person> personList = Arrays.asList(personArray);
        // Add the different persons to Person Map
        for ( Person person : personList ) {
            personMap.put(person, person.getName());
        }
        personMap.put(greenPerson, greenPerson.getName());

        // Print the Person Map for debug purposes
        for (Map.Entry <Person, String>entry : personMap.entrySet()) {
            Person tmpPerson = entry.getKey();
            System.out.println (String.format("%s: %d", tmpPerson, tmpPerson.hashCode()));
        }

        System.out.println("Creating another Yellow Person -- ");
        Person yellowPerson = new Person("yellow", "number");
        System.out.println (String.format("%s: %d", yellowPerson, yellowPerson.hashCode()));
        System.out.println("Getting Yellow Person -- ");
        String name = personMap.get(yellowPerson);
        System.out.println("name: " + name);

        System.out.println("Printing Green Person -- ");
        System.out.println (String.format("%s: %d", greenPerson, greenPerson.hashCode()));
        System.out.println("Getting Green Person -- ");
        System.out.println(personMap.get(greenPerson));

    }
}
