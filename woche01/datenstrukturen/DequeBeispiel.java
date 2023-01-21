package de.propra.woche01.datenstrukturen;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBeispiel {

  public static void main(String[] args) {
    Deque<String> stack = new LinkedList<>();

    stack.push("x");
    stack.push("y");
    stack.push("z");

    System.out.println(stack); // => [z, y, x]
    System.out.println(stack.peek()); // => z
    System.out.println(stack); // => [z, y, x]
    System.out.println(stack.pop()); // => z
    System.out.println(stack); // => [y, x]
  }

}
