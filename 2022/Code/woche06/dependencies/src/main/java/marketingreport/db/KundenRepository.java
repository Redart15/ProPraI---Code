package marketingreport.db;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


// Diese Klasse simuliert eine Kundendatenbank. Die Details sind nicht wichtig.
public class KundenRepository {

    // Füllen mit 40 Fake Kunden
    private final List<Kunde> kunden = initKunden();

    // Simulation einer Datenbankanfrage
    public List<Kunde> getAlleKunden() {
        return kunden;
    }

    private List<Kunde> initKunden() {
        Faker faker = new Faker(Locale.GERMANY);
        Random r = new Random();

        ArrayList<Kunde> kunden = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Name fakename = faker.name();
            String name = fakename.firstName() + " " + fakename.lastName();
            String plz = faker.address().zipCode();
            int alter = r.nextInt(80) + 18;
            kunden.add(new Kunde(name, plz, alter));
        }
        return kunden;
    }

}
