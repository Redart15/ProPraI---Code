package de.propra.ausgaben;

import java.util.*;

public class Ausgabenbuch {

  private final Scanner stdin = new Scanner(System.in);
  private Map<String, List<Double>> shop = new HashMap<>();
  private Map<String, List<Double>> category = new HashMap<>();

  // FIXME: Diese Methode implementieren

  private void list(String[] parts){
    if(parts.length!=2) {
      invalid();
      return;
    }
    if(parts[1].equals("shop")){
      shop.keySet().forEach(key -> System.out.println(key));
      return;
    }
    if(parts[1].equals("category")){
      category.keySet().forEach(key -> System.out.println(key));
      return;
    }
    invalid();
  }


  private void report(String[] parts) {
    // Prüfen: parts hat 2 Elemente
    // 0 ist "report", 1 ist entweder "category" oder "shop"
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden
    if(parts.length!=2){
      invalid();
      return;
    }

    if(parts[1].equals("category")){

      if(category.isEmpty()){
        System.out.println("Noch keine category vorhanden");
        return;
      }

      category.keySet().forEach(key ->
      {double sum = category.get(key).stream().mapToDouble(Double::valueOf).sum();
        System.out.println(key + ": " + sum);
      });
      return;
    }

    if(parts[1].equals("shop")){

      if(shop.isEmpty()){
        System.out.println("Noch keine shops vorhanden");
        return;
      }

      shop.keySet().forEach(key ->
      {double sum = shop.get(key).stream().mapToDouble(Double::valueOf).sum();
        System.out.println(key + ": " + sum);
      });
      return;
    }
    invalid();
  }

  // FIXME: Diese Methode implementieren
  private void add(String[] parts) {
    // Prüfen: parts hat 4 Elemente
    // 0 ist "add", 1 ist der Name des Geschäfts, 2 ist der Name der Kategorie, 3 ist ein String, in dem ein Double Wert steht
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden
    if(parts.length!= 4){
      invalid();
      return;
    }
    if(!shop.containsKey(parts[1])){
        shop.put(parts[1], new ArrayList<Double>());
    }
    shop.get(parts[1]).add(Double.parseDouble(parts[3]));

    if(!category.containsKey(parts[2])){
        category.put(parts[2], new ArrayList<Double>());
    }
    category.get(parts[2]).add(Double.parseDouble(parts[3]));
    System.out.println("Hinzufügen zum Shop " + parts[1] + " in der Kategorie " + parts[2] + ": " + parts[3]);
  }

  // FIXME: Diese Methode implementieren
  private void exit() {
    System.out.println("Bye. ");
  }

  // FIXME: Diese Methode implementieren
  public void run() {
    // Hier muss in geeigneter Weise readAndProcess aufgerufen werden
    System.out.println("Ausgabenbuch ist bereit für die Eingaben");
    while(readAndProcess()){

    }
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

      case "list":{
        list(parts);
        return true;
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
