package fruits.noslap;

import fruits.Fruit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private final List<Fruit> fruits = new ArrayList<>();

  public void add(Fruit fruit) {
    fruits.add(fruit);
  }


  private void print() {
    int maxlen = 8;
    for (Fruit fruit : fruits) {
      int length = fruit.getName().length();
      if (length > maxlen) {
        maxlen = length + 1;
      }
    }
    printHeader(maxlen);
    for (Fruit fruit : fruits) {
      System.out.print(fruit.getName());
      int length = fruit.getName().length();
      for (int i = 0; i < maxlen - length; i++) {
        System.out.print(" ");
      }
      System.out.println(fruit.getPrice());
    }
    printFooter();
  }

  private void printHeader(int maxlen) {
    System.out.print("Produkt ");
    for (int i = 0; i < maxlen - 8; i++) {
      System.out.print(" ");
    }
    System.out.println("Preis");
    System.out.println("------------------------------");
  }

  private void printFooter() {
    System.out.println();
    System.out.println(
        "-- Preise Stand: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.add(new Fruit("Birnen", 215));
    main.add(new Fruit("Heidelbeeren", 222));
    main.add(new Fruit("Orangen", 169));
    main.print();

  }


}
