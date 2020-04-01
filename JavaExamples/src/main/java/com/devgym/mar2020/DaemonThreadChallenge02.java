package com.devgym.mar2020;

import java.util.Date;

public class DaemonThreadChallenge02 implements Runnable {

    public static void main(String... doYourBest) {
       Thread thread = new Thread(new DaemonThreadChallenge());
       thread.setDaemon(true);
       thread.start();
    }

    @Override
    public void run() {
       for (;;) {
          System.out.println("For ever");
          System.out.println(new Date());
       }
    }
}
/*
Answer1:
	will throw StackOverflowError because of infinite looping.
	
2:
	It will print "For ever" infinitely.

3: <-- Correct Answer
	It will print "For ever" for an indeterminate time and program will be normally finished.
	
	
	
Summary

There are two types of threads in Java: non-daemon: the main method is executed with a 
non-daemon thread behind the scenes and this thread will be executed until the end. 
daemon: it will die if all non-daemon threads have finished.

Background

The amount of time that "Forever" will be printed is indeterminate 
because it will depend on the time from the main thread execution.

There are two types of threads:

Non-daemon: the main method is executed with a non-daemon thread behind the scenes and this thread will be executed until the end.
Daemon: it will die if all non-daemon threads have finished.

So in this quiz, if the main method is finished, the daemon thread we created will be 
finished as well because all daemon threads depend on a non-daemon thread to continue its execution.

*/