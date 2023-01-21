package gelato.db;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Kunde {

    private final long id;
    private final String name;
    private final String email;
    private LocalDate lastmail;

    public Kunde(long id, String name, String email, LocalDate lastmail) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastmail = lastmail;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Kunden werden maximal einmal pro 10 Tage angemailt!
    public boolean isReadyToReceiveMail() {
        long daysSinceLastMail = ChronoUnit.DAYS.between(lastmail, LocalDate.now());
        return daysSinceLastMail >= 10;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastmail=" + lastmail +
                '}';
    }

    public long getId() {
        return id;
    }
}
