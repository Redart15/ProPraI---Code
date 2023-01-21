package de.propra.ausgaben;

import static java.lang.String.format;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Ausgabenbuch {

  private final Scanner stdin = new Scanner(System.in);

  private final List<Ausgabe> ausgaben = new ArrayList<>();
  private Output out;

  public Ausgabenbuch(Output out) {
    this.out = out;
  }


  void report(String[] parts) {

    if (parts.length != 2 && parts.length != 3) {
      invalid();
      return;
    }

    switch (parts[1]) {
      case "category":
        printReport(ausgaben, Ausgabe::getKategorie);
        break;
      case "shop":
        printReport(ausgaben, Ausgabe::getGeschaeft);
        break;
      case "details":
        printDetailReport(parts[2]); // index 2 out of bounds
        break;
      default:
        invalid();
    }
  }

  void printDetailReport(String geschaeft) {
    printReport(ausgaben.stream()
                        .filter(a -> a.getGeschaeft().equals(geschaeft))
                        .toList(),
                         Ausgabe::getGeschaeft);
  }

  void printReport(List<Ausgabe> ausgaben, Function<Ausgabe, String> groupingFunction) {
    Map<String, Double> report = ausgaben.stream().collect(groupingBy(groupingFunction
        , summingDouble(Ausgabe::getBetrag)));
    report.forEach(this::printAusgabe);
  }

  void printAusgabe(String name, Double betrag) {
    out.println(format("%s: %.2f", name, betrag));
  }

  void add(String[] parts) {
    if (parts.length != 4) {
      invalid();
      return;
    }

    try {
      double betrag = Double.parseDouble(parts[3]);
      Ausgabe ausgabe = new Ausgabe(parts[1], parts[2], betrag);
      ausgaben.add(ausgabe);
      out.println(
          format("Hinzugefuegt zum Shop %s in der Kategorie %s: %.2f%n", parts[1], parts[2],
              betrag));
    } catch (NumberFormatException nfe) {
      invalid();
      return;
    }
  }

  void exit() {
    out.println("Bye.");
  }

  void run() {
    out.println("Ausgabenbuch ist bereit für die Eingaben");
    boolean keepRunning = false;
    do {
      keepRunning = readAndProcess();
    } while (keepRunning);
  }

  void invalid() {
    out.println("Ungültige Eingabe.");
  }

  boolean readAndProcess() {
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
    Ausgabenbuch ausgabenbuch = new Ausgabenbuch(new KonsoleOutput());
    ausgabenbuch.run();
  }

}
