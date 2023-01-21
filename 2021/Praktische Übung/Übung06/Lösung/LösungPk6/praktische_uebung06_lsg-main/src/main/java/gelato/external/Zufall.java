package gelato.external;

public class Zufall {

  private static final double CORONA_FACTOR = 0.13;

  private double wert() {
    return Math.random();
  }

  public boolean isChosenForMail() {
    return wert() < CORONA_FACTOR;
  }
}
