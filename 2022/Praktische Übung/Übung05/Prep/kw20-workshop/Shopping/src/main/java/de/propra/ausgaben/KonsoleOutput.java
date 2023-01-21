package de.propra.ausgaben;

class KonsoleOutput implements Output {

  @Override
  public void println(String string) {
    System.out.println(string);
  }
}
