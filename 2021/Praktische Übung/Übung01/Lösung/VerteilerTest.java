import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VerteilerTest {

  private static List<String> mkPerson(String prefix, int n) {
    return IntStream.range(0, n).mapToObj(i -> prefix + i).collect(Collectors.toList());
  }

  private static void check(int member, int gruppen, int min, int max, int expectedGruppen) {
    Verteiler<String,String> verteiler = new Verteiler<>();
    Map<String, List<String>> verteilung =
        verteiler.verteilen(mkPerson("s", member), mkPerson("t", gruppen), min, max);

    if (expectedGruppen != verteilung.size()) {
      System.out.println("Anzahl der Gruppen ist falsch");
    }
    else {
      int sum = verteilung.values().stream().mapToInt(e -> e.size()).sum();
      if (sum != member) {
        System.out.println("Nicht alle " + member + " Personen zugeordnet. Zugeordnet: " + sum);
      }
      else {
        System.out.println("OK");
      }
    }
    System.out.println(verteilung);
  }


  public static void main(String[] args) {
    check(3, 2, 4, 6, 1);
    check(6, 2, 4, 6, 1);
    check(3, 2, 2, 4, 1);
    check(7, 2, 4, 6, 2);
    check(8, 2, 4, 6, 2);
    check(8, 2, 5, 6, 2);
    check(5, 2, 3, 4, 2);
    check(12, 3, 3, 5, 3);
    check(12, 3, 3, 6, 2);
  }




}