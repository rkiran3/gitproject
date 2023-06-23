package com.devgym.apr2020;

/*I create this class.*/

import java.io.Closeable;

public class ExceptionCloseChallenge{
    public static void main(String... doYourBest) {
        //String soprano = null;

        //CloseIt closeIt = new CloseIt();

        /*try(closeIt) {
            System.out.println(soprano.matches(null));
        } catch (RuntimeException r) {
           try (closeIt) {
               System.out.println("runtime");

               throw new StackOverflowError();
           } catch (Exception e) {
               System.out.println("exception");
           }
        } catch (Error exception) {
            System.out.println("error");
        } catch (Throwable throwable) {
            System.out.println("throwable");
        }*/
    }
    static class CloseIt implements Closeable {

        public void close() {
            System.out.println("close");
        }
    }
}
/*
What will happen after the main method is executed as follows?

javac ExceptionChallenge2.java
java ExceptionChallenge2

Choices - Select all that apply.
Choice 1
close
runtime
close
error

Choice 2
runtime
close
exception
close

Choice 3
close
runtime
StackOverflowError will be thrown
close

Choice 4
runtime
exception
close
close

*/