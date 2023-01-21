package marketingreport.summary;

import marketingreport.db.Kunde;

import java.util.ArrayList;
import java.util.List;

public class CountingSummarizer {

    private final AgeSegmentation segmenter;

    public CountingSummarizer() {
        this.segmenter = new AgeSegmentation();
    }

    

    public List<Summary> getSummaries(List<Kunde> kunden) {
        // ...
        List<Summary> summaries = new ArrayList<>();
        for (Segment segment : segmenter.getSegments(kunden)) {
            summaries.add(summarize(segment));
        }
        return summaries;
    }

    private Summary summarize(Segment segment) {
        // ...
        return new Summary(segment.getName(),segment.getKunden().size());
    }

}


