package de.propra.woche01.datenstrukturen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListenBeispiel {

  public static void main(String[] args) {

    List<Integer> ints = init(); // Eine Liste mit irgendwelchen Werten erzeugen
    System.out.println(ints);
    ints.add(1, 6); // füge an Position 1 den Wert 6 ein
    System.out.println(ints);

    List<Integer> numbers = List.of(2,3,4,5,6,7,8,9,16);
    System.out.println(numbers); // => [2, 3, 4, 5, 6, 7, 8, 9, 16]

//    numbers.add(23); // => Exception java.lang.UnsupportedOperationException


  }

  private static List<Integer> init() {
    Random random = new Random();
    ArrayList<Integer> elemente = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      elemente.add(random.nextInt(1000));
    }
    return elemente;
  }

}
