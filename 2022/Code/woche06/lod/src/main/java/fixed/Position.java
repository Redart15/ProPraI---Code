package fixed;

public class Position {

  private final int anzahl;
  private final Produkt produkt;

  public Position(int anzahl, Produkt produkt) {
    this.anzahl = anzahl;
    this.produkt = produkt;
  }

  public int getPreis() {
    int stueckPreis = produkt.getPreis();
    int gesamtPreis = anzahl * stueckPreis;
    return gesamtPreis;

  }
}
