package com.devgym.apr2020;

//import java.util.function.Function;

public class InterfaceChallenge {

    interface Jedi {
        String MASTER = "Yoda";

        /*default String attack() {
            return jump(jedi -> String.join(jedi, useSaber(), useForce()));
        }

        private String jump(Function<String, String> function) {
            return function.apply("Luke");
        }

        private static String useSaber() {
            return "S";
        }

        private String useForce() {
            return "F";
        }*/

    }

    public static void main(String... starWars) {
//        System.out.println(new Jedi() {
//                public String useForce() { 
//                    return "X"; 
//                }
//            }.attack() + Jedi.useSaber() + Jedi.MASTER
//        );
    }
}

/*
What will be displayed on the screen after the main method is executed as follows?

javac InterfaceChallenge.java
java InterfaceChallenge

Choices - Select all that apply.
Choice 1

SLukeFSYoda

Choice 2

A compilation error
Choice 3

LukeXYoda

Choice 4

LukeSFSYoda




I create and populate the following table:

CREATE TABLE plch_employees
(
   employee_id   INTEGER
 , last_name     VARCHAR2 (20)
 , salary        NUMBER
)
/

BEGIN
   INSERT INTO plch_employees
        VALUES (100, 'Jobs',       200000);

   INSERT INTO plch_employees
        VALUES (200, 'Ellison',    300500);

   INSERT INTO plch_employees
        VALUES (300, 'Gates',      199500);

   INSERT INTO plch_employees
        VALUES (400, 'Feuerstein', 199400);

   INSERT INTO plch_employees
        VALUES (500, 'Hansen',     200600);

   COMMIT;
END;
/

My boss wants a list of employees and for each employee he wants to see how many employees has a comparable salary (defined as earning same salary +/- 1000.)

Which of the choices produce this desired output:

LAST_NAME                SALARY    SIMILAR
-------------------- ---------- ----------
Jobs                     200000          4
Ellison                  300500          1
Gates                    199500          3
Feuerstein               199400          3
Hansen                   200600          2

Choices - Select all that apply.
Choice 1

SELECT last_name
     , salary
     , COUNT(*) OVER (
         ORDER BY salary
         ROWS BETWEEN 1000 PRECEDING AND 1000 FOLLOWING
       ) similar
FROM plch_employees
ORDER BY employee_id;

Choice 2

SELECT last_name
     , salary
     , COUNT(*) OVER (
         ORDER BY salary
         RANGE BETWEEN 1000 PRECEDING AND 1000 FOLLOWING
       ) similar
FROM plch_employees
ORDER BY employee_id;

Choice 3

SELECT e.last_name
     , e.salary
     , ( SELECT COUNT(*)
         FROM plch_employees e_similar
         WHERE e_similar.salary BETWEEN e.salary - 1000
                                    AND e.salary + 1000
       ) similar
FROM plch_employees e
ORDER BY e.employee_id;

Choice 4

SELECT MAX(last_name) last_name
     , MAX(salary) salary
     , COUNT(*) similar
FROM plch_employees
GROUP BY employee_id
HAVING MIN(salary) BETWEEN MAX(salary) - 1000
                       AND MAX(salary) + 1000
ORDER BY employee_id;

No choice is correct.




*/