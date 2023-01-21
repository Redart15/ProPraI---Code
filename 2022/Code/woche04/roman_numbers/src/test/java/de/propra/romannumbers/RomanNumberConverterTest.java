package de.propra.romannumbers;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanNumberConverterTest {

  @Test
  @DisplayName("Eingabe: 1, Ausgabe: I")
  void test_1(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(1);
    assertThat(romanNumber).isEqualTo("I");
  }
  @Test
  @DisplayName("Eingabe: 2, Ausgabe: II")
  void test_2(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(2);
    assertThat(romanNumber).isEqualTo("II");
  }
  @Test
  @DisplayName("Eingabe: 3, Ausgabe: III")
  void test_3(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(3);
    assertThat(romanNumber).isEqualTo("III");
  }

  @Test
  @DisplayName("Eingabe: 4, Ausgabe: IV")
  void test_4(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(4);
    assertThat(romanNumber).isEqualTo("IV");
  }

  @Test
  @DisplayName("Eingabe: 5, Ausgabe: V")
  void test_5(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(5);
    assertThat(romanNumber).isEqualTo("V");
  }

  @Test
  @DisplayName("Eingabe: 7, Ausgabe: VII")
  void test_6(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(7);
    assertThat(romanNumber).isEqualTo("VII");
  }

  @Test
  @DisplayName("Eingabe: 20, Ausgabe: XX")
  void test_7(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(20);
    assertThat(romanNumber).isEqualTo("XX");
  }

  @Test
  @DisplayName("Eingabe: 9, Ausgabe: IX")
  void test_8(){
    RomanNumberConverter converter = new RomanNumberConverter();
    String romanNumber = converter.toRomanNumber(9);
    assertThat(romanNumber).isEqualTo("IX");
  }


}
