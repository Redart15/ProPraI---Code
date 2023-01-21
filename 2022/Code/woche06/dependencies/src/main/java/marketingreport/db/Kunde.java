package marketingreport.db;

public class Kunde {

    private final String name;
    private final String plz;
    private final int alter;


    public Kunde(String name, String plz, int alter) {
        this.name = name;
        this.plz = plz;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public String getPlz() {
        return plz;
    }

    public int getAlter() {
        return alter;
    }
}
