package violated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rechnung {

  private final List<Position> positionen = new ArrayList<>();

  public Rechnung(Position... positionen) {
    this.positionen.addAll(Arrays.asList(positionen));
  }

  public int rechnungsBetrag() {
    int summe = 0;
    for (Position position : positionen) {
      summe += position.getAnzahl() * position.getProdukt().getPreis();
    }
    return summe;
  }

}
