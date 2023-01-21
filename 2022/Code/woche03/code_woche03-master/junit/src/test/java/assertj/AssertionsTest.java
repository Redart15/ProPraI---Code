package assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsTest {


  @Test
  @DisplayName("Experimente um AssertJ auszuprobieren")
  void list_test() {

    AbstractIntegerAssert<?> integerAssert = assertThat(3 - 1);

    List<Integer> list = List.of(3, 4, 1, 7, 6, 2);


    ListAssert<Integer> listAssert = assertThat(list);

    //listAssert.contains(4,5);

    assertThat(list.get(4)).isEqualTo(6);

    // Vorsicht! Mehr als eine Assertion sollten wir nur verwenden,
    // wenn die Assertions gemeinsam einen Sachverhalt überprüfen.
    assertThat(list)
        .contains(7, 2)
        .hasSize(6)
        .containsSubsequence(3, 1, 2)
        .containsExactlyInAnyOrder(1, 2, 3, 4, 6, 7)
        .doesNotContain(5, 0, 8);
  }

  @Test
  void vorsicht() {
    assertThat(true == false);
  }

  @Test
  @Disabled("Test schlägt fehl. Demo für eigene Fehlermessage")
  void beschreibung() {
    assertThat(1)
        .describedAs("Hier könnte Ihre Nachricht stehen!")
        .isGreaterThanOrEqualTo(2);
  }

  @Test
  @Disabled("Test schlägt fehl! Achtung, beim ersten Fehlschlag wird abgebrochen")
  void beschreibung_problem() {
    assertThat(1)
        .isGreaterThanOrEqualTo(2)
        .describedAs("Hier könnte Ihre Nachricht stehen!");
  }


}
