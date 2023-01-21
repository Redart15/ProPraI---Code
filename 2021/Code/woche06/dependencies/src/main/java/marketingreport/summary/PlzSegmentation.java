package marketingreport.summary;

import marketingreport.db.Kunde;

import java.util.List;

public class PlzSegmentation {

    public Segment[] getSegments(List<Kunde> kunden) {
        Segment norden = new Segment("Norden");
        Segment sueden = new Segment("Süden");

        // Segmentierung der Kunden nach Postleitzahl
        for (Kunde k : kunden) {
            String firstDigit = k.getPlz().substring(0, 1);
            if ("1234".contains(firstDigit)) {
                norden.add(k);
            }
            else if ("6789".contains(firstDigit)) {
                sueden.add(k);
            }
            else if (k.getPlz().startsWith("54") || k.getPlz().startsWith("55")) {
                sueden.add(k);
            }
            else {
                norden.add(k);
            }
        }

        return new Segment[]{norden, sueden};
    }


}
