package marketingreport.reporting;

import marketingreport.summary.Summary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

// Die Klasse produziert ein PDF File ausgehend von einer Liste von Summary Objekten.
// Die Details sind nicht wichtig
public class PDFGenerator {

    private String file;

    public PDFGenerator(String file) {
        this.file = file;
    }

    public void print(List<Summary> summaries) {
        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 35.0);
            contentStream.beginText();
            contentStream.setLeading(20f);
            contentStream.newLineAtOffset(25, 725);
            contentStream.showText("Marketing Report nach Segmentierung");
            contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 16.0);
            contentStream.newLine();
            for (Summary summary : summaries) {
                contentStream.showText(summary.getText());
                contentStream.newLine();
            }
            contentStream.endText();
            contentStream.close();
            document.save(file);
            document.close();
        } catch (IOException e) {
            System.err.println("Beim Erzeugen des Dokuments ist etwas fehlgeschlagen: "+ e.getMessage());
        }
    }

}
