package gelato.marketing;

import static gelato.marketing.Texte.cassata;
import static gelato.marketing.Texte.gelato;
import static gelato.marketing.Texte.granita;
import static gelato.marketing.Texte.pannaCotta;
import static gelato.marketing.Texte.tiramisu;
import static gelato.marketing.Texte.waffelnUndKaffee;
import static gelato.marketing.Texte.zuppaInglese;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;


import gelato.external.Kalender;
import gelato.mailversand.Mail;
import gelato.wetter.Wetter;
import gelato.wetter.WetterDienst;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MarketingCore {

  private final WetterDienst wetterDienst;
  private final Kalender kalender;

  public MarketingCore(WetterDienst wetterDienst, Kalender kalender) {
    this.wetterDienst = wetterDienst;
    this.kalender = kalender;
  }

  public Mail createMail(String name) {
    LocalDateTime now = kalender.now();
    Wetter wetter = wetterDienst.wetterDaten();
    DayOfWeek tag = now.getDayOfWeek();
    boolean frueh = now.getHour() > 6 && now.getHour() < 10;

    // Wetter Logic
    if (wetter.istHeiss() && wetter.istTrocken()) {
      if (frueh) {
        return granita(name);
      }
      return gelato(name);
    }
    else if (wetter.istKalt()) {
      return waffelnUndKaffee(name);
    }
    else {
      if (tag.equals(SATURDAY) || tag.equals(SUNDAY)) {
        return zuppaInglese(name);
      }
      if (tag.equals(MONDAY) || tag.equals(WEDNESDAY)) {
        return cassata(name);
      }
      if (tag.equals(TUESDAY) || tag.equals(THURSDAY)) {
        return tiramisu(name);
      }
      if (tag.equals(FRIDAY)) {
        return pannaCotta(name);
      }
    }
    return new Mail("", "");
  }
}
