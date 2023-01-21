package odyssee;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Stream;

import static odyssee.Odyssee.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OdysseeTest {

    private static LocalDateTime parseTime(String time) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(time)), TimeZone
                .getDefault().toZoneId());
    }

    @Test
    @DisplayName("Es wird eine Liste erzeugt mit Einträgen")
    void test_01(){
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1", "2"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        //Assert
        assertThat(liste.get(0).answertime()).isEqualTo(2);
        assertThat(liste.get(0).time()).isEqualTo(parseTime("1"));
        assertThat(liste.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Es wird die minimale Antwortzeit ausgegeben")
    void test_02() {
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1", "2","5","1","77","100"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        int result = minimumAnswerTime(liste);
        //Assert
        assertThat(result).isEqualTo(1);

    }@Test
    @DisplayName("Es wird die maximale Antwortzeit ausgegeben")
    void test_03() {
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1", "2","5","1","77","100"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        int result = maximumAnswerTime(liste);
        //Assert
        assertThat(result).isEqualTo(100);
    }

    @Test
    @DisplayName("Es wird die durchschnittliche Antwortzeit ausgegeben")
    void test_04() {
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1", "2","3","3", "2", "1"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        double result = averageAnswerTime(liste);
        //Assert
        assertThat(result).isCloseTo(2.0, Offset.offset(0.1));
    }

    @Test
    @DisplayName("Ob das Histogramm für die Werter richtig ausgeben wird")
    void test_05() {
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1","200","3","340","2","332"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        Map<Integer,Integer> result = histogrammAnswertime(liste);
        //Assert
        assertThat(result.get(300)).isEqualTo(2);
    }

    @Test
    @DisplayName("Ob das Histogramm für die Werter richtig ausgeben wird")
    void test_06() {
        //Arrange
        Odyssee odyssee = new Odyssee();
        String[] x = {"1","200","3","340","2","332"};
        Stream<String> lines = Arrays.stream(x);
        //Act
        List<Eintrag> liste = odyssee.parseEintragListe(lines);
        Map<Integer,Integer> result = histogrammAnswertime(liste);
        //Assert
        assertThat(result.get(300)).isEqualTo(2);
    }
}