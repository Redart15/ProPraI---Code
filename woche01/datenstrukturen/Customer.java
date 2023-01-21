package de.propra.woche01.datenstrukturen;

import java.util.HashMap;
import java.util.Map;

class Customer {

  private final String name;

  private Customer(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  public static Customer customer(String name) {
    return new Customer(name);
  }

  public static void main(String[] args) {
    Map<Integer, Customer> customers = new HashMap<>();

    customers.put(1, customer("Bill Gates"));
    customers.put(3, customer("Jeff Bezos"));
    customers.put(2, customer("Elon Musk"));

    System.out.println(customers); // => {1=Bill Gates, 2=Elon Musk, 3=Jeff Bezos}

    System.out.println(customers.get(2)); // => Elon Musk
    System.out.println(customers.get(4)); // => null

    System.out.println(customers.getOrDefault(2, customer("Arno Nym"))); // => Elon Musk
    System.out.println(customers.getOrDefault(4, customer("Arno Nym"))); // => Arno Nym

    customers.putIfAbsent(3, customer("Karl Albrecht"));
    System.out.println(customers.values()); // => [Bill Gates, Elon Musk, Jeff Bezos]

    customers.put(3, customer("Karl Albrecht")); // => [Bill Gates, Elon Musk, Karl Albrecht]
    System.out.println(customers.values());

    customers.remove(2);
    System.out.println(customers); // => {1=Bill Gates, 3=Karl Albrecht}

    customers.put(16, customer("Warren Buffett "));
    System.out.println(customers); // => {16=Warren Buffett , 1=Bill Gates, 3=Karl Albrecht}
  }
}