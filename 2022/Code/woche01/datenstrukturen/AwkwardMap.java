package de.propra.woche01.datenstrukturen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AwkwardMap {

  private final HashMap<String, Set<String>> zuordnung = new HashMap<>();

  public void add(String termin, String githubHandle) {
    Set<String> handles = zuordnung.getOrDefault(termin, new HashSet<>());
    handles.add(githubHandle);
  }

  public static void main(String[] args) {
    // Experimentieren Sie mit der Klasse.
    // Versuchen Sie den Fehler zu finden, indem Sie Elemente einfügen
    // und prüfen, wie die Map aussieht
  }

}