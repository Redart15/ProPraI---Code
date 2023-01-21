package assumption;

import java.time.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;

import java.util.List;


import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class AssumeTest {

    @Test
    void test_only_on_monday() {
        DayOfWeek today = now().getDayOfWeek();
        DayOfWeek tomorrow = today.plus(1);
        assumeThat(today).isEqualTo(tomorrow);
        assertThat(true).isFalse();
    }

}
