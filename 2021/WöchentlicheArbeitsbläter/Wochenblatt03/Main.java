import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {

  private Scanner in = new Scanner(System.in);
  private HashMap<String, Double> shop = new HashMap<>();
  private HashMap<String, Double> kategorie = new HashMap<>();

  /*public Main(){
    HashMap<String,String> shops = new HashMap<>();
    HashMap<String, Double> kategore = new HashMap<>()
  } */
  // FIXME: Diese Methode implementieren
  private void details(String[] parts) {
    // Prüfen: parts hat 2 Elemente
    if (parts.length != 2|| shop.get(parts[1].Equals(null))) invalid();
    // 0 ist "details", 1 ist der Shopname
    for(String Shop: shop.keySet()){
        System.out.println(Shop + ": " + shop.get(Shop));
        }
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden
  }

  // FIXME: Diese Methode implementieren
  private void report(String[] parts) {
    int summe = 0;
    // Prüfen: parts hat 2 Elemente
    if (parts.length != 2) invalid();
    // 0 ist "report", 1 ist entweder "category" oder "shop"
    if(parts[1].equals("shop")){
        for(String Shop: shop){
            summe = 0;
            for(String Shop0: shop.keySet()){
                summe+= shop.get(Shop0);
            }
        System.out.println(Shop + ": " + summe);
        }
    } else if(parts[1].equals("category")){
        for(String Kategorie: kategorie.key){
            summe = 0;
            for(String Kategorie0: kategorie.keySet()){
                summe+= kategore.get(Kategorie0);
            }
        System.out.println(Kategorie + ": " + summe);
        }
    }else invalid();
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden
  }

  // FIXME: Diese Methode implementieren
  private void add(String[] parts) {
    // Prüfen: parts hat 4 Elemente
    if (parts.length != 4) invalid();
    // 0 ist "add", 1 und 2 sind String, 3 ist ein String, in dem ein Double Wert steht
    shop.putIfAbsent(parts[1], Double.parseDouble(parts[3]));
    kategorie.putIfAbsent(parts[2], Double.parseDouble(parts[3]));
    // Bei Fehlern invalid() aufrufen und die Methode mit return beenden
  }
  
  // FIXME: Diese Methode implementieren
  private void exit() {
    System.out.println("Bye.");
  }

  // FIXME: Diese Methode implementieren
  public void run() {
    // Hier muss in geeigneter Weise readAndProcess aufgerufen werden
    readAndProcess();
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
    line = in.nextLine();
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
      case "details": {
        details(parts);
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
    Main main = new Main();
    main.run();
  }

}
