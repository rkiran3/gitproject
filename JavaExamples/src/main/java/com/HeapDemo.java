package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HeapDemo {
	static BlockingQueue<byte[]> queue = new LinkedBlockingQueue<>();

	  public static void main(String[] args) {
	
	    new Thread(new Consumer()).start();
	    new Thread(new Producer()).start();
	  }

	  static class Producer implements Runnable {

	    public void run() {
	      while (true) {
	        queue.offer(new byte[3 * 1024 * 1024]);

	        try {
	          Thread.sleep(50);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
	    }

	  }

	  static class Consumer implements Runnable {
	    public void run() {
	      while (true) {
	        try {
	          queue.take();
	          Thread.sleep(10000);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	  }}
