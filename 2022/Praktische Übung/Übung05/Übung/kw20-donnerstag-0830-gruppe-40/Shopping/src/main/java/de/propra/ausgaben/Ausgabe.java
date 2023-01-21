package de.propra.ausgaben;

class Ausgabe {

  private final String geschaeft;
  private final String kategorie;
  private final double betrag;

  public Ausgabe(String geschaeft, String kategorie, double betrag) {
    this.geschaeft = geschaeft;
    this.kategorie = kategorie;
    this.betrag = betrag;
  }

  public String getGeschaeft() {
    return geschaeft;
  }

  public String getKategorie() {
    return kategorie;
  }

  public double getBetrag() {
    return betrag;
  }
}
