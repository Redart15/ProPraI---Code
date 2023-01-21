package de.propra.woche01.datenstrukturen;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBeispiel {

  public static void main(String[] args) {

    List<String> names = new ArrayList<>();

    System.out.println(names); // => []

    // Ein erstes Element wird eingefügt, Rückgabe ist true, wenn es erfolgreich war
    System.out.println(names.add("Java Mc Javaface")); // => true

    names.add("James Gossling"); // => true (keine Ausgabe)

    // ArrayList zählt intern mit, der Aufruf ist billig!
    System.out.println(names.size()); // => 2

    System.out.println(names); // => [Java Mc Javaface, James Gossling]

    // Einfügen in der Mitte. Das kann teuer werden!
    names.add(1, "Brian Goetz");

    System.out.println(names); // => [Java Mc Javaface, Brian Goetz, James Gossling]

    // Beim Überschreiben bekommen wir den überschriebenen Wert zurück
    System.out.println(names.set(0, "Joshua Bloch")); // => "Java Mc Javaface"

    System.out.println(names); // => [Joshua Bloch, Brian Goetz, James Gossling]

    ArrayList<String> javaleute = new ArrayList<>();

    // Alle Elemente einer Liste in eine andere einfügen
    System.out.println(javaleute.addAll(names)); // => true

    // Alle Elemente entfernen
    names.clear();

    System.out.println(names); // => []
    System.out.println(javaleute); // => [Joshua Bloch, Brian Goetz, James Gossling]

  }

}
