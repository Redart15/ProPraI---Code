package marketingreport.summary;

import marketingreport.db.Kunde;

import java.util.List;


public class AgeSegmentation {


    // Segmentierung der Kunden nach Alter
    public Segment[] getSegments(List<Kunde> kunden) {
        Segment zuJung = new Segment("Zu jung");
        Segment zielgruppe = new Segment("Zielgruppe");
        Segment zuAlt = new Segment("Zu alt");

        for (Kunde k : kunden) {
            if (k.getAlter() <= 25) {
                zuJung.add(k);
            }
            else if (k.getAlter() >= 65) {
                zuAlt.add(k);
            }
            else {
                zielgruppe.add(k);
            }
        }

        return new Segment[]{zuJung, zielgruppe, zuAlt};
    }
}



