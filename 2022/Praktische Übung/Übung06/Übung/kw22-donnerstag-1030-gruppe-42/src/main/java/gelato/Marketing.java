package gelato;

import datenbank.Datenbank;
import mail.*;
import wetter.WetterService;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


public class Marketing {

    private static final double CORONA_FACTOR = 0.13;
    public static final int SECHS_STUNDEN = 6 * 3600 * 1000;

    private IMail gmail;

    private Datenbank datenbank;

    private ICreateMarketingMail mailCreator;

    private Marketing(IMail gmail, Datenbank datenbank, ICreateMarketingMail mailCreator) {
        this.gmail = gmail;
        //this.wetter = wetter;
        this.datenbank = datenbank;
        //this.now = now;
        this.mailCreator = mailCreator;
    }

    private void sendMarketingMail(Kunde kunde) {
        datenbank.updateLastMailDate(kunde);
        Mail mail = this.mailCreator.createMail(kunde.getName());
        this.gmail.sendMail(kunde, mail);
    }

    public void doMarketing() {
        List<Kunde> kunden = datenbank.getKunden();
        for (Kunde k : kunden) {
            if (k.isReadyToReceiveMail() && Math.random() < CORONA_FACTOR) {
                sendMarketingMail(k);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        System.out.println("Marketing Start");
        Marketing m = new Marketing(new GMail(), Datenbank.create(), new CreateMarketingMail(new WetterService(), LocalDateTime.now()));
        while (true) {
            System.out.println("Starte Marketing.");
            m.doMarketing();
            System.out.println("Fertig! Schlafe für 6 Stunden");
            Thread.sleep(SECHS_STUNDEN);
        }
    }

}
