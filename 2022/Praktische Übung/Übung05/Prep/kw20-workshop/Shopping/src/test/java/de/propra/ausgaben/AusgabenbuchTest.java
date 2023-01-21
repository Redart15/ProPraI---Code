package de.propra.ausgaben;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AusgabenbuchTest {
    @Test
    @DisplayName("Inputstream finden")
    void test_1(){
        FakeOutput fakeoutput = new FakeOutput();
        Ausgabenbuch buch = new Ausgabenbuch(fakeoutput);
        buch.add(new String[]{"add","Lidl","M","34"});
        assertThat(fakeoutput.output.get(0)).isEqualTo("Hinzugefuegt zum Shop Lidl in der Kategorie M: 34.00\n");
    }
}
