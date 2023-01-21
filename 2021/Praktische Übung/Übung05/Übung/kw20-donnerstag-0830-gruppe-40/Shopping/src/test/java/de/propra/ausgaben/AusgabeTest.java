package de.propra.ausgaben;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AusgabeTest {

    public String[] input(String input){
        String[] parts = input.split(" ");
        return parts;

    }


    @Test
    @DisplayName("nehme unterschiedliche Kategorien, rufe report details und erwarten richtige Ausgabe")
    public void test(){
        FakeOutput fakeOutput = new FakeOutput();
        Ausgabenbuch ausgabenbuch = new Ausgabenbuch(fakeOutput);
        ausgabenbuch.add(input("add Aldi Lebensmittel 20"));
        ausgabenbuch.add(input("add Aldi Spiele 30"));
        ausgabenbuch.report(input("report details Aldi"));
        assertThat(fakeOutput.output.get(2)).isEqualTo("Lebensmittel: 20.00");
        assertThat(fakeOutput.output.get(3)).isEqualTo("Spiele: 30.00");


    }
}
