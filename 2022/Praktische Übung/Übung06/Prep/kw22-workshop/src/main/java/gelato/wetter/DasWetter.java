package gelato.wetter;

public interface DasWetter {
    //    public Wetter(String daten);
    public boolean istHeiss();
    public boolean istKalt();
    public boolean istTrocken();
    public boolean istNass();
    public DasWetter wetterDaten();
}
