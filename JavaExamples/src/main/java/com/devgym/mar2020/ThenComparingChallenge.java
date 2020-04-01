package com.devgym.mar2020;
/*
What will be displayed on the screen after the main method is executed as follows?

javac ThenComparingChallenge.java
java ThenComparingChallenge
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThenComparingChallenge {

    public static void main(String... doYourBest) {
        List<Jedi> jediList = new ArrayList<>();
        jediList.add(new Jedi("Anakin", 10));
        jediList.add(new Jedi("Luke", 5));
        jediList.add(new Jedi("Luke", 6));
        jediList.add(new Jedi("Obi Wan", 7));

        Comparator<Jedi> comparator = Comparator
                .comparing(Jedi::getName)
                .thenComparing((a1,a2) -> a2.age.compareTo(a1.getAge()));

        Collections.sort(jediList, comparator);
        jediList.forEach(j -> System.out.println(j.name + ":" + j.age));
    }

    static class Jedi {
        String name;
        Integer age;
        public Jedi(String name, Integer age) {
            this.name = name;
            this.age = age; }
        public String getName() { return name; }
        public Integer getAge() { return age;  }
    }
}

/*
Anakin:10
Luke:6
Luke:5
Obi Wan:7


define the following nested table types and relational table:

CREATE OR REPLACE TYPE plch_parents_t IS TABLE OF VARCHAR2 (100);
/

CREATE OR REPLACE TYPE plch_children_t IS TABLE OF VARCHAR2 (100);
/

CREATE TABLE plch_family
(
   surname          VARCHAR2 (1000)
 , parent_names     plch_parents_t
 , children_names   plch_children_t
)
NESTED TABLE children_names
   STORE AS children_nt
NESTED TABLE parent_names
   STORE AS parents_nt                            
/

I then populate the table with a single row of data, and within this row, I store the name of our oldest son, Chris:

INSERT INTO plch_family (surname, parent_names, children_names)
     VALUES (
               'Silva-Feuerstein'
             , plch_parents_t ('Steven', 'Veva')
             , plch_children_t ('Chris'))
/

Ah, frabjous joy! On October 1, 1986, our second son, Eli, was born. So it is time to add his name to the list of children in the "Silva-Feuerstein" family. Which of these choices will successfully perform an insert into the children_names column of the single row in this table?
Choices - Select all that apply.
Choice 1

INSERT INTO TABLE (SELECT children_names
                     FROM plch_family
                    WHERE surname = 'Silva-Feuerstein')
     VALUES ('Eli')
/

Choice 2

INSERT INTO plch_family (children_names)
   VALUES ('Eli')
/

Choice 3

INSERT INTO plch_family.children_names
   VALUES ( 'Eli' )
/

Choice 4

INSERT INTO (SELECT children_names
          FROM plch_family
         WHERE surname = 'Silva-Feuerstein')
   VALUES ('Eli')
/


*/