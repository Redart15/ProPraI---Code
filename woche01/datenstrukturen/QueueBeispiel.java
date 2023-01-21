package de.propra.woche01.datenstrukturen;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBeispiel {

  public static void main(String[] args) {
    Queue<String> q = new LinkedList<>();

    q.offer("a");
    q.offer("b");
    q.offer("c");

    System.out.println(q); // => [a, b, c]
    System.out.println(q.peek()); // => a
    System.out.println(q); // => [a, b, c]
    System.out.println(q.poll()); // => a
    System.out.println(q); // => [b, c]
  }


}
