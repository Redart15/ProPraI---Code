package de.propra.woche01.schleifen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForSchleifen {

  public static void main(String[] args) {
    List<Person> studierende = getStudierende();
    // Enhanced For
    for (Person person : studierende) {
      System.out.println(person.getName() + " (" + person.getAlter() + ")");
    }
    System.out.println("==========================================");
    // ForEach
    studierende.forEach(person ->
        System.out.println(person.getName() + " (" + person.getAlter() + ")")
    );
    System.out.println("==========================================");
    // Normale For Schleife
    for (int i = 0; i < studierende.size(); i++) {
      Person person = studierende.get(i);
      System.out.println(
          "Pos. " + (i + 1) + ": " + person.getName() + " (" + person.getAlter() + ")");

    }


  }

  private static List<Person> getStudierende() {
    Random random = new Random();
    String[] vornamen = {"Anton", "Berta", "Cäsar", "Dimitri", "Erol", "Fiona"};
    String[] nachnamen = {"Müller", "Steyer", "Antel", "Yilmaz", "Rossi"};
    ArrayList<Person> studierende = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      String name = vornamen[random.nextInt(vornamen.length)] + " " +
          nachnamen[random.nextInt(nachnamen.length)];
      int alter = random.nextInt(5) + 18;
      studierende.add(new Person(name, alter));
    }
    return studierende;
  }


  static class Person {
    private final String name;
    private final int alter;

    Person(String name, int alter) {
      this.name = name;
      this.alter = alter;
    }

    public String getName() {
      return name;
    }

    public int getAlter() {
      return alter;
    }
  }


}
