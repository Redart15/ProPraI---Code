package de.propra.woche01.datenstrukturen;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetBeispiel {


  public static void main(String[] args) {
    Set<Integer> ints1 = new HashSet<>();
    ints1.addAll(List.of(3,4,5,6,7,8,9,16));
    System.out.println(ints1); // =>  [16, 3, 4, 5, 6, 7, 8, 9]

    // Natürliche Sortierreihenfolge (definiert durch den Datentyp)
    Set<Integer> ints2 = new TreeSet<>();
    ints2.addAll(List.of(7,6,4,9,3,8,16,5));
    System.out.println(ints2); // =>  [3, 4, 5, 6, 7, 8, 9, 16]

    // Eigene Sortierreihenfolge überschreibt die natürliche Reihenfolge
    Set<Integer> ints3 = new TreeSet<>(evenFirstComparator);
    ints3.addAll(List.of(7, 6, 4, 9, 3, 8, 16, 5));
    System.out.println(ints3); // => [4, 6, 8, 16, 3, 5, 7, 9]
    ints3.add(10);
    System.out.println(ints3); // => [4, 6, 8, 10, 16, 3, 5, 7, 9]
    ints3.add(13);
    System.out.println(ints3); // => [4, 6, 8, 10, 16, 3, 5, 7, 9, 13]

  }


  static Comparator<Integer> evenFirstComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      if (o1 % 2 == o2 % 2) {
        return o1.compareTo(o2);
      }
      if (o1 % 2 == 0) return -1;
      else return 1;
    };
  };



}
