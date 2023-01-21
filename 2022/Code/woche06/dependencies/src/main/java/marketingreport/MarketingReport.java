package marketingreport;

import marketingreport.db.Kunde;
import marketingreport.db.KundenRepository;
import marketingreport.reporting.PDFGenerator;
import marketingreport.summary.CountingSummarizer;
import marketingreport.summary.Summary;

import java.util.List;

public class MarketingReport {

    private KundenRepository kundenRepository = new KundenRepository();
    private CountingSummarizer summarizer = new CountingSummarizer();
    private PDFGenerator pdf = new PDFGenerator("marketingreport.pdf");

    private void print() {
        List<Kunde> kunden = kundenRepository.getAlleKunden();
        List<Summary> summaries = summarizer.getSummaries(kunden);
        pdf.print(summaries);
    }

    public static void main(String[] args) {
        MarketingReport marketingReport = new MarketingReport();
        marketingReport.print();
    }

}
