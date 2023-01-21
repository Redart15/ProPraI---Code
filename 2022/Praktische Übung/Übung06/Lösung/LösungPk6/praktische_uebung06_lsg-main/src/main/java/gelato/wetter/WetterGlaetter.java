package gelato.wetter;

public class WetterGlaetter implements WetterDienst{


  private final WetterDienst dienst;

  public WetterGlaetter(WetterDienst dienst) {
    this.dienst = dienst;
  }

  @Override
  public Wetter wetterDaten() {

    return null;
  }

//
//  private Ringspeicher<Wetter> lastValues = new Ringspeicher<>(20);
//
//
//
//
//  public Wetter wetterDaten() {
//    Wetter current = dienst.wetterDaten();
//    lastValues.put(current);
//    return durchschnitt(lastValues);
//  }



}
