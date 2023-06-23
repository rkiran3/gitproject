package com.devgym.apr2020;

// import java.util.List;
// import java.util.Set;
// import java.util.stream.Stream;


// Needs Java 9
public class TakeAndDropWhileChallenge {
	public static void main(String... castleVania) {
//        List<Integer> alucardHits = List.of(9, 7, 1, 8, 5);
//        Set<Integer> draculaHits = Set.of(9, 6, 5, 7, 8);
//
//        Stream<Integer> alucardPerformedHits = alucardHits.stream()
//                .takeWhile(i -> i > 5)
//                .dropWhile(i -> i > 8);
//
//        Stream<Integer> draculaPerformedHits = draculaHits.stream()
//                .takeWhile(i -> i > 1)
//                .dropWhile(i -> i > 7);
//
//        Stream.of(alucardPerformedHits, draculaPerformedHits).flatMap(h -> h)
//                .forEach(System.out::print);
    }

}

/*
What will happen after the main method is executed as follows?

javac TakeAndDropWhileChallenge.java
java TakeAndDropWhileChallenge

Choices - Select all that apply.
Choice 1

76578

Choice 2

7 and random values

Choice 3

786578

Choice 4

78657




I create the following table:

CREATE TABLE PLCH_EMP ( EMP_NO NUMBER, ENAME VARCHAR2(20), COUNTRY VARCHAR2(5), SAL NUMBER);

and insert following records:

INSERT INTO PLCH_EMP VALUES(1, 'Steven', 'US', 5000);
INSERT INTO PLCH_EMP VALUES(2, 'Finn',   'UK', 2000);
INSERT INTO PLCH_EMP VALUES(3, 'Larry',  'US', 1000);
INSERT INTO PLCH_EMP VALUES(4, 'Anil',   'IN', 3000);
INSERT INTO PLCH_EMP VALUES(5, 'Elison', 'US', 2000);
INSERT INTO PLCH_EMP VALUES(6, 'Kim',    'UK', 2000);
INSERT INTO PLCH_EMP VALUES(7, 'Mike',   'DE', 1500);

COMMIT;

I want to calculate total salary of employees per country, for all countries except 'UK' where the country salary total is greater than 2000.

From following choices which choice will calculate the correct sum so that following is displayed on the screen sorted by country:

IN    3000
US    8000

Choices - Select all that apply.
Choice 1

SELECT COUNTRY,
  SUM(SAL)
FROM PLCH_EMP
WHERE COUNTRY != 'UK'
GROUP BY COUNTRY
HAVING SUM(SAL) > 2000
ORDER BY COUNTRY;

Choice 2

SELECT COUNTRY,
  SUM(SAL)
FROM PLCH_EMP
GROUP BY COUNTRY
HAVING COUNTRY != 'UK'
AND SUM(SAL)    > 2000
ORDER BY COUNTRY;

Choice 3

SELECT COUNTRY,
  SUM_SAL
FROM
  (SELECT COUNTRY, SUM(SAL) SUM_SAL FROM PLCH_EMP GROUP BY COUNTRY
  )
WHERE COUNTRY != 'UK'
AND SUM_SAL    > 2000;

Choice 4

SELECT COUNTRY,
  SUM(SAL)
FROM PLCH_EMP
WHERE COUNTRY != 'UK'
AND SUM(SAL)   > 2000
GROUP BY COUNTRY
ORDER BY COUNTRY;

Choice 5

SELECT COUNTRY,
  SUM(SAL)
FROM PLCH_EMP
GROUP BY COUNTRY
HAVING COUNTRY != 'UK'
AND SAL         > 2000
ORDER BY COUNTRY;

No choice is correct.


*/