
package com.devgym.apr2020;

import java.io.Closeable;
import java.io.IOException;

/* JAVA 9*/
public class ExceptionChallenge {

//    static String marvelHero = "";
//
//    public static void main(String... marvel) throws Exception {
//        Logan logan = new Logan();
//        new ExceptionChallenge().executeAction(new PeterParker(), logan);
//        System.out.println(marvelHero + logan.wolverineCloseCount);
//    }
//
//    private void executeAction(Closeable spiderMan, AutoCloseable wolverine) throws Exception {
//        try (spiderMan; wolverine) {
//            wolverine.close();
//        } catch (Exception ignore) {
//            marvelHero += "?";
//            spiderMan.close();
//        }
//    }
//
//    static class PeterParker implements Closeable {
//        public void close() {
//            marvelHero += "#";
//        }
//    }
//
//    static class Logan implements AutoCloseable {
//        int wolverineCloseCount = 0;
//
//        public void close() throws IOException {
//            marvelHero += ">";
//            wolverineCloseCount++;
//
//            if (wolverineCloseCount >= 1) {
//                throw new IOException();
//            }
//        }
//    }

}
/*
What will happen after the main method is executed as follows?

javac ExceptionChallenge.java
java ExceptionChallenge

Choices - Select all that apply.
Choice 1

IOException will be thrown

Choice 2

>#?#1

Choice 3

>>#?#2

Choice 4

>#? then IOException will be thrown




I define and populate 3 tables in my schema: a CUSTOMERS table, a PRODUCTS table and a SALES table, as follows:

CREATE TABLE plch_customer (
  cust_id    INTEGER PRIMARY KEY
, cust_name  VARCHAR2(100)
)
/

BEGIN
   INSERT INTO plch_customer VALUES (100, 'Customer A');
   INSERT INTO plch_customer VALUES (200, 'Customer B');
   INSERT INTO plch_customer VALUES (300, 'Customer C');
   INSERT INTO plch_customer VALUES (400, 'Customer D');

   COMMIT;
END;
/

CREATE TABLE plch_product (
  prod_id   INTEGER PRIMARY KEY
, prod_name VARCHAR2(100)
)
/

BEGIN
   INSERT INTO plch_product  VALUES (10,'Mouse');
   INSERT INTO plch_product  VALUES (20,'Keyboard');
   INSERT INTO plch_product  VALUES (30,'Monitor');

   COMMIT;
END;
/

CREATE TABLE plch_sales (
  cust_id   INTEGER NOT NULL
, prod_id   INTEGER NOT NULL
, quantity  NUMBER  NOT NULL
)
/

BEGIN
   INSERT INTO plch_sales  VALUES (100, 10, 500);
   INSERT INTO plch_sales  VALUES (100, 10, 800);
   INSERT INTO plch_sales  VALUES (100, 20, 600);

   INSERT INTO plch_sales  VALUES (200, 10, 400);
   INSERT INTO plch_sales  VALUES (200, 20, 300);
   INSERT INTO plch_sales  VALUES (200, 20, 700);

   INSERT INTO plch_sales  VALUES (300, 10, 100);
   INSERT INTO plch_sales  VALUES (300, 10, 200);
   INSERT INTO plch_sales  VALUES (300, 10, 900);

   COMMIT;
END;
/

We want to display a list of total quantities sold to each customer for each product, with the following requirements:

    A product will appear in the list if and only if it was sold to at least one customer.
    For each product in the list, the total sales for each customer from the plch_customer table will be displayed, with a sales value of 0 for a customer that did not buy a specific product.

The output will look as follows:

      CUST_ID       PROD_ID         TOTAL
------------- ------------- -------------
          100            10          1300
          100            20           600
          200            10           400
          200            20          1000
          300            10          1200
          300            20             0
          400            10             0
          400            20             0

Which of the select statements below does implement correctly this requirement ?
Choices - Select all that apply.
Choice 1

SELECT s.cust_id  cust_id,
       s.prod_id  prod_id,
       SUM(s.quantity)  total
FROM plch_sales s
GROUP BY
       s.cust_id,
       s.prod_id
UNION ALL
SELECT c.cust_id  cust_id,
       p.prod_id  prod_id,
       0  total
FROM plch_customer  c,
   ( SELECT DISTINCT s.prod_id
     FROM plch_sales s )  p
WHERE NOT EXISTS
    ( SELECT '1'
      FROM plch_sales s2
      WHERE s2.cust_id = c.cust_id
      AND   s2.prod_id = p.prod_id )
ORDER BY cust_id, prod_id
/

Choice 2

SELECT c.cust_id,
       s.prod_id,
       NVL(SUM(s.quantity),0)   total
FROM plch_sales s  
     PARTITION BY (s.prod_id)
     RIGHT OUTER JOIN  plch_customer  c
  ON ( c.cust_id = s.cust_id )
GROUP BY
       c.cust_id,
       s.prod_id
ORDER BY
       c.cust_id,
       s.prod_id
/

Choice 3

SELECT c.cust_id,
       s.prod_id,
       NVL(SUM(s.quantity),0)   total
FROM plch_sales s  
     PARTITION BY (s.prod_id)
     LEFT OUTER JOIN  plch_customer  c
  ON ( c.cust_id = s.cust_id )
GROUP BY
       c.cust_id,
       s.prod_id
ORDER BY
       c.cust_id,
       s.prod_id
/

Choice 4

SELECT c.cust_id,
       s.prod_id,
       NVL(SUM(s.quantity),0)   total
FROM  plch_customer  c
      LEFT OUTER JOIN plch_sales s  
      PARTITION BY (s.prod_id)
  ON ( c.cust_id = s.cust_id )
GROUP BY
       c.cust_id,
       s.prod_id
ORDER BY
       c.cust_id,
       s.prod_id
/

Choice 5

SELECT c.cust_id,
       p.prod_id,
       NVL(SUM(s.quantity),0)  total
FROM
       plch_customer  c
       CROSS JOIN plch_product  p
       LEFT OUTER JOIN plch_sales  s
       ON (    s.cust_id = c.cust_id
           AND s.prod_id = p.prod_id
          )
GROUP BY
      c.cust_id,
      p.prod_id
ORDER BY
      c.cust_id,
      p.prod_id
/

Choice 6

SELECT s.cust_id,     
       p.prod_id,
       NVL(SUM(s.quantity),0)  total
FROM
      plch_product  p
      LEFT OUTER JOIN plch_sales  s
      ON ( s.prod_id = p.prod_id )
GROUP BY
      s.cust_id,
      p.prod_id
ORDER BY
      s.cust_id,
      p.prod_id
/

Choice 7

SELECT c.cust_id,     
       s.prod_id,
       NVL(SUM(s.quantity),0)  total
FROM
      plch_customer  c
      LEFT OUTER JOIN plch_sales  s
      ON ( s.cust_id = c.cust_id )
GROUP BY
      c.cust_id,
      s.prod_id
ORDER BY
      c.cust_id,
      s.prod_id
/

Choice 8

SELECT c.cust_id,
       p.prod_id,
       NVL(SUM(s.quantity),0)  total
FROM
       plch_customer  c
       CROSS JOIN (SELECT DISTINCT prod_id 
                     FROM plch_sales)  p
       LEFT OUTER JOIN plch_sales  s
       ON (    s.cust_id = c.cust_id
           AND s.prod_id = p.prod_id
          )
GROUP BY
      c.cust_id,
      p.prod_id
ORDER BY
      c.cust_id,
      p.prod_id
/

No choice is correct.



*/