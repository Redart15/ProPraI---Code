package odyssee;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OdysseeTest {

    @Nested
    class Basisdaten {
        @Test
        @DisplayName("minimaleAntwortzeit mehrerer Einträge korrekt berechnet")
        void test_1() {
            assertThat(Odyssee.minimaleAntwortzeit(eintraege())).isEqualTo(2);
        }

        @Test
        @DisplayName("minimaleAntwortzeit einer leeren Liste ist 0")
        void test_2() {
            assertThat(Odyssee.minimaleAntwortzeit(List.of())).isZero();
        }

        @Test
        @DisplayName("maximaleAntwortzeit mehrerer Einträge korrekt berechnet")
        void test_3() {
            assertThat(Odyssee.maximaleAntwortzeit(eintraege())).isEqualTo(10_001);
        }

        @Test
        @DisplayName("maximaleAntwortzeit einer leeren Liste ist 0")
        void test_4() {
            assertThat(Odyssee.maximaleAntwortzeit(List.of())).isZero();
        }

        @Test
        @DisplayName("mittlereAntwortzeit mehrerer Einträge korrekt berechnet")
        void test_5() {
            assertThat(Odyssee.mittlereAntwortzeit(eintraege())).isCloseTo((10 + 20 + 100 + 200 + 10_001 + 10_000 + 2) / 7.0,
                    Offset.offset(1.));
        }

        @Test
        @DisplayName("mittlereAntwortzeit einer leeren Liste ist 0")
        void test_6() {
            assertThat(Odyssee.mittlereAntwortzeit(List.of())).isZero();
        }
    }

    @Nested
    class Histogramm {
        @Test
        @DisplayName("Histogramm wird für mehrere Werte korrekt berechnet")
        void test_1() {
            Map<Integer, Integer> histogramm = Odyssee.histogramm(eintraege());
            assertThat(histogramm).isEqualTo(Map.of(0, 3, 100, 1, 200, 1, 10_000, 2));
        }

        @Test
        @DisplayName("Histogramm für eine leere Eingabe ist leer")
        void test_2() {
            Map<Integer, Integer> histogramm = Odyssee.histogramm(List.of());
            assertThat(histogramm).isEqualTo(Map.of());
        }
    }

    @Nested
    class MittlereAntwortzeit {
        @Test
        @DisplayName("Mittlere Antwortzeit gruppiert nach Wochentag korrekt für mehrere Einträge berechnet")
        void test_1() {
            Map<DayOfWeek, Double> antwortzeiten = Odyssee.mittlereAntwortzeitProWochentag(eintraege());
            assertThat(antwortzeiten).containsOnlyKeys(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
            assertThat(antwortzeiten.get(DayOfWeek.MONDAY)).isCloseTo(33, Offset.offset(0.1));
            assertThat(antwortzeiten.get(DayOfWeek.TUESDAY)).isCloseTo(6733.7, Offset.offset(0.1));
        }

        @Test
        @DisplayName("Mittlere Antwortzeit gruppiert nach Wochentag funktioniert für leere Eingabe")
        void test_2() {
            Map<DayOfWeek, Double> antwortzeiten = Odyssee.mittlereAntwortzeitProWochentag(List.of());
            assertThat(antwortzeiten).isEmpty();
        }

        @Test
        @DisplayName("Mittlere Antwortzeit gruppiert nach Stunden korrekt für mehrere Einträge berechnet")
        void test_3() {
            Map<Integer, Double> antwortzeiten = Odyssee.mittlereAntwortzeitProStunde(eintraege());
            assertThat(antwortzeiten).containsOnlyKeys(12, 13, 14);
            assertThat(antwortzeiten.get(12)).isCloseTo(10.7, Offset.offset(0.1));
            assertThat(antwortzeiten.get(13)).isCloseTo(3433.7, Offset.offset(0.1));
            assertThat(antwortzeiten.get(14)).isCloseTo(10_000, Offset.offset(0.1));
        }

        @Test
        @DisplayName("Mittlere Antwortzeit gruppiert nach Stunden funktioniert für leere Eingabe")
        void test_4() {
            Map<Integer, Double> antwortzeiten = Odyssee.mittlereAntwortzeitProStunde(List.of());
            assertThat(antwortzeiten).isEmpty();
        }
    }

    @Nested
    class EntwicklungUeberDieZeit {
        @Test
        @DisplayName("Schnitt für Montage 12 Uhr wird korrekt ermittelt")
        void test_1() {
            Map<Integer, Double> antwortzeiten = Odyssee.entwicklungUeberZeit(eintraege(), DayOfWeek.MONDAY, 12);
            assertThat(antwortzeiten).containsOnlyKeys(26, 27);
            assertThat(antwortzeiten.get(26)).isCloseTo(15, Offset.offset(1.0));
            assertThat(antwortzeiten.get(27)).isCloseTo(2, Offset.offset(1.0));
        }

        @Test
        @DisplayName("Schnitt bei leerer Eingabe ist leer")
        void test_2() {
            Map<Integer, Double> antwortzeiten = Odyssee.entwicklungUeberZeit(List.of(), DayOfWeek.MONDAY, 12);
            assertThat(antwortzeiten).isEmpty();
        }
    }

    @Nested
    class Verfuegbarkeit {
        @Test
        @DisplayName("Verfügbarkeit über mehrere Einträge hinweg wird korrekt berechnet, wobei >10_000 ms nicht verfügbar bedeutet")
        void test_1() {
            assertThat(Odyssee.mittlereVerfuegbarkeit(eintraege())).isCloseTo(6.0 / 7, Offset.offset(0.01));
        }

        @Test
        @DisplayName("Verfügbarkeit vor Start der Messung ist 0")
        void test_2() {
            assertThat(Odyssee.mittlereVerfuegbarkeit(List.of())).isZero();
        }
    }

    private List<Eintrag> eintraege() {
        return List.of(
                new Eintrag(LocalDateTime.of(2022, 6, 27, 12, 21, 0), 10),
                new Eintrag(LocalDateTime.of(2022, 6, 27, 12, 59, 0), 20),
                new Eintrag(LocalDateTime.of(2022, 6, 27, 13, 21, 0), 100),
                new Eintrag(LocalDateTime.of(2022, 6, 28, 13, 21, 0), 200),
                new Eintrag(LocalDateTime.of(2022, 6, 28, 13, 40, 0), 10_001),
                new Eintrag(LocalDateTime.of(2022, 6, 28, 14, 21, 0), 10_000),
                new Eintrag(LocalDateTime.of(2022, 7, 4, 12, 1, 0), 2));
    }

}
