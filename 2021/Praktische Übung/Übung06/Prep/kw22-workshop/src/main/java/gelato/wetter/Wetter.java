package gelato.wetter;

public class Wetter implements DasWetter {

    private final int temperatur;
    private final int regenwahrscheinlichkeit;

    public Wetter(String daten) {
        String[] split = daten.split(" ");
        temperatur = Integer.parseInt(split[0]);
        regenwahrscheinlichkeit = Integer.parseInt(split[1]);
    }

    public boolean istHeiss() {
        return temperatur >= 29;
    }

    public boolean istKalt() {
        return temperatur < 15;
    }

    public boolean istTrocken() {
        return regenwahrscheinlichkeit < 30;
    }

    public boolean istNass() {
        return regenwahrscheinlichkeit > 80;
    }



}
