package odyssee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Odyssee {


  public List<Eintrag> parseEintragListe(Stream<String> lines) {

    // Hier kommt der Code zur Erzeugung der Einträge aus dem Zeilen-Stream rein
    // Verwenden Sie collect in Kombination mit einem EintragSammler-Objekt

    return lines.collect(EintragSammler::new, EintragSammler::reduce, EintragSammler::join).eintraege;
  }

  public static int  minimumAnswerTime(List<Eintrag> liste){
    OptionalInt minimum = liste.stream().mapToInt(Eintrag::answertime).min();
    return minimum.getAsInt();
  }

  public static int  maximumAnswerTime(List<Eintrag> liste){
    OptionalInt max = liste.stream().mapToInt(Eintrag::answertime).max();
    return max.getAsInt();
  }

  public static double averageAnswerTime(List<Eintrag> liste){
    OptionalDouble average = liste.stream().mapToDouble(Eintrag::answertime).average();
    return average.getAsDouble();
  }

  public static Map<Integer,Integer> histogrammAnswertime(List<Eintrag> liste){
    Map<Integer,Integer> result = liste.stream()
            .collect(Collectors
                    .groupingBy(Eintrag->Eintrag.answertime()-Eintrag.answertime()%100,
                            Collectors.summingInt(e->1)
                    )
            );
    return result;
  }


  public static void main(String[] args) {
    Odyssee odyssee = new Odyssee();
    List<Eintrag> eintraege = odyssee.readFromInputfile("odyssey.txt");

    // Hier rufen Sie die Methoden zur Analsye der Daten auf

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
