package wrongfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rechnung {

  private final List<Position> positionen = new ArrayList<>();
  private Produkt tempProduct;

  public Rechnung(Position... positionen) {
    this.positionen.addAll(Arrays.asList(positionen));
  }

  public int rechnungsBetrag() {
    int summe = 0;
    for (Position position : positionen) {
      tempProduct = position.getProdukt();
      summe += position.getAnzahl() * tempProduct.getPreis();
    }
    return summe;
  }

}
