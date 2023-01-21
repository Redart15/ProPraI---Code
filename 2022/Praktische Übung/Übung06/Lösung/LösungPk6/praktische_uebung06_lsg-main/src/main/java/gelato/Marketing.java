package gelato;

import gelato.db.Kunde;
import gelato.db.KundenRepository;
import gelato.external.Kalender;
import gelato.external.Zufall;
import gelato.mailversand.Mail;
import gelato.mailversand.MailVersand;
import gelato.marketing.MarketingCore;
import gelato.wetter.WetterDienst;
import gelato.wetter.WetterDienstImpl;
import java.util.List;

public class Marketing {


  public static final int SECHS_STUNDEN = 6 * 3600 * 1000;
  private final KundenRepository kundenRepository;
  private final MailVersand mailVersand;
  private final MarketingCore marketingCore;
  private final Zufall zufall;


  public Marketing(KundenRepository kundenRepository,
                   MailVersand mailVersand, MarketingCore marketingCore, Zufall zufall) {
    this.kundenRepository = kundenRepository;

    this.mailVersand = mailVersand;
    this.marketingCore = marketingCore;
    this.zufall = zufall;
  }


  public static void main(String[] args) throws InterruptedException {
    System.out.println("Marketing Start");
    KundenRepository repo = KundenRepository.create();
    WetterDienst wetterDienst = new WetterDienstImpl();
    MailVersand mailVersand = new MailVersand();
    Kalender kalender = new Kalender();
    MarketingCore marketingCore = new MarketingCore(wetterDienst, kalender);
    Marketing m = new Marketing(repo, mailVersand, marketingCore, new Zufall());
    m.doMarketing();
  }

  private void doMarketing() throws InterruptedException {
    while (true) {
      System.out.println("Starte Marketing.");
      marketingStep();
      Thread.sleep(SECHS_STUNDEN);
    }
  }

  private void marketingStep() {
    List<Kunde> kunden = kundenRepository.getKunden();
    sendMails(kunden);
    System.out.println("Fertig! Schlafe für 6 Stunden");
  }

  void sendMails(List<Kunde> kunden) {
    for (Kunde k : kunden) {
      if (k.isReadyToReceiveMail() && zufall.isChosenForMail()) {
        sendMail(k);
      }
    }
  }


  void sendMail(Kunde k) {
    kundenRepository.updateLastMailDate(k);
    Mail mail = marketingCore.createMail(k.getName());
    mailVersand.sendMail(mail, k);
  }

}
