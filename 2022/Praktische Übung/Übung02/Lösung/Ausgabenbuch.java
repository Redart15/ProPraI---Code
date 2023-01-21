package de.propra.ausgaben;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Ausgabenbuch {

  private final Scanner stdin = new Scanner(System.in);

  private final Map<String, Double> shop = new HashMap<>();
  private final Map<String, Double> category = new HashMap<>();

  private void report(String[] parts) {
    // Prüfen: parts hat 2 Elemente
    // 0 ist "report", 1 ist entweder "category" oder "shop"
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden

    if (parts.length != 2) {
      invalid();
      return;
    }

    switch (parts[1]) {
      case "category":
        printReport(category);
        break;
      case "shop":
        printReport(shop);
        break;
      default:
        invalid();
    }
  }

  private void printReport(Map<String, Double> store) {
    SortedSet<String> keys = new TreeSet<>(store.keySet());
    keys.forEach(k -> printAusgabe(k, store.get(k)));
  }

  private void printAusgabe(String name, Double betrag) {
    System.out.printf("%s: %.2f%n", name, betrag);
  }


  private void add(String[] parts) {
    // Prüfen: parts hat 4 Elemente
    // 0 ist "add", 1 (shop) und 2 (category) sind Strings
    // 3 ist ein String, in dem ein Double Wert steht
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden

    if (parts.length != 4) {
      invalid();
      return;
    }

    try {
      double ausgabe = Double.parseDouble(parts[3]);
      addToStore(ausgabe, parts[1], shop);
      addToStore(ausgabe, parts[2], category);
      System.out.printf("Hinzugefügt zum Shop %s in der Kategorie %s: %.2f%n", parts[1], parts[2],
          ausgabe);
    } catch (NumberFormatException nfe) {
      invalid();
      return;
    }


  }

  private void addToStore(double ausgabe, String entry, Map<String, Double> store) {
    Double alterBetrag = store.getOrDefault(entry, 0.0);
    double betrag = alterBetrag + ausgabe;
    store.put(entry, betrag);
  }


  private void exit() {
    System.out.println("Bye.");
  }

  public void run() {
    System.out.println("Ausgabenbuch ist bereit für die Eingaben");
    // Hier muss in geeigneter Weise readAndProcess aufgerufen werden
    boolean keepRunning = false;
    do {
      keepRunning = readAndProcess();
    } while (keepRunning);
  }


  /**
   * Diese Methode soll aufgerufen werden, wenn es einen Fehler bei den Parametern gibt
   */
  private void invalid() {
    System.out.println("Ungültige Eingabe.");
  }


  /**
   * Liest eine Zeile von der Eingabeaufforderung
   * Ruft je nach erstem Wort die passende Methode auf
   * @return Die Methode gibt true zurück, wenn das Programm
   * nach der Verarbeitung des Kommandos weiterlaufen soll
   */
  private boolean readAndProcess() {
    String line;
    line = stdin.nextLine();
    String[] parts = line.split(" ");
    switch (parts[0]) {
      case "add": {
        add(parts);
        return true;
      }
      case "report": {
        report(parts);
        return true;
      }
      case "exit": {
        exit();
        return false;
      }
      default: {
        invalid();
        return true;
      }
    }
  }

  public static void main(String[] args) {
    Ausgabenbuch ausgabenbuch = new Ausgabenbuch();
    ausgabenbuch.run();
  }

}
