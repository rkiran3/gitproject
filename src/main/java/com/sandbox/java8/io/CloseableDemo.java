package com.sandbox.java8.io;

import java.io.Closeable;
import java.io.IOException;

class ItemCloseable implements Closeable {

  @Override
  public void close() throws IOException {
    System.out.println("ItemCloseable close()");
  }
}

public class CloseableDemo {

  public static void main(String[] args) {

    System.out.println("Start");
//    ItemCloseable ic = new ItemCloseable();
//    try (ic){
//      ic.close();
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }

  }

}
