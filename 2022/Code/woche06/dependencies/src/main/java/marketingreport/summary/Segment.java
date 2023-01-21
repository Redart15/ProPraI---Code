package marketingreport.summary;

import marketingreport.db.Kunde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Segment {


    private String name;
    private List<Kunde> kunden = new ArrayList<>();

    public Segment(String name) {
        this.name = name;
    }

    public void add(Kunde k) {
        kunden.add(k);
    }

    public List<Kunde> getKunden() {
        return Collections.unmodifiableList(kunden);
    }

    public String getName() {
        return name;
    }
}
