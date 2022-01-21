package com.devgym.mar2020;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TokenizerChallenge {
    public static void main(String[] args) {
       Scanner sc = new Scanner("ThisIsIt,theFinalString,NoBugsProject");
       
       Pattern pattern = Pattern.compile("[^\\w*]");
       sc.useDelimiter(pattern);
      
       while (sc.hasNext()) {
           System.out.println(sc.next());
       }

       sc.close();
    }
}

/*

What will be displayed on the screen after the main method is executed as follows?

javac TokenizerChallenge.java
java TokenizerChallenge


ThisIsIt		<-- Correct Answer
theFinalString
NoBugsProject



This
String
Project


ThisIsIt,
theFinalString,
NoBugsProject


None of the above.

Quiz (assume Oracle Database 10g or higher)

I create and populate the following tables:

CREATE TABLE plch_employees
(
   employee_id   INTEGER
 , last_name     VARCHAR2 (20)
)

BEGIN
   INSERT INTO plch_employees
        VALUES (100, 'Jobs');

   INSERT INTO plch_employees
        VALUES (200, 'Ellison');

   INSERT INTO plch_employees
        VALUES (300, 'Gates');

   COMMIT;
END;
/

CREATE TABLE plch_bonus
(
   employee_id   INTEGER
 , bonus         NUMBER
)
/

BEGIN
   INSERT INTO plch_bonus
        VALUES (100, 100000);

   INSERT INTO plch_bonus
        VALUES (200, 200000);

   COMMIT;
END;
/

My boss wants a list of employees and their bonus. An employee should be listed even if he does not have a bonus. Which of the choices produces this desired output:

LAST_NAME                 BONUS
-------------------- ----------
Jobs                     100000
Ellison                  200000
Gates



*/


