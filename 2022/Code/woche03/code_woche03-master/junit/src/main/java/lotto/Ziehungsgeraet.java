package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ziehungsgeraet {

  public static List<Integer> lottoZahlenZiehen() {
    ArrayList<Integer> auswahl =
        IntStream.rangeClosed(1, 49)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    Collections.shuffle(auswahl);
    return auswahl.stream()
        .limit(6)
        .sorted()
        .collect(Collectors.toList());
  }


}
