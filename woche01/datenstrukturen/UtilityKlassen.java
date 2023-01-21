package de.propra.woche01.datenstrukturen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UtilityKlassen {
  public static void main(String[] args) {
    List<String> liste = new ArrayList<>(List.of("Kartoffeln", "Tomaten", "Wasser", "Brot"));
    System.out.println(liste); // => [Kartoffeln, Tomaten, Wasser, Brot]

    Collections.reverse(liste); // Achtung die Originalliste wird verändert!
    System.out.println(liste); // => [Brot, Wasser, Tomaten, Kartoffeln]

    Collections.sort(liste);
    System.out.println(liste); // => [Brot, Kartoffeln, Tomaten, Wasser]

    Collections.swap(liste, 0, 2);
    System.out.println(liste); // => [Tomaten, Kartoffeln, Brot, Wasser]

    Collections.shuffle(liste);
    System.out.println(liste); // => Die Liste in zufälliger Reihenfolge

    Collections.sort(liste);
    Collections.rotate(liste, 1);
    System.out.println(liste); // => [Wasser, Brot, Kartoffeln, Tomaten]

    Collections.rotate(liste, -2);
    System.out.println(liste); // => [Kartoffeln, Tomaten, Wasser, Brot]

    Collections.fill(liste, "Bier");
    System.out.println(liste); //=> [Bier, Bier, Bier, Bier]
  }
}
