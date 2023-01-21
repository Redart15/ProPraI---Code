package assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsAufgaben {


  @Nested
  class ZahlenAssertions {

    private static double pi() {
      double result = 0.0;
      for (int i = 0; i < 1000; i++) {
        double sign = Math.pow(-1, i);
        double summand = 1.0 / (i * 2 + 1);
        result += sign * summand;
      }
      return result * 4;
    }

    @Test
    @DisplayName("Die Zahl ist nicht negativ ")
    void test_1(){
      int n = 6;
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die Zahl ist gerade")
    void test_2(){
      int n = 18;
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die pi() Methode berechnet π auf zwei Nachkommastellen genau")
    void test_3() {
      double pi = pi();
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

  }

  @Nested
  class StringAssertions {

    @Test
    @DisplayName("Der Satz enthält das Wort FAILURE")
    void test_1(){
      String wort = "FAILURE";
      String satz = "Testing leads to failure, and failure leads to understanding. (Burt Rutan)";
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Das Wort ungenau hat zwischen 6 und 8 Buchstaben")
    void test_2(){
      String wort = "ungenau";
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Der String besteht nur aus Whitespaces")
    void test_(){
      String wort = "  \t   \t\n  ";
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

  }


  @Nested
  class ListenAssertions {

    List<Integer> liste;

    @BeforeEach
    void setup() {
      liste = new ArrayList<>(List.of(7, 3, 5, 11, 3, 7, 9));
    }

    @Test
    @DisplayName("Die Liste hat 7 Elemente")
    void test_1() {
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die Liste enthält nach dem Sortieren die Elemente 3,3,5,7,7,9,11 in genau dieser Reihenfolge")
    void test_2() {
      Collections.sort(liste);
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die Liste enthält die Elemente 3,3,5,7,7,9,11 in einer beliebigen Reihenfolge")
    void test_3() {
      Collections.shuffle(liste);
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die Liste enthält mindestens die Elemente 3,5,7,9,11")
    void test_5() {
      // Schreiben Sie die passende Assertion
      assertThat(true).isFalse();
    }

    @Test
    @DisplayName("Die Liste enthält nur ungerade Zahlen")
    void test_6() {
      // Schreiben Sie die passende Assertion
      // Achtung! Schreiben Sie eine einige Assertion, keine Schleife o.Ä.
      assertThat(true).isFalse();
    }

  }


}
