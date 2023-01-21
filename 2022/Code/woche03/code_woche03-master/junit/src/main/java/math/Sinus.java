package math;

import java.math.BigInteger;
import java.util.stream.IntStream;


public class Sinus {

    // Berechnet den Sinus von v mit Hilfe der Maclaurinschen Reihe
    public static double von(double v) {
        double res = 0;
        double folgeglied = 0;
        int n = 0;
        do {
            folgeglied = folgeglied(v, n);
            res += folgeglied;
            n++;
        } while (Math.abs(folgeglied) > 1e-5);
        return res;
    }

    private static double folgeglied(double v, int n) {
        double nenner = fak(2 * n + 1);
        double zaehler = Math.pow(v, 2 * n + 1);
        int vorzeichen = n % 2 == 0 ? 1 : -1;
        return vorzeichen * (zaehler / nenner);
    }


    private static double fak(int n) {
        double res = 1.0;
        for (long i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }


}
