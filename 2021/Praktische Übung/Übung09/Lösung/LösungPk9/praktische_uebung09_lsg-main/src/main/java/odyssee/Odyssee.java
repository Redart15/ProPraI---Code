package odyssee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Odyssee {

  private List<Eintrag> parseEintragListe(Stream<String> lines) {
    // Hier kommt der Code zur Erzeugung der Einträge aus dem Zeilen-Stream rein
    // Verwenden Sie collect in Kombination mit einem EintragSammler-Objekt
    return lines.collect(EintragSammler::new, EintragSammler::reduce, EintragSammler::join).eintraege;
  }

  public static void main(String[] args) {
    Odyssee odyssee = new Odyssee();
    List<Eintrag> eintraege = odyssee.readFromInputfile("odyssey.txt");

    // Hier rufen Sie die Methoden zur Analyse der Daten auf
    System.out.println(minimaleAntwortzeit(eintraege));
    System.out.println(maximaleAntwortzeit(eintraege));
    System.out.println(mittlereAntwortzeit(eintraege));
    System.out.println(histogramm(eintraege));
    System.out.println(mittlereAntwortzeitProWochentag(eintraege));
    System.out.println(mittlereAntwortzeitProStunde(eintraege));
    System.out.println(entwicklungUeberZeit(eintraege, DayOfWeek.MONDAY, 10));
    System.out.println(mittlereVerfuegbarkeit(eintraege));
  }

  static int minimaleAntwortzeit(List<Eintrag> eintraege) {
    return eintraege.stream()
            .mapToInt(Eintrag::answertime)
            .min()
            .orElse(0);
  }

  static int maximaleAntwortzeit(List<Eintrag> eintraege) {
    return eintraege.stream()
            .mapToInt(Eintrag::answertime)
            .max()
            .orElse(0);
  }

  static double mittlereAntwortzeit(List<Eintrag> eintraege) {
    return eintraege.stream()
            .mapToInt(Eintrag::answertime)
            .average()
            .orElse(0);
  }

  public static Map<Integer, Integer> histogramm(List<Eintrag> eintraege) {
    return eintraege.stream().collect(
            Collectors.groupingBy(e -> e.answertime() / 100 * 100,
                                  Collectors.summingInt(e -> 1))); // Collectors.counting gibt nicht den Typen, den Jens haben möchte ...
  }

  public static Map<DayOfWeek, Double> mittlereAntwortzeitProWochentag(List<Eintrag> eintraege) {
    return eintraege.stream()
            .collect(Collectors.groupingBy(e -> e.time().getDayOfWeek(),
                                           Collectors.averagingDouble(Eintrag::answertime)));
  }

  public static Map<Integer, Double> mittlereAntwortzeitProStunde(List<Eintrag> eintraege) {
    return eintraege.stream()
            .collect(Collectors.groupingBy(e -> e.time().getHour(),
                     Collectors.averagingDouble(Eintrag::answertime)));
  }

  public static Map<Integer, Double> entwicklungUeberZeit(List<Eintrag> eintraege, DayOfWeek day, int hour) {
    return eintraege.stream()
            .filter(e -> e.time().getDayOfWeek() == day)
            .filter(e -> e.time().getHour() == hour)
            .collect(Collectors.groupingBy(e -> e.time().get(WeekFields.ISO.weekOfYear()),
                                           Collectors.averagingDouble(Eintrag::answertime)));
  }

  public static double mittlereVerfuegbarkeit(List<Eintrag> eintraege) {
    return eintraege.stream()
            .mapToInt(e -> e.answertime() <= 10_000 ? 1 : 0)
            .average()
            .orElse(0);
  }

  // Das kann so bleiben
  private List<Eintrag> readFromInputfile(String name) {
    Path inputfile = Path.of(name);
    try (Stream<String> lines = Files.lines(inputfile)) {
      return parseEintragListe(lines);
    } catch (IOException e) {
      throw new RuntimeException("Could not read file: " + name);
    }
  }


}
