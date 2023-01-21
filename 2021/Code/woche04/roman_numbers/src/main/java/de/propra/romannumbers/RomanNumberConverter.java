package de.propra.romannumbers;

public class RomanNumberConverter {

  private class Symbol {
    final int value;
    final String ziffer;

    private Symbol(int value, String ziffer) {
      this.value = value;
      this.ziffer = ziffer;
    }
  }

  Symbol[] lookup = {
      new Symbol(10,"X"),
      new Symbol(9,"IX"),
      new Symbol(5,"V"),
      new Symbol(4,"IV"),
      new Symbol(1,"I"),
  };

  public String toRomanNumber(final int zahl) {
    int n = zahl;
    String result = "";
    for (Symbol symbol : lookup) {
      while (n >= symbol.value) {
        result += symbol.ziffer;
        n = n - symbol.value;
      }
    }
    return result;
  }
}
