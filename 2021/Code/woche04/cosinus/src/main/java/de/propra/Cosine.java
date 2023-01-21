package de.propra;

public class Cosine {

    /**
     * Berechnet den Cosinus von x mithilfe der Taylor-Entwicklung
     */
    public static double of(double x) {
        // Falls der übergebene Wert positiv ist: Achsensymmetrie ausnutzen
        if (x < 0){
            x = -x;
        }

        // Bilde x mithilfe der Modulofunktion auf das Intervall [0, 2π] ab
        x %= 2 * Math.PI;

        // aktuell betrachteter Term
        double term = 1.0;
        // aktueller Summenwert (n = 0 in der Formel)
        double partialSum  = term;

        // Berechne die Taylor-Entwicklung für die restlichen 10 Terme (n von 1 bis 10)
        for (int n = 1; n <= 10; n++) {
            // (2n)! in Schleife berechnen:
            long factorial = 1; // long, da Ergebnis nicht in int passt
            for(int i = 2; i <= 2*n; i++) {
                factorial *= i;
            }

            // x^2n in Schleife berechnen:
            double powerOfX = 1;
            for(int i=1; i<=2*n; i++) {
                powerOfX *= x;
            }

            // Term für aktuelles n ist x^2n/(2n)!
            term = powerOfX / factorial;

            if (n % 2 == 0) {
                // wenn n gerade: Term wird addiert
                partialSum += term;
            } else {
                // wenn n ungerade: Term wird subtrahiert
                partialSum -= term;
            }
        }

        // Gib das Ergebnis zurück
        return partialSum;
    }
}
