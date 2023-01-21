package violated;

public class Position {

  private final int anzahl;
  private final Produkt produkt;

  public Position(int anzahl, Produkt produkt) {
    this.anzahl = anzahl;
    this.produkt = produkt;
  }

  public int getAnzahl() {
    return anzahl;
  }

  public Produkt getProdukt() {
    return produkt;
  }
}
