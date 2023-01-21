package mail;

import wetter.IWetter;
import wetter.Wetter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.time.DayOfWeek.*;


public class CreateMarketingMail implements ICreateMarketingMail {
    private IWetter wetterService;
    private LocalDateTime now;

    public CreateMarketingMail(IWetter wetter, LocalDateTime now) {
        this.wetterService = wetter;
        this.now = now;
    }

    public Mail createMail(String name) {
//        CreateMarketingMail marketingMail = new CreateMarketingMail(wetter, now);
        Wetter wetter = wetterService.wetterDaten();
        DayOfWeek tag = now.getDayOfWeek();
        boolean frueh = now.getHour() > 6 && now.getHour() < 10;

        // Wetter Logic
        if (wetter.istHeiss() && wetter.istTrocken()) {
            if (frueh) {
                return Gerichte.granita(name);
            }
            return Gerichte.gelato(name);
        }
        else if (wetter.istKalt()) {
            return Gerichte.waffelnUndKaffee(name);
        }
        else {
            if (tag.equals(SATURDAY) || tag.equals(SUNDAY)) {
                return Gerichte.zuppaInglese(name);
            }
            if (tag.equals(MONDAY) || tag.equals(WEDNESDAY)) {
                return Gerichte.cassata(name);
            }
            if (tag.equals(TUESDAY) || tag.equals(THURSDAY)) {
                return Gerichte.tiramisu(name);
            }
            if (tag.equals(FRIDAY)) {
                return Gerichte.pannaCotta(name);
            }
        }
        return new Mail("", "");
    }
}
