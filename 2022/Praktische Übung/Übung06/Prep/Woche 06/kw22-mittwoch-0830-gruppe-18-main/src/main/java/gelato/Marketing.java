package gelato;

import datenbank.DatabaseAD;
import mail.GMail;
import mail.Mail;
import mail.MailText;
import wetter.Wetter;
import wetter.WetterGetter;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class Marketing {

  private static final double CORONA_FACTOR = 0.13;
  public static final int SECHS_STUNDEN = 6 * 3600 * 1000;

  private DatabaseAD database;
  private WetterGetter wettergoetter;
  private GMail gmail;
  private Marketing(DatabaseAD database, WetterGetter wettergoetter, GMail gmail) {
    this.database = database;
    this.wettergoetter = wettergoetter;
    this.gmail = gmail;
  }

  private void sendMarketingMail(Kunde kunde) {
    this.database.updateLastMailDate(kunde);
    this.gmail.sendMail(kunde, createMail(kunde.getName(), LocalDateTime.now()));
  }

  private Mail createMail(String name, LocalDateTime time) {
    Wetter wetter = this.wettergoetter.wetterDaten();
    DayOfWeek tag = time.getDayOfWeek();
    boolean frueh = time.getHour() > 6 && time.getHour() < 10;

    // Wetter Logic
    if (wetter.istHeiss() && wetter.istTrocken()) {
      if (frueh) {
        return MailText.granita(name);
      }
      return MailText.gelato(name);
    }
    else if (wetter.istKalt()) {
      return MailText.waffelnUndKaffee(name);
    }
    else {
      if (tag.equals(SATURDAY) || tag.equals(SUNDAY)) {
        return MailText.zuppaInglese(name);
      }
      if (tag.equals(MONDAY) || tag.equals(WEDNESDAY)) {
        return MailText.cassata(name);
      }
      if (tag.equals(TUESDAY) || tag.equals(THURSDAY)) {
        return MailText.tiramisu(name);
      }
      if (tag.equals(FRIDAY)) {
        return MailText.pannaCotta(name);
      }
    }
    return new Mail("", "");
  }

  private void steuerungAltM() {
    List<Kunde> kunden = database.getKunden();
    for (Kunde k : kunden) {
      if (k.isReadyToReceiveMail() && Math.random() < CORONA_FACTOR) {
        sendMarketingMail(k);
      }
    }
  }
  public static void main(String[] args) throws InterruptedException, SQLException {


    System.out.println("Marketing Start");
    Marketing m = new Marketing(DatabaseAD.create(), new WetterGetter(), new GMail());

    while (true) {
      System.out.println("Starte Marketing.");
      m.steuerungAltM();
      System.out.println("Fertig! Schlafe für 6 Stunden");
      Thread.sleep(SECHS_STUNDEN);
    }
  }


}
